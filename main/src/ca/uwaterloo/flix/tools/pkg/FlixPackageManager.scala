/*
 * Copyright 2023 Magnus Madsen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.uwaterloo.flix.tools.pkg

import ca.uwaterloo.flix.api.Bootstrap
import ca.uwaterloo.flix.tools.pkg.Dependency.FlixDependency
import ca.uwaterloo.flix.tools.pkg.github.GitHub
import ca.uwaterloo.flix.util.Result.{Err, Ok, ToOk}
import ca.uwaterloo.flix.util.Result

import java.io.{IOException, PrintStream}
import java.nio.file.{Files, Path, StandardCopyOption}
import scala.util.Using

object FlixPackageManager {

  /**
    * Installs all the Flix dependencies for a Manifest at the /lib folder
    * of `path` and returns a list of paths to all the dependencies.
    */
  def installAll(manifest: Manifest, path: Path)(implicit out: PrintStream): Result[List[Path], PackageError] = {
    out.println("Resolving Flix dependencies...")

    val flixDeps = findFlixDependencies(manifest)
    flixDeps.flatMap(dep => {
      val depName: String = s"${dep.username}/${dep.projectName}"
      install(depName, dep.version, path) match {
        case Ok(l) => l
        case Err(e) => out.println(s"ERROR: Installation of `$depName' failed."); return Err(e)
      }
    }).toOk
  }

  /**
    * Installs a flix package from the Github `project`.
    *
    * `project` must be of the form `<owner>/<repo>`
    *
    * The package is installed at `lib/<owner>/<repo>`
    *
    * Returns a list of paths to the downloaded files.
    */
  def install(project: String, version: SemVer, p: Path)(implicit out: PrintStream): Result[List[Path], PackageError] = {
    GitHub.parseProject(project).flatMap {
      proj =>
        GitHub.getSpecificRelease(proj, version).flatMap {
          release =>
            val assets = release.assets.filter(_.name.endsWith(".fpkg"))
            val lib = Bootstrap.getLibraryDirectory(p)
            val assetFolder = createAssetFolderPath(proj, release, lib)

            // create the asset directory if it doesn't exist
            Files.createDirectories(assetFolder)

            // download each asset to the folder
            for (asset <- assets) {
              val assetName = asset.name
              val path = assetFolder.resolve(assetName)
              val newDownload = !Files.exists(path)
              if (newDownload) {
                out.print(s"  Downloading `$project/$assetName' (v$version)... ")
                out.flush()
                try {
                  Using(GitHub.downloadAsset(asset)) {
                    stream => Files.copy(stream, path, StandardCopyOption.REPLACE_EXISTING)
                  }
                } catch {
                  case _: IOException => return Err(PackageError.DownloadError(s"Error occurred while downloading $assetName"))
                }
                out.println(s"OK.")
              } else {
                out.println(s"  Cached `$project/$assetName' (v$version).")
              }
            }
            assets.map(asset => assetFolder.resolve(asset.name)).toOk
        }
    }
  }

  /**
    * Creates a path from the `lib` folder to where assets should be stored.
    * The path will look like this: `lib`/owner/repo/verX.X.X.
    */
  private def createAssetFolderPath(proj: GitHub.Project, release: GitHub.Release, lib: Path): Path = {
    lib.resolve(proj.owner).resolve(proj.repo).resolve(s"ver${release.version.toString()}")
  }

  /**
    * Finds the Flix dependencies in a Manifest.
    */
  private def findFlixDependencies(manifest: Manifest): List[FlixDependency] = {
    manifest.dependencies.collect { case dep: FlixDependency => dep }
  }

}

package ca.uwaterloo.flix.language.phase

import ca.uwaterloo.flix.TestUtils
import ca.uwaterloo.flix.api.Flix
import ca.uwaterloo.flix.language.errors.ParseError
import org.scalatest.FunSuite

class TestParser extends FunSuite with TestUtils {
  test("ParseError.Int.01") {
    val input =
      s"""
         |def f(): Int = 1_
       """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int.02") {
    val input =
      s"""
         |def f(): Int = 1_000_
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int.03") {
    val input =
      s"""
         |def f(): Int = 0b_1
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int.04") {
    val input =
      s"""
         |def f(): Int = 0b1_
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int.05") {
    val input =
      s"""
         |def f(): Int = 0x_1
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int.06") {
    val input =
      s"""
         |def f(): Int = 0x1_
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int8.01") {
    val input =
      s"""
         |def f(): Int8 = 1_i8
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int8.02") {
    val input =
      s"""
         |def f(): Int8 = 1_000_i8
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int8.03") {
    val input =
      s"""
         |def f(): Int8 = 0b_1i8
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int8.04") {
    val input =
      s"""
         |def f(): Int8 = 0b1_i8
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int8.05") {
    val input =
      s"""
         |def f(): Int8 = 0x_1i8
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int8.06") {
    val input =
      s"""
         |def f(): Int8 = 0x1_i8
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int16.01") {
    val input =
      s"""
         |def f(): Int16 = 1_i16
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int16.02") {
    val input =
      s"""
         |def f(): Int16 = 1_000_i16
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int16.03") {
    val input =
      s"""
         |def f(): Int16 = 0b_1i16
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int16.04") {
    val input =
      s"""
         |def f(): Int16 = 0b1_i16
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int16.05") {
    val input =
      s"""
         |def f(): Int16 = 0x_1i16
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int16.06") {
    val input =
      s"""
         |def f(): Int16 = 0x1_i16
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int32.01") {
    val input =
      s"""
         |def f(): Int32 = 1_i32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int32.02") {
    val input =
      s"""
         |def f(): Int32 = 1_000_i32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int32.03") {
    val input =
      s"""
         |def f(): Int32 = 0b_1i32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int32.04") {
    val input =
      s"""
         |def f(): Int32 = 0b1_i32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int32.05") {
    val input =
      s"""
         |def f(): Int32 = 0x_1i32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int32.06") {
    val input =
      s"""
         |def f(): Int32 = 0x1_i32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int64.01") {
    val input =
      s"""
         |def f(): Int64 = 1_i64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int64.02") {
    val input =
      s"""
         |def f(): Int64 = 1_000_i64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int64.03") {
    val input =
      s"""
         |def f(): Int64 = 0b_1i64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int64.04") {
    val input =
      s"""
         |def f(): Int64 = 0b1_i64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int64.05") {
    val input =
      s"""
         |def f(): Int64 = 0x_1i64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Int64.06") {
    val input =
      s"""
         |def f(): Int64 = 0x1_i64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.BigInt.01") {
    val input =
      s"""
         |def f(): BigInt = 1_ii
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.BigInt.02") {
    val input =
      s"""
         |def f(): BigInt = 1_000_ii
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.BigInt.03") {
    val input =
      s"""
         |def f(): BigInt = 0b_1ii
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.BigInt.04") {
    val input =
      s"""
         |def f(): BigInt = 0b1_ii
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.BigInt.05") {
    val input =
      s"""
         |def f(): BigInt = 0x_1ii
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.BigInt.06") {
    val input =
      s"""
         |def f(): BigInt = 0x1_ii
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float.01") {
    val input =
      s"""
         |def f(): Float = 1_.0
       """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float.02") {
    val input =
      s"""
         |def f(): Float = 1_000_.0
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float.03") {
    val input =
      s"""
         |def f(): Float = 1.0_
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float32.01") {
    val input =
      s"""
         |def f(): Float32 = 1_.0f32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float32.02") {
    val input =
      s"""
         |def f(): Float32 = 1_000_.0f32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float32.03") {
    val input =
      s"""
         |def f(): Float32 = 1.0_f32
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float64.01") {
    val input =
      s"""
         |def f(): Float64 = 1_.0f64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float64.02") {
    val input =
      s"""
         |def f(): Float64 = 1_000_.0f64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }

  test("ParseError.Float64.03") {
    val input =
      s"""
         |def f(): Float64 = 1.0_f64
         """.stripMargin
    val result = new Flix().addStr(input).compile()
    expectError[ParseError](result)
  }
}
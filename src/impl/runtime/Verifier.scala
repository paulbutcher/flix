package impl.runtime

import impl.logic.Symbol.{PredicateSymbol => PSym, VariableSymbol => VSym}
import impl.logic._
import syntax.Symbols._

/**
 * A verifier / type checker.
 */
class Verifier(val program: Program) {

  /**
   * Verifies that the program is safe.
   */
  def verify(): Unit = {
    /**
     * Every predicate must have en interpretation.
     */
    for (p <- program.predicates) {
      program.interpretation.get(p) match {
        case None => throw Error.InterpretationNotFound(p)
        case Some(i) => // nop - interpretation exists.
      }
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  // Lattice Properties                                                      //
  /////////////////////////////////////////////////////////////////////////////

  /**
   * Function: ∀x, y. x = y ⇒ f(x) = f(y).
   */
  def function(f: PSym): Formula = typer(
    Formula.Implication(
      Formula.Atom(Predicate(Symbol.PredicateSymbol("Eq"), List(
        Term.Variable(Symbol.VariableSymbol("x")),
        Term.Variable(Symbol.VariableSymbol("y"))
      ))),

      // TODO: Need some notion of equality??
      Formula.Conjunction(Set(
        Formula.Atom(Predicate(Symbol.PredicateSymbol("Eq"), List(
          Term.Variable(Symbol.VariableSymbol("fx")),
          Term.Variable(Symbol.VariableSymbol("fy"))
        )))
      ))
    )
  )

  /**
   * ⨆ is total
   */
  trait JoinTotal

  /**
   * Join is Join
   * 1. x ⊑ x ⨆ y ∧ y ⊑ x ⨆ y
   *
   * 2. ∀z, x ⊑ z ∧ y ⊑ z ⇒ x ⨆ y = z
   */
  trait JoinIsJoin

  /**
   * Monotonicity: ∀x, x ⊑ y ⇒ f(x) ⊑ f(y).
   */
  def monotonicity(f: PSym, leq: PSym): Formula = ???

  /**
   * Strictness: f(⊥) = ⊥
   */
  // TODO
  trait Strictness

  /**
   * Distributivity: ∀x, y, f(x ⨆ y) = f(x) ⨆ f(y).
   */
  // TODO
  trait Distributivity
}

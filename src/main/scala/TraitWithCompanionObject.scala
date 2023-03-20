package org.rwaterbury.scaladev

trait TraitWithCompanionObject[A] {
  def doSomething(thing: A): A
}

object TraitWithCompanionObject {
  implicit val IntTraitWithCompanionObject: TraitWithCompanionObject[Int] =
    new TraitWithCompanionObject[Int] {
      def doSomething(thing: Int): Int = thing * 2
    }
}

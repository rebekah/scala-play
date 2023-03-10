package org.rwaterbury.scaladev

object ExploreContextBounds {
//My understanding of Context Bounds are that they are syntactic sugar that states
//if a definition has a variable type of [A: B] then an implicit B[A] is in scope.

  implicit val intOrd: Ord[Int] = new Ord[Int] {
    def max(x: Int, y: Int) =
      if (x <= y) x else y
  }

  def max[A](x: A, y: A)(implicit ord: Ord[A]) =
    ord.max(x, y)

  // Scala 2 verbose example
  // With this setup I get the error: Found(ord: org.rwaterbury.scaladev.Ord[A]) Required ((A,A) => A)
  // def maximumVerboseScala2[A](xs: List[A])(implicit ord: Ord[A]): A =
  //   xs.reduceLeft(max(ord))

  // Scala 3 verbose example
  // With this setup I get the error: Missing arguments for method max in object ExploreContextBounds
  //def maximumVerboseScala3[A](xs: List[A])(using ord: Ord[A]): A =
  //  xs.reduceLeft(max(using ord))

  // Scala2 and Scala3 context bound example
  def maximumContextBound[A: Ord](xs: List[A]): A =
    xs.reduceLeft(max)
}

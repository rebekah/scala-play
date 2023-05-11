package org.rwaterbury.scaladev
package typeclassandvariants

trait FoldableContravariant[-T] {
  def fold(item: T): String
  def whereAmI: String
}

object FoldableContravariant{
  implicit val foldableClothing: FoldableContravariant[Clothing] = new FoldableContravariant[Clothing] {
    def fold(item: Clothing) = s"The ${item.name} is folded."
    def whereAmI = "inside foldableClothing"
  }

  implicit val foldableShirt: FoldableContravariant[Shirt] = new FoldableContravariant[Shirt] {
    def fold(item: Shirt) = s"The ${item.name} is folded."
    def whereAmI = "inside foldableShirt"
  }
}



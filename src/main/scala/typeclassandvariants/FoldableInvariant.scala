package org.rwaterbury.scaladev
package typeclassandvariants

trait FoldableInvariant[T] {
  def fold(item: T): String
}

object FoldableInvariant{
  implicit val foldableClothing: FoldableInvariant[Clothing] = new FoldableInvariant[Clothing] {
    def fold(item: Clothing) = s"The ${item.name} is folded."
  }
  implicit val foldableShirt: FoldableInvariant[Shirt] = new FoldableInvariant[Shirt] {
    def fold(item: Shirt) = s"The ${item.name} is folded."
  }
}


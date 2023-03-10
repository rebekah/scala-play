package org.rwaterbury.scaladev

trait Ord[A] {
  def max(x: A, y: A): A
}

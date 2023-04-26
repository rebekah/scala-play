package org.rwaterbury.scaladev

object VarArgs {
  
  def duplicate(x: String) = x + x
  def paramsToListDuplicated(strings: String*) = {
    strings.map(duplicate)
  }
}

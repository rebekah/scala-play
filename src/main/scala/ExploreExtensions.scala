package org.rwaterbury.scaladev

object ExploreExtensions {
  extension (str: String) {
    def snakeCase = {
      str.replaceAll("([A-Z])", "_" + "$1").toLowerCase
    }
  }
  extension[T](list: List[T]) {
    def getSecond: Option[T] = if(list.isEmpty) None else list.tail.headOption
  }
}

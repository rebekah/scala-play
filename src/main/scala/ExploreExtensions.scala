package org.rwaterbury.scaladev

object ExploreExtensions {
  extension (str: String) {
    def snakeCase = {
      str.replaceAll("([A-Z])", "_" + "$1").toLowerCase
    }
  }
}

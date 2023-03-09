package org.rwaterbury.scaladev

import ExploreExtensions._

class ExploreExtensionsSpec extends FreeSpecStyle {
  "when playing with extensions" - {
    "for String" - {
      "they work" in {
        assert("myTestOfSnakeCase".snakeCase == "my_test_of_snake_case")
      }
    }
  }
}

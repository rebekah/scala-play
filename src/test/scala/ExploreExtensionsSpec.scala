package org.rwaterbury.scaladev

import ExploreExtensions._

class ExploreExtensionsSpec extends FreeSpecStyle {
  "when playing with extensions" - {
    "for String" - {
      "they work" in {
        assert("myTestOfSnakeCase".snakeCase == "my_test_of_snake_case")
      }
    }

    "for variable type extensions" - {
      "for a list" - {
        "getSecond" - {
          "when the list is empty" - {
            "it returns a None" in {
              List.empty[Int].getSecond shouldBe None
            }
          }
          "when the list has one element" - {
            "it returns a None" in {
              List("a").getSecond shouldBe None
            }
          }

          "when the list has more than one element" - {
            "it returns the second element" in {
              List(List(1), List(2)).getSecond shouldBe Option(List(2))
            }
          }
        }
      }
    }
  }
}

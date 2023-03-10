package org.rwaterbury.scaladev

import ExploreContextBounds._

class ExploreContextBoundsSpec extends FreeSpecStyle {
  "when testing examples in the Scala3 book for Context Bounds" - {
    "the implementation of the verbose Scala2 example" - {
      "works for type Int" in {
        maximumVerboseScala2(List(1,1,7,3)) shouldBe 7
      }
    }
    "the implementation of the verbose Scala3 example" - {
      "works for type Int" in {
        maximumVerboseScala3(List(1, 1, 7, 3)) shouldBe 7
      }
    }
    "the implementation of the context bounds for Scala2 and Scala3" - {
      "works for type Int" in {
        maximumContextBound(List(1,1,7,3)) shouldBe 7
      }
    }
  }
}

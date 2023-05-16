package org.rwaterbury.scaladev.typeclassandvariants

import org.rwaterbury.scaladev.FreeSpecStyle


class ExploreTypeClassVariantsSpec extends FreeSpecStyle {
  "when a type of the type class is invariant" - {
    def testInvariant[T](item: T)(implicit typeClass: FoldableInvariant[T]): String = {
      typeClass.fold(item)
    }
    "and the type is Shirt" - {
      "it will find the implicit instance for Shirt" in {
        testInvariant(new Shirt) shouldBe "The shirt is folded."
      }
    }
    "and the type is Clothing" - {
      "it will find the implicit instance for Clothing" in {
        testInvariant(new Clothing) shouldBe "The clothing is folded."
      }
    }
  }

  "when a type of the type class is contravariant" - {
    def testContravariant[T](implicit typeClass: FoldableContravariant[T]): String = {
      typeClass.whereAmI
    }

    "and the type is TankTop" - {
      "and there is no defined type for TankTop" - {
        "it will find an implicit instance for type Shirt" in {
          testContravariant[TankTop] shouldBe "inside foldableShirt"
        }
      }
    }
    "and the type is Shirt" - {
      "and there is an instance for the supertype Clothing" - {
        "it will find the an implicit instance for Shirt" in {
          testContravariant[Shirt] shouldBe "inside foldableShirt"
        }
      }
    }
    "and the type is Clothing" - {
      "it will find the an implicit instance for Clothing" in {
        testContravariant[Clothing] shouldBe "inside foldableClothing"
      }
    }
  }

  "when a type of the type class is covariant" - {
    def testCovariant[T](implicit typeClass: ReturnMeCovariant[T]) = {
      typeClass.whereAmI
    }
    "and the type is Clothing" - {
      "it will find an implicit instance for the furtherest subtype" in {
        testCovariant[Clothing] shouldBe "in returnableTankTop"
      }
    }
    "and the type is Shirt" - {
      "it will find the an implicit instance for the furtherest subtype" in {
        testCovariant[Shirt] shouldBe "in returnableTankTop"
      }
    }
    "and the type is TankTop" - {
      "it will find the an implicit instance for TankTop" in {
        testCovariant[TankTop] shouldBe "in returnableTankTop"
      }
    }
    "and when the type is Clothing" - {
      "and there is another type class at the same level of specificity as TankTop" - {
        "that's defined locally" - {
          implicit val returnableBlouse: ReturnMeCovariant[Blouse] = new ReturnMeCovariant[Blouse]:
            override def childType = None
            override def whereAmI = "in returnableBlouse"

          "it will pick up the instance for Blouse" in {
            testCovariant[Clothing] shouldBe "in returnableBlouse"
          }
        }
      }
    }
  }
}

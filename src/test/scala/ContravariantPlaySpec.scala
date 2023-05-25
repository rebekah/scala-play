package org.rwaterbury.scaladev

class ContravariantPlaySpec extends FreeSpecStyle {
  "for contravariant type classes" - {
    "if the type referenced has a type class instance in scope" - {
      "it will use it" in {
        ContravariantPlay.danceSomething(new Cat) shouldBe "jump jump stretch"
        ContravariantPlay.whereAmI[Cat] shouldBe "in a Movement[Cat] instance"
      }
    }
    "if the type referenced does not have a type class instance in scope" - {
      "it will find a an instance of a parent type" - {
        "and use it" in {
          ContravariantPlay.danceSomething(new Pants) shouldBe "jump jump stretch"
          ContravariantPlay.whereAmI[Pants] shouldBe "in a Movement[Clothing] instance"
        }
      }
    }
  }
}

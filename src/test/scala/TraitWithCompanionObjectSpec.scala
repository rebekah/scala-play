package org.rwaterbury.scaladev

class TraitWithCompanionObjectSpec extends FreeSpecStyle {
  "testing the scope of type class instance" - {
    "when the instance is defined in the companion object" - {
      "for the Int type" in {
        def usesImplictIntClass(num: Int)(implicit typeClassInstance: TraitWithCompanionObject[Int]) = {
          typeClassInstance.doSomething(num)
        }
        usesImplictIntClass(3) shouldBe 6
      }
    }
  }
}

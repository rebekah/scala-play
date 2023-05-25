package org.rwaterbury.scaladev

class Jacket {
  def genericWashingInstructions = "please read label"
}

class FauxFirJacket extends Jacket {
  def specificWashingInstructions = "dry clean only"
}

object PlayingWithMethodSubstitution {
  def aMethodWithTheExpectedTypes(
    fauxFirJacket: FauxFirJacket
  ): AnyRef = fauxFirJacket.specificWashingInstructions

  def aMethodWithOtherTypes(jacket: Jacket): String =
    jacket.genericWashingInstructions

  def takesAMethod(
    fauxFirJacket: FauxFirJacket,
    substitutable: FauxFirJacket => AnyRef
  ) = substitutable(fauxFirJacket)
}

class MethodVarianceSubstitutionSpec extends FreeSpecStyle {
  val fauxFirJacket = new FauxFirJacket
  "running with a method defined to take the stated parameter type" - {
    "and return the expected return type" - {
      "will work" in {
        PlayingWithMethodSubstitution.takesAMethod(
          fauxFirJacket,
          PlayingWithMethodSubstitution.aMethodWithTheExpectedTypes
        ) shouldBe "dry clean only"
      }
    }
  }

  "running with a method defined to take a supertype of the parameter type" - {
    "and return a subtype of the expected return type" - {
      "will work" in {
        PlayingWithMethodSubstitution.takesAMethod(
          fauxFirJacket,
          PlayingWithMethodSubstitution.aMethodWithOtherTypes
        ) shouldBe "please read label"
      }
    }
  }
}

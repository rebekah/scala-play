package org.rwaterbury.scaladev

class CovariantPlaySpec extends FreeSpecStyle {
  "for covariant type classes" - {
    "it will find the most specific type" in {
      CovariantPlay.whoAmI[Automobile] shouldBe "I am a truck."
    }
  }
}

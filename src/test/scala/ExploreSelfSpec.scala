package org.rwaterbury.scaladev

trait SelfTrait {
  self =>
  val localVal = "traitVal"

  def myThisVal: String
  def mySelfVal: String

  def insideInstance =  new SelfTrait {
    override val localVal = "overrideVal"
    override def myThisVal = {
      this.localVal
    }

    override def mySelfVal = {
      self.localVal
    }
  }
}

class ExploreThisSpec extends FreeSpecStyle{
  val insideInstance = new SelfTrait {
    def myThisVal: String = "foo"
    def mySelfVal: String = "foo"
  }.insideInstance

  "when the *this* is referenced not the alias *self*" - {
    "it will reference the *this* of the trait instance" in {
      insideInstance.myThisVal shouldBe "overrideVal"
    }
  }

  "and when alias *self* is referenced" - {
    "it will reference the *this* of the trait definition" in {
      insideInstance.mySelfVal shouldBe "traitVal"
    }
  }
}

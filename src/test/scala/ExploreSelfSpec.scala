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

  "when the *this* is not aliased" - {
    "and it's on it's own" - {
      "it will reference the *this* of the trait instance" in {
        insideInstance.mySelfVal shouldBe "traitVal"
      }
    }

    "and the self is not looking at the instance with it's overides" - {
      "it will reference the this of the trait" in {
        insideInstance.myThisVal shouldBe "overrideVal"
      }
    }
  }
}
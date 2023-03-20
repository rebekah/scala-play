package org.rwaterbury.scaladev

import com.github.nscala_time.time.Imports._

class ClassWithCompanionObjectSpec extends FreeSpecStyle {
  "using the companion object for initilation" - {
    "it works" in {
      ClassWithCompanionObject.apply.oneYearAferCreationTime.getYear shouldBe DateTime.nextYear().getYear
    }
  }
}

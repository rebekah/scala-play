package org.rwaterbury.scaladev

import com.github.nscala_time.time.Imports._

class ClassWithCompanionObject(creationTime: DateTime) {
  def oneYearAferCreationTime: DateTime = creationTime + 1.year
}
object ClassWithCompanionObject {
  def apply = new ClassWithCompanionObject(DateTime.now())
}

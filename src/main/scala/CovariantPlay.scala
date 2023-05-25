package org.rwaterbury.scaladev

//parent
class Automobile

//child
class Truck extends Automobile

//typeclass
trait FindThings[+T] {
  def findInstance(): T
  def talkAboutMe: String
}

//implicit instance for parent type
implicit val automobileFind: FindThings[Automobile] = new FindThings[Automobile] {
  def findInstance(): Automobile = new Automobile
  def talkAboutMe = "I am an automobile."
}

//implicit instance for child type
implicit val catFind: FindThings[Truck] = new FindThings[Truck]{
  def findInstance(): Truck = new Truck
  def talkAboutMe = "I am a truck."
}

object CovariantPlay {
  def whoAmI[T](implicit findThings: FindThings[T]): String = findThings.talkAboutMe
}
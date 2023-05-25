package org.rwaterbury.scaladev

//parent
class Animal {
  def aMovement: String = "wiggle"
  def anotherMovement: String = "stretch"
}

//child
class Cat extends Animal {
  override def aMovement: String = "jump"
}

//parent
class Clothing {
  def aMovement: String = "wiggle"

  def anotherMovement: String = "stretch"  
}

//child
class Pants extends Clothing {
  override def aMovement: String = "jump"
}

//typeclass
trait Movement[-T] {
  def dance(myParam: T): String
  def whereAmI: String
}

object Movement {
  //implicit instance for parent type
  implicit val animalMovement: Movement[Animal] = new Movement[Animal] {
    def dance(animal: Animal): String = animal.aMovement + " " + animal.aMovement + " " + animal.anotherMovement
    def whereAmI = "in a Movement[Animal] instance"
  }

  //implicit instance for child type
  implicit val catMovement: Movement[Cat] = new Movement[Cat] {
    def dance(cat: Cat): String = cat.aMovement + " " + cat.aMovement + " " + cat.anotherMovement
    def whereAmI = "in a Movement[Cat] instance"
  }

  //implicit instance for child type
  implicit val clothingMovement: Movement[Clothing] = new Movement[Clothing] {
    def dance(clothing: Clothing): String = clothing.aMovement + " " + clothing.aMovement + " " + clothing.anotherMovement
    def whereAmI = "in a Movement[Clothing] instance"
  }
}

object ContravariantPlay {
  def danceSomething[T](thing: T)(implicit movement: Movement[T]): String =
    movement.dance(thing)
  def whereAmI[T](implicit movement: Movement[T]): String = movement.whereAmI
}

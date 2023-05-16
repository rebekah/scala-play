package org.rwaterbury.scaladev
package typeclassandvariants

trait ReturnMeCovariant[+T] {
  def childType: Option[T]
  def whereAmI: String
}

object ReturnMeCovariant{
    
  implicit val returnableClothing: ReturnMeCovariant[Clothing] = new ReturnMeCovariant[Clothing]:
    override def childType = Option(new Shirt)
    override def whereAmI = "in returnableClothing"

  implicit val returnableShirt: ReturnMeCovariant[Shirt] = new ReturnMeCovariant[Shirt]:
    override def childType = Option(new TankTop)
    override def whereAmI = "in returnableShirt"

  implicit val returnableTankTop: ReturnMeCovariant[TankTop] = new ReturnMeCovariant[TankTop]:
    override def childType = None
    override def whereAmI = "in returnableTankTop"
  
}





package org.rwaterbury.scaladev
package typeclassandvariants

trait ReturnMeCovariant[+T] {
  def childType: T
  def whereAmI: String
}

object ReturnMeCovariant{
  implicit val returnableClothing: ReturnMeCovariant[Clothing] = new ReturnMeCovariant[Clothing]:
    override def childType = new Shirt
    override def whereAmI = "in returnableClothing"

  implicit val returnableShirt: ReturnMeCovariant[Shirt] = new ReturnMeCovariant[Shirt]:
    override def childType = new TankTop
    override def whereAmI = "in returnableShirt"  
  
  implicit val returnableTankTop: ReturnMeCovariant[TankTop] = new ReturnMeCovariant[TankTop]:
    override def childType = new TankTop
    override def whereAmI = "in returnableTankTop"
}





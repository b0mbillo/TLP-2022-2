object VPL10p {

  //PUNTO REGEX NO BORRAR ESTE CODIGO

  import scala.util.matching.Regex

  case class Vehiculo(nombre: String, color: String, placa: String)

  // la lista de vehiculos
  val fruit = List(Vehiculo("VPL", "rojo", "LCE88B"), Vehiculo("VPL", "rojo", "L0CW883"), Vehiculo("VPL", "rojo", "ABPH000"), Vehiculo("VPL", "rojo", "LCW88A"), Vehiculo("VPL", "rojo", "LLL1112"),
    Vehiculo("VPL", "rojo", "LCW883"), Vehiculo("VPL", "rojo", "MCM81I"), Vehiculo("VPL", "rojo", "UDU276"), Vehiculo("VPL", "rojo", "DBD31B"), Vehiculo("VPL", "rojo", "BZW693"), Vehiculo("VPL", "rojo", "EDH74d"),
    Vehiculo("VPL", "rojo", "SFE04Z"), Vehiculo("VPL", "rojo", "EDH74V"), Vehiculo("VPL", "rojo", "WYJ555"), Vehiculo("VPL", "rojo", "aAA123"), Vehiculo("VPL", "rojo", "HVI938"),
    Vehiculo("VPL", "rojo", "URY248"), Vehiculo("VPL", "rojo", "TAY31S"), Vehiculo("VPL", "rojo", "TAY32S"), Vehiculo("VPL", "rojo", "VMH106"), Vehiculo("VPL", "rojo", "YYN85U"),
    Vehiculo("VPL", "rojo", "A1A2A3"), Vehiculo("VPL", "rojo", "ETM64L"), Vehiculo("VPL", "rojo", "EEEEEEEEEEEEEOOOOOOOOOOO123"))

  def MotoCarro(Lista: List[Vehiculo]): List[String] = {
    val patroncarro: Regex = "^([A-Z]{3})([0-9]{3})$".r
    val patronmoto: Regex = "^([A-Z]{3})([0-9]{2})+[A-Z]$".r

    for (elem <- Lista) yield if(patroncarro.findFirstIn(elem.placa) match {
      case Some(_) => true
      case _ => false
    }) {"Es un Carro"}
    else if (patronmoto.findFirstIn(elem.placa) match{
      case Some(_) => true
      case _ => false
    }) {"Es una Moto"}
    else{"Placa no reconocida"}
  } //funcion para determinar si es un carro o moto o ninguna de las 2

  val respuestapunto4 =(MotoCarro(fruit))//Aqui va el YIELD para que imprima la respuesta del punto 4


  // No Cambiar este Método, es el caso de prueba
  def main(args: Array[String]) {
    val patroncarro: Regex = "^[A -Z]{3}\\d{3}$".r
    //cc,cv,cKM,mod
    def lSanderos = List(Stepway(1600, 16, 90221, 2011), Aventure(1600, 16, 90221, 2011), Track(1600, 16, 90221, 2011),
      Stepway(1600, 8, 15000, 2016), Aventure(1600, 16, 50000, 2011), Track(1200, 16, 100221, 2010),
      Aventure(1800, 8, 54685, 2013), Track(1100, 16, 9000, 2013), Aventure(1600, 16, 15488, 2014), Track(1400, 16, 2000, 2016))

    val aSanderos = calculadoraSanderos.calCaracteristicas(lSanderos)
    val Numero = scala.io.StdIn.readInt()
    if (Numero == 1) {

      aSanderos.foreach { f => println(f.getCaracteristicas()) }
    } else {
      println(result(Numero))
    }

  }

  var result = (x: Int) => x match {
    case 2 => respuestapunto4
  }

  def redondeo(numero: Double): Double = {
    BigDecimal(numero).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

    abstract class Sandero(cc:Double,cv:Double,cKM:Double,mod:Double,Clase:String){
      //Completa esta Clase ---------------------------------------------------
      def getCaracteristicas(): String ={
        val pesoMx = (cc: Double, cv: Double, kAuto: Double) => (cc / cv * 0.7) + (cv * kAuto)
        val bandas = (cKM: Double, mod: Double, kAuto: Double) => (cKM / (2018 - mod)) * kAuto
        val desgaste = (cKM: Double, mod: Double, cc: Double, cv: Double, kAuto: Double) => (cc * cv) / (2018 - mod) + cKM * kAuto
        val res = (Clase:String,cc: Double, cv: Double, kAuto: Double,cKM: Double, mod: Double) => List(Clase, redondeo(mod), redondeo(pesoMx(cc, cv, kAuto)), redondeo(bandas(cKM, mod, kAuto)), redondeo(desgaste(cKM, mod, cc, cv, kAuto)))

        val kA = Clase match {
          case "Stepway" =>
             0.012
          case "Aventure" =>
            0.048
          case "Track" =>
            0.271
        }
        val Lista = res(Clase,cc,cv,kA,cKM,mod)
        s"${Lista(0)}, modelo: ${Lista(1)} | Chasis Mx: ${Lista(2)} Ton, Bandas: ${Lista(3)} km, C.F. Desgaste: ${Lista(4)} HP."
      }
    }
    //Para las case class se considera el siguiente orden (cc,cv,cKM,mod)

    case class Stepway(cc:Double,cv:Double,cKM:Double,mod:Double) extends Sandero(cc:Double,cv:Double,cKM:Double,mod:Double,"Stepway")//Completa esta clase -----------------------------------
    //Ej de retorno para getCaracteristicas(), si Stepway(1600,16,90221,2011):
    // Stepway, modelo: 2011 | Chasis Mx: 70.192 Ton, Bandas: 154.665 km, C.F. Desgaste: 4739.795 HP.

    case class Aventure(cc:Double,cv:Double,cKM:Double,mod:Double) extends Sandero(cc:Double,cv:Double,cKM:Double,mod:Double,"Aventure")//Completa esta clase ----------------------------------
    //Ej de retorno para getCaracteristicas(), si Aventure(1600,16,90221,2011):
    //Aventure, modelo: 2011 | Chasis Mx: 70.768 Ton, Bandas: 618.658 km, C.F. Desgaste: 7987.751 HP.

    case class Track(cc:Double,cv:Double,cKM:Double,mod:Double) extends Sandero(cc:Double,cv:Double,cKM:Double,mod:Double,"Track")//Completa esta clase -------------------------------------
    //Ej de retorno para getCaracteristicas(), si Track(1600,16,90221,2011):
    //Track, modelo: 2011 | Chasis Mx: 74.336 Ton, Bandas: 3492.842 km, C.F. Desgaste: 28107.034 HP.


    object calculadoraSanderos{
      def calCaracteristicas(lista:List[Sandero]) ={
        lista.map(i => i)
      }
    }//Completa este objeto --------------------------

}

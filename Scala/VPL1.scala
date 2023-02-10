import scala.{:+, ::}
import scala.util.control.Breaks.{break, breakable}

object VPL1 {
  //Desarrollar las siguientes funciones anónimas y asignarlas a las constantes

  //(val) siguientes:

  //1 – val mcd (máximo común divisor) de 3 números.

  //2 – val celsius que convierte grados fahrenheit a celsius a.

  //3 – val millas que convierte kms en millas.(un kilometro equivale a 0.62137 millas)

  //4 – val area_circulo: devuelve el area de un círculo a partir del radio. (use como valor de pi=3.1416)

  //5 – Crear una funcion anónima para hacer una tasa de cambio (Euros A Pesos Colombianos) Utilizando la siguiente conversion: 1 Euro = 4.384,32 Pesos Colombianos

  //6 -
  //val cubos: genera arreglo de los cubos de los enteros en un rango (val cubos = (1 to 10).map((numero:Int) => (numero*numero*numero):Int))
  //val mayorDiez: Eliminar elementos mayores a 10 en una lista de enteros (val mayorDiez = (lista:List[Int]) => {var nuevaLista = List[Int](); for(i <- lista if i <=10){nuevaLista = nuevaLista :+ i};nuevaLista})
  //val unirTexto: Une dos strings de texto(val unirTexto = (_:String)+(_:String))

  // No Cambiar este Método, es el caso de prueba
  def main(args: Array[String]){
    println(mcd1(100,10,50))
    println(mcd2(100,50,10))
    println(celsius(100))
    val cubos = (1 to 10).map((numero:Int) => {numero*numero*numero}:Int)
    println(cubos)

    val unirTexto = (_:String) + (_:String)
    println(unirTexto("torre","eiffel"))

    val mayorDiez = (lista:List[Int]) => {var nuevaLista = List[Int](); for(i <- lista if i <=10){nuevaLista = nuevaLista :+ i};nuevaLista}:List[Int]
    println(mayorDiez(List[Int](1,4,5,6,7,22,44,55)))
  }

  val mcd1 = (x:Int,y:Int,z:Int) => {var MCD = 1; var T = true; var i = (List(x, y, z).min);
    while(T){if (x % i == 0 && y % i == 0 && z % i == 0){MCD = i;T = false}else i -= 1}
    MCD}:Float //aqui va su codigo

  //val mcd2 = (x:Int, y:Int, z:Int) => {lazy val mcd: (Int,Int) => Int = (x,y) =>{if (y == 0) x else mcd(y,x%y)};mcd(z,mcd(x,y))}:Double
  val mcd2:(Int, Int, Int) => Double = (x, y, z) => {
      lazy val mcd: (Int,Int) => Int = (x,y) => { //lazy es para evitar error (forward reference to value mcd extends over definition of value mcd)
        //val mcd es con : porque sino sale Int is already defined in the scope
      if (y == 0) x else mcd(y,x%y)}// no se puede tipar el retorno aqui por que sale (recursive value mcd needs type)
    mcd(z,mcd(x,y))}


  val celsius = (c:Double) => (c-32)* 5/9 :Double //aqui va su codigo
  // se puede tipar asi tambien: val celsius: Double => Double = (c) => (c-32)* 5/9

  //val millas = (Km: Float) => Km*0.62137  //aqui va su codigo

  //val area_circulo = (r:Float) => 3.1416*Math.pow(r,2)//aqui va su codigo

  //val Pesos = (Eur: Float) => 4384.32*Eur //aqui va su codigo

}
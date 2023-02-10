
import scala.annotation.tailrec


object VPL3 {
  def main(args: Array[String]) {
    println(potencia(List('a','b','c')))
    //println(permutacion(5, List( "Juan","Anamaria","Pablo","Sofía","Alejandro")))
    val Listadimensional = permutacion(5, List( "a","b","c"))
    println(Listadimensional)

    var inicio = System.nanoTime()
    println(sucesion(100,0.5,List()))
    var fin = System.nanoTime()
    println("tiempo sucesion: " + (fin-inicio)/math.pow(10,9))

    inicio = System.nanoTime()
    println(sucesiontail(100, 0.5, List()))
    fin = System.nanoTime()
    println("tiempo sucesiontail: " + (fin-inicio) / math.pow(10, 9))
  }

  def concatenacion(a: Any, list: List[_]): List[Any] = {
    list :+ a
  }//aqui va su codigo

  def potencia(a: List[_]): List[_] = {
    def potencia(a: List[_]): List[List[Any]] = {
      a match {
        case Nil => List(a)
        case cab :: cola =>
          val lista = potencia(cola)
          (lista.map(i => cab :: i):::lista)
      }
    }
    potencia(a)
    potencia(a).map(i => i.mkString).dropRight(1) //para cumplir enunciado
  }

  def permutacion(n: Int, l: List[_]): List[Any] = { //seguro daba usando yield y el for indexando con las posiciones
    def permutacion(l: List[_], intermedia: List[_]): List[Any] = {
      if (l.isEmpty) intermedia
      else {
        val rango = l.indices
        val lista = rango.map(i => permutacion(l.slice(0, i) ::: l.drop(i + 1), (intermedia ::: l.slice(i, i + 1))))
        lista.toList
      }
    }
    permutacion(l,List())
  }

  def sucesion(n: Int, c: Double, l: List[Double]): List[Double] = n match{
    case 0 => List(0)
    case _ =>
      val lista = sucesion(n-1,c,l)
      val aant = lista.head
      (math.pow(aant,2)+aant-1)/(aant+c) ::lista
  } //aqui va su codigo


  @tailrec def sucesiontail(n: Int, c: Double, l: List[Double]): List[Double] = {
    if (l.isEmpty) sucesiontail(n, c, List(0))
    else if(l.length == n+1) l
    else {
      val lista = (math.pow(l.head, 2) + l.head - 1) / (l.head + c) :: l
      sucesiontail(n, c, lista)
    }
  }
}
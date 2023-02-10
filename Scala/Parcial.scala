object Parcial {

  def main(args: Array[String]): Unit = {
    val car = Vector("Porshe", "Mercedes", "Tesla", "Murmon")
    println(for (elem <- car if elem.startsWith("M")) yield elem)

    println(Math.cos(23))

    val lista = List(3,5,2,4)
    val a  = lista.head
    val b  = lista.tail
    val c = a::b:::lista
    c.foreach(print(_))
    println(" ")

    var x,y,z = (1,2,3)
    println(x)

    val k: Double = 1
    val l: Double = 0
    val j: Double = k/l
    println(j)

    println(for (i <- 1 to 10) yield i * ((i + 1) / 2))
    println(for(i<- 1 to 10 ) yield i*(i+1)*(2*i+1)/6)
    println(for(i<- 1 to 10) yield (i*i*(i+1)*(i+1))/4)


  }
}


import scala.util.control.Breaks.{break, breakable}

object Test {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    print("digite un numero: ")
    val Numero = scala.io.StdIn.readInt()
    println(Numero)

    //Unit es void (vacio, osea un valor vacio), nothing es que no hay un valor
    //en scala las funciones retornan la ultima variable
    //estructura de funcion:
    //def funcion(parametro:tipoDatoEntrada,...): tipoDatoRetorno = {proceso}

    //estructura de funcion anonima:
    //  (parametro:tipoDatoEntrada,...) => {proceso}:tipoDatoRetorno
    //o (tipoDatoEntrada,...) => tipoDatoRetorno = (paramametros) => proceso

    //val celsius = (c: Double) => {(c - 32) * 5 / 9}: Double
    //val celsius: Double => Double = c => (c-32)* 5/9

    var x: Int = 1 //tipar una variable

    breakable {
      for (i <- 1 to 10) {
        if (i == 4) {
          println(i)
          break()
        }
      }
    }
    var array = Array[Int](1, 3, 4, 5)
    println(array(2))
    println(array.toList)
    array = array :+ Numero
    println(array.toList)
    val seq = Seq(1,3,4,"3",2,true)
    for (i<-seq){print(s"$i-")} //interpolacion de strings, la s es para especificar que vamos a interpolar
    // (existe tambien la f que es para usar ESPECIFICADORES DE FORMATO)
    // y $ declara que sigue una variable, si a esa variable le fueramos a hacer un proceso usamos ${proceso}

    //TUPLE ES UNA LISTA QUE ALMACENA DE CUALQUIER TIPO DE DATO {val tupla = (1, "3", true)}
    //ARRAYS SE PUEDEN MODIFICAR LOS DATOS PERO TIENEN TAMAÑO DEFINIDO {val array = Array[datatype](elementos)}
    //LIST NO SE PUEDEN MODIFICAR LOS DATOS(INMUTABLE) PERO SE LES PUEDE AGREGAR O QUITAR {val lista = List[datatype](elementos)}
    //VECTOR ES UNA SERIE DE PUNTOS DE UN RANGO, SALEN DE (n TO m) O (n until M) {val rango = 1 to 10}
    //SEQUENCIA SON ELEMENTOS (cualquier tipo), INMUTABLES CON UN ORDEN , SON PARA INDEXAR {val sequencia = Seq(elementos)}
    //SET SOLO TIENE LOS ELEMENTOS, SIN REPETICION NI ORDEN, SE LES PUEDE AGREGAR ELEMENTOS, HAY DOS TIPOS DE SET, LOS MUTABLE Y LOS NO MUTABLES {val set = Set(elementos)}
    //interpolacion de strings es usar las variables dentro de strings sin necesidad de concatenarlas
    println(" ")
    println("texto".map((i:Char) => {i}))

    println(List(1,2,3,4) :+ 400)
    println(400 :: List(1,2,3,4))
    val lista = List(0,2,3,4,1)
    println(lista ::: List(1,2,3,4))

    val tupla = (1, "3", true)
    println(tupla._1 + " es el valor en la posicion 1") //si concatenamos con coma devuelve en parentesis
    val (_,segundo,tercero) = tupla // asignar cada valor a una variable
    println(segundo + " - " + tercero)
    tupla.productIterator.foreach(i=> println(s"$i su tipo es ${i.getClass}")) // iterar una tupla


    println(List().length)
  }
}
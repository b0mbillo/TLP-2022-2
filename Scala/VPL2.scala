object VPL2 {
  def main(args: Array[String]): Unit = {
    println(verificarTriangulo(f2,4,2,3))
    println(palindromo(reverse,"alatorrederrotala"))
    val pruebas = Seq("aorta","suanaoria","suustos a dios","quevivaeldoctor")
    for (prueba<-pruebas){
      println(prueba)
      println(vocal1(filtro,prueba) + " vocal1")
      println(vocal2(filtro,prueba) + " vocal2")
      vocal3(filtro,prueba); println(" vocal3")
    }
  }

  val f2 = (a:Float,b:Float,c:Float) => {if (a+b>c && a+c>b && b+c>a) true else false }:Boolean //Aqui va su codigo

  def verificarTriangulo(f:(Float,Float,Float) => Boolean,a:Float,b:Float,c:Float): Boolean = f(a,b,c) //Aqui va su codigo

  def reverse (x:String):String = x.reverse

  def palindromo (f:String => String,x:String):Boolean = if (f(x) == x) true else false //Aqui va su codigo

  val filtro = (x:Char) =>{if (Set('a','e','i','o','u').contains(x)) true else false}:Boolean //Aqui va su codigo

  def vocal1(f:Char => Boolean,texto:String):String = texto.filter(f)  //Aqui va su codigo

  def vocal2(f: Char => Boolean, texto: String): String = texto.map(i => if (f(i)) i else "").mkString //Aqui va su codigo

  def vocal3(f:Char => Boolean,texto:String):Unit = texto.foreach((i:Char) => {if (f(i)) print(i)})//Aqui va su codigo

  //añada aqui en comentarios los casos de prueba que utilizo y  que imprime.

}

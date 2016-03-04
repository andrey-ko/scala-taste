object HttpMethod extends Enumeration{
  type HttpMethod = Value
  val GET = Value("GET")
  val PUT = Value("PUT")
  val POST = Value("POST")
  val DELETE = Value("DELETE")
  val HEAD = Value("HEAD")
}

object EnumerationTaste extends App {
  import HttpMethod._
  def request(method:HttpMethod): Unit = {
    println(s"creating '$method' request ...")
  }
  println("running enumeration taste app...")
  println("supported methods:")
  for(m<-HttpMethod.values){
    println(s"\t'$m'")
  }
  request(HttpMethod.GET)
  println("done...")
}

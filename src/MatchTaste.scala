
object MatchTaste extends App {
  val someInt = Some(200)
  for(v<-someInt){
    println(v)
  }

  val noneInt:Option[Int] = None
  for(v<-noneInt){
    println(v)
  }
  noneInt match {
    case Some(v) =>
      println(v)
    case _ => ()
  }

  someInt match {
    case Some(v) =>
      println(v)
    case _ => ()
  }
}

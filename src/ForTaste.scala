
object ForTaste extends App {
  (for(i<-1 to 10 if i%2 == 0) yield i).foreach{i=>
    println(i)
  }

  val someInt = Some(200)
  for(v<-someInt){
    println(v)
  }

  val noneInt:Option[Int] = None
  for(v<-noneInt){
    println(v)
  }
}

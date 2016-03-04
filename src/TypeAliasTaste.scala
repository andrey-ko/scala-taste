import scala.collection._

object TypeAliasTaste extends App {
  println("running lazy taste app...")

  type T = Seq[() => String]
  val seq:T = Seq(() => "1", ()=>"2")
  for(f<-seq){
    println(s"\t $f")
  }
  println("done...")
}

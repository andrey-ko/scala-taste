
object LazyTaste extends App {
  lazy val lval:Int = {
    println("evaluating value..")
    100
  }
  println("running lazy taste app...")
  println(s"lazy val == $lval")
  println("done...")
}

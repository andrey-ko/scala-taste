
object CallByNameTaste extends App {

  def test(e: => Boolean)(f: => Unit):Unit = {
    if(e){
      f
    }
  }

  test(true) {
    println("from call by name")
  }

}


trait Logging{
  def verb(message: String):Unit
  def info(message: String):Unit
  def warn(message: String):Unit
}

trait StdOutLogging extends Logging{
  def verb(message: String):Unit = {
    println(s"[VERB]: $message")
  }
  def info(message: String):Unit = {
    println(s"[INFO]: $message")
  }
  def warn(message: String):Unit = {
    println(s"[WARN]: $message")
  }
}


object TraitsTaste extends App with StdOutLogging {

  info("running traits taste app...")
  verb("doing something...")
  warn("done...")

}

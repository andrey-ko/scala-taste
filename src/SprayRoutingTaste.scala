import akka.actor._
import spray.routing._

object SprayRoutingTaste extends App with Directives with SimpleRoutingApp{
  println("running spray routing taste...")
  implicit val system = ActorSystem("my-system")
  println("starting server (localhost:3038)...")
  startServer(interface = "localhost", port = 3038) {
    path("rtm"/"channels"/Segment) { channel =>
      get {
        complete {
          println(s"publishing message to channel '$channel' ...")
          <h1>publishing message to channel $channel</h1>
        }
      }
    }~
    path("sys"/"status") {
      get {
        complete {
          Runtime runtime = Runtime.getRuntime();

          NumberFormat format = NumberFormat.getInstance();

          StringBuilder sb = new StringBuilder();
          long maxMemory = runtime.maxMemory();
          long allocatedMemory = runtime.totalMemory();
          long freeMemory = runtime.freeMemory();

          sb.append("free memory: " + format.format(freeMemory / 1024) + "<br/>");
          sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "<br/>");
          sb.append("max memory: " + format.format(maxMemory / 1024) + "<br/>");
          sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024)
          println(s"publishing message to channel '$channel' ...")
          <h1>publishing message to channel $channel</h1>
        }
      }
    }
  }
}

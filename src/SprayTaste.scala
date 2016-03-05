import akka.actor._
//import spray.routing.PathMatcher.{Unmatched, Matched}
import spray.routing._
import spray.http._
import spray.routing.directives.BasicDirectives._
import spray.routing.directives.RouteDirectives._

object SprayTaste extends App with Directives with SimpleRoutingApp{
  //implicit def actorRefFactory: ActorRefFactory
  val route = {
    path("orders") {
      get {
        complete {
          println("???????????????")
          "Order received"
        }
      }
    }
  }
  val pm = PathMatcher(Slash ~ "orders" / RestPath)


  route(RequestContext(HttpRequest(
      HttpMethods.GET, Uri("http://localhost:3070/orders")
  ), null, Uri.Path("/orders")))


  {
    import PathMatcher._
    pm.apply(Uri.Path("/orders/some?x=10")) match {

      case Matched(r,e) =>
        println(s"matched: rest=$r, ext=$e")
      case Unmatched =>
        println(s"unmatched: $Unmatched")
    }
  }
  println(route.getClass)

}

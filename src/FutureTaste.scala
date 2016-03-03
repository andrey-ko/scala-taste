import java.util.concurrent.atomic.AtomicInteger

import scala.annotation.tailrec
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
object FutureTaste extends App {
  val workersCnt = new AtomicInteger(0)
  def doWork(num:Int):Int = {
    var tid = Thread.currentThread().getId()
    println(s"$num started on [$tid], workers = ${workersCnt.getAndIncrement()+1}")
    val fut = Future{doWork(num+1)}{new ExecutionContext {
      override def reportFailure(cause: Throwable): Unit = {}
      override def execute(runnable: Runnable): Unit = {
        runnable.run()
      }
    }}
    fut.onComplete{x=>
      println(s"${x.get} notify completion on [$tid]")
    } {new ExecutionContext {
      override def reportFailure(cause: Throwable): Unit = {}
      override def execute(runnable: Runnable): Unit = {
        runnable.run()
      }
    }}

    val started = System.currentTimeMillis()
    def loop(cnt: Int):Int ={
      val elapsed = System.currentTimeMillis() - started
      if(elapsed < 3*1000){
        loop(cnt+1)
      }else{
        println(
          s"$num completed on [$tid], workers = ${workersCnt.getAndDecrement()-1}, mops=${cnt/(elapsed*1000)}"
        )
        num
      }
    }
    return loop(0)
  }
  println("running FutureTaste...")
  Future{doWork(0)}
  Thread.sleep(10*1000*1000)
}

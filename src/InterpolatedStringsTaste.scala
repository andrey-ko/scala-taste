
object InterpolatedStringsTaste extends App {

  println("running interpolated strings taste app...")
  val int = 90
  val float = 67.556663f
  val float2 = 78.5f
  println(s"\t${int}%3d\t${float}%.2f\t${float2}%6.2f ")
  println(f"\t${int}%3d\t${float}%.2f\t${float2}%6.2f ")
  println(f"\t${int}%03d\t${float}%.2f\t${float2}%06.2f ")
  println(raw"\t${int}%03d\t${float}%.2f\t${float2}%06.2f ")
  println("done...")

}

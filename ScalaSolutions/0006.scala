/*
 * Skeleton class for future Project Euler solutions in Scala
 */

object Euler0006 {
  def main(args: Array[String]): Unit = {
    println((math.pow((1 to 100).foldLeft(0.0)(_+_), 2) - (1 to 100).map(math.pow(_,2)).foldLeft(0.0)(_+_)).toInt)
  }
}

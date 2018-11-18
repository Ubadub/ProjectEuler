/*
 * Project Euler Problem #25
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 * (where F_1 = 1, F_2 = 1)
 */

object Euler0025 {

  val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(n => n._1 + n._2)

  def main(args: Array[String]): Unit = {
    println(fibs.zipWithIndex.dropWhile(_._1.toString.length < 1000).head._2)
  }
}

/**
 * Project Euler Problem #2
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */

object Euler0002 {
  lazy val fibs: Stream[BigInt] =
    BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map{i => i._1 + i._2}

  def main(args: Array[String]): Unit = {
    println(fibs.takeWhile(_ < 4000000).filter(_ % 2 == 0).sum)
  }
}

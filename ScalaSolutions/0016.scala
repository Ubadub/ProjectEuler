/*
 * Project Euler Problem #16
 *
 * What is the sum of the digits of the number 2^1000?
 */

object Euler0016 {
  val twos: Stream[BigInt] = Stream.cons(BigInt(2), twos)

  def main(args: Array[String]): Unit = {
    println(twos.take(1000).product.toString.map(_.asDigit).sum)
  }
}

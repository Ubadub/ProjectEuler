/*
 * Project Euler Problem #16
 *
 * What is the sum of the digits of the number 2^1000?
 */

object Euler0016 {
  def main(args: Array[String]): Unit = {
    println(BigInt(2).pow(1000).toString.map(_.asDigit).sum)
  }
}

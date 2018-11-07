/**
 * Project Euler Problem #1
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

object Euler0001 {
  def sum: Int = (1 until 1000).view.filter(n => n % 3 == 0 || n % 5 == 0).sum

  def main(args: Array[String]): Unit = {
    println(sum)
  }
}

/**
 * Project Euler Problem #5
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

object Euler0005 {
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a
    else gcd(b, a%b)
  }

  def lcm(a: Long, b: Long): Long = (a * b)/gcd(a, b)

  def lcm(as: Iterable[Long]): Long = as.foldRight(1L)(lcm)

  def main(args: Array[String]): Unit = {
    println(lcm(1L to 20L))
  }
}


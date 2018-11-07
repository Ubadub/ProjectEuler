/**
 * Project Euler Problem #10
 *
 * Find the sum of all the primes below two million.
 */

object Euler0010 {
  val primes: Stream[Long] = 2L #:: Stream.from(3).map(_.toLong).filter(i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))

  def main(args: Array[String]): Unit = {
    println(primes.takeWhile(_ < 2000000).sum)
  }
}

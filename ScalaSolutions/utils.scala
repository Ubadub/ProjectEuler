/**
 * Useful functions and values for Project Euler problems
 */

object EulerUtils {

  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a
    else gcd(b, a%b)
  }

  def lcm(a: Long, b: Long): Long = (a * b)/gcd(a, b)

  def lcm(as: Iterable[Long]): Long = as.foldRight(1L)(lcm)

  val primes: Stream[Long] = 2L #:: Stream.from(3).map(_.toLong).filter(i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))

  // This ugly definition is required because NumericRanges in Scala cannot contain more than Int.MaxValue elements
  def totient(n: Long): Long = Stream.from(1).map(_.toLong).takeWhile(_ < n).filter(gcd(n, _) == 1).length
}

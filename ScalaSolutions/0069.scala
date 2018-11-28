/*
 * Project Euler Problem #69
 *
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 */

object Euler0069 {

  val LIMIT = 1000000

  // instead of brute-forcing it (commented out above), we take advantage of Euler's product formula for phi(n)
 
  val primes: Stream[Long] = 2L #:: Stream.from(3).map(_.toLong).filter(i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))

  val maxNToPhiRatio: Long = {
    
    def go(primeStream: Stream[Long], acc: Long): Long = {
      val newAcc = primeStream.head * acc
      if (newAcc > LIMIT) acc
      else go(primeStream.tail, newAcc)
    }

    go(primes, 1)
  }

  def main(args: Array[String]): Unit = {
    println(maxNToPhiRatio)
  }
}

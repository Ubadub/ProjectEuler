object Euler0007 {
  val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))

  def main(args: Array[String]): Unit = {
    println(primes.drop(10000).head)
  }
}

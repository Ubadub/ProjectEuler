object Euler0003 {
  val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))

  def main(args: Array[String]): Unit = {
    val n: Long = 600851475143L
    println(primes.takeWhile(_ <= math.sqrt(n)).filter(n % _ == 0).reduce((_, b) =>  b))
  }
}

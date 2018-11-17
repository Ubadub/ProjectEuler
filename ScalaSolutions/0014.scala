/*
 * Project Euler Problem #14
 *
 * The following iterative sequence is defined for the set of positive integers:
 *
 *    n -> n/2 (n is even)
 *    n -> 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 *    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been
 * proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 */

object Euler0014 {

  def collatz(n: Long): Long = {
    if (n % 2 == 0) n / 2
    else 3 * n + 1
  }

  def collatzSequenceLength(n: Long): Int = {

    def go(n: Long, acc: Int): Int = {
      if (n == 1) acc + 1
      else go(collatz(n), acc + 1)
    }

    go(n, 0)
  }

  // A tuple, whose first element is the length of the longest Collatz sequence less than one million and whose second
  // element is the number itself which yields that Collatz sequence
  val maxCollatzSequence: (Int, Long) =
    (for (i <- 1L until 1000000L)
      yield {
        (collatzSequenceLength(i), i)
      }
    ).max

  def main(args: Array[String]): Unit = {
    println(maxCollatzSequence._2)
  }
}

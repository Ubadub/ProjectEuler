/*
 * Project Euler Problem #15
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly
 * 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 */

object Euler0015 {

  implicit class MyBigInt(x: BigInt) {
    val ONE: BigInt = 1

    def P(r: BigInt): BigInt = {
      if (x == r) ONE
      else x * ((x - ONE) P r)
    }

    def C(r: BigInt): BigInt = (x P r) / (ONE to r).product
  }

  def howManyPaths(height: BigInt, width: BigInt): BigInt = (height + width) C width

  def main(args: Array[String]): Unit = {
    println(howManyPaths(20, 20))
  }
}

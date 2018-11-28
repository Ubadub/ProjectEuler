/*
 * Problem #31
 *
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 *    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 *
 * It is possible to make £2 in the following way:
 * 
 *    1=£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 
 * How many different ways can £2 be made using any number of coins?
 */

object Euler0031 {

  val coins: List[Int] = List(200, 100, 50, 20, 10, 5, 2, 1)
  
  def makeChange(amt: Int, denoms: List[Int]): Int = {
    if (amt == 0) 1
    else denoms match {
      case h::t if h <= amt => makeChange(amt - h, denoms) + makeChange(amt, t)
      case h::t => makeChange(amt, t)
      case _ => 0
    }
  }

  def main(args: Array[String]): Unit = {
    println(makeChange(200, coins))
  }
}

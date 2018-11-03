object Euler0001 {
  def sum: Int = (1 until 1000).view.filter(n => n % 3 == 0 || n % 5 == 0).sum

  def main(args: Array[String]): Unit = {
    println(sum)
  }
}

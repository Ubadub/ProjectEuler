/*
 * Project Euler Problem #19
 *
 * You are given the following information, but you may prefer to do some research for yourself.
 *    1 Jan 1900 was a Monday.
 *    Thirty days has September,
 *    April, June and November.
 *    All the rest have thirty-one,
 *    Saving February alone,
 *    Which has twenty-eight, rain or shine.
 *    And on leap years, twenty-nine.
 *    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 *    How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

object Euler0019 {

  // Day of the week (0=Sunday to 6=Saturday), Day of the month (1-31), Month (1-12), Year (1901-2000)
  type Date = (Int, Int, Int, Int)

  val startDate = (1, 1, 1, 1900)

  def isLeapYear(year: Int): Boolean = {
    year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
  }

  def daysIn(month: Int, year: Int) = {
    if (month == 2) {
      if (isLeapYear(year)) 29
      else 28
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11) 30
    else 31
  }

  def getNextDate(date: Date): Date = {
    val (prevDayOfWeek, prevDayOfMonth, prevMonth, prevYear) = date
    
    val dayOfWeek = (prevDayOfWeek + 1) % 7
    
    val year = {
      if (prevDayOfMonth == 31 && prevMonth == 12) prevYear + 1
      else prevYear
    }

    val (day, month) = {
      if (prevDayOfMonth < daysIn(prevMonth, prevYear)) (prevDayOfMonth + 1, prevMonth)
      else if (prevMonth == 12) (1, 1)
      else (1, prevMonth + 1)
    }

    (dayOfWeek, day, month, year)
  }

  def dayStream(start: Date): Stream[Date] = start #:: dayStream(getNextDate(start))

  val century20th = dayStream(startDate).dropWhile(_._4 < 1901).takeWhile(_._4 <= 2000)

  val candidateSundays = century20th.filter(d => d._1 == 0 && d._2 == 1)

  def main(args: Array[String]): Unit = {
    println(candidateSundays.size)
  }
}

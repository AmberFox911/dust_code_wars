package ru.dust.codewars.kyu7

import ru.dust.codewars.support.int.NumGenerator
import ru.dust.codewars.support.time.StopWatch

object Divisors {

  def main(args: Array[String]): Unit = {

    val stopWatch: StopWatch = new StopWatch

    val numCount: Int = 100000

    println(" 1")
    stopWatch.changeStartTime
    NumGenerator.genIntArray(numCount).map(divisors)
    println(s" 1 $numCount duration in sec: ${stopWatch.getDurationSec}")
    println(s" 1 $numCount duration in mill: ${stopWatch.getDurationMillis}")


    println(" 2")
    stopWatch.changeStartTime
    NumGenerator.genIntArray(numCount).map(divisors2)
    println(s" 2 $numCount  duration in sec: ${stopWatch.getDurationSec}")
    println(s" 2 $numCount duration in mill: ${stopWatch.getDurationMillis}")

  }

  def divisors(n: Int): Int = {
    var curr: Int = n
    var count: Int = 0
    while (curr > 0) {
      if (n % curr == 0) count += 1
      curr -= 1
    }
    count
  }

  def divisors2(n: Int): Int = (1 to n).count(n % _ == 0)

}

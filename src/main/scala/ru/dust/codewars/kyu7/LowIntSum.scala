package ru.dust.codewars.kyu7

import ru.dust.codewars.support.int.NumGenerator
import ru.dust.codewars.support.time.StopWatch

object LowIntSum {
  def main(args: Array[String]): Unit = {
    val stopWatch: StopWatch = new StopWatch

    val numCount: Int = 20000000

    println(" 1")
    stopWatch.changeStartTime
    sumTwoSmallest(NumGenerator.genIntArray(numCount).toList)
    println(s" 1 $numCount duration in sec: ${stopWatch.getDurationSec}")
    println(s" 1 $numCount duration in mill: ${stopWatch.getDurationMillis}")

    println(" 2")
    stopWatch.changeStartTime
    sumTwoSmallest2(NumGenerator.genIntArray(numCount).toList)
    println(s" 2 $numCount  duration in sec: ${stopWatch.getDurationSec}")
    println(s" 2 $numCount duration in mill: ${stopWatch.getDurationMillis}")

    println(" 3")
    stopWatch.changeStartTime
    sumTwoSmallest3(NumGenerator.genIntArray(numCount).toList)
    println(s" 3 $numCount  duration in sec: ${stopWatch.getDurationSec}")
    println(s" 3 $numCount duration in mill: ${stopWatch.getDurationMillis}")
  }

  def sumTwoSmallest(numbers: List[Int]): Int = {
    val min: Int = numbers.min
    var preMin: Int = Integer.MAX_VALUE
    numbers.foreach {el => if (el != min && el < preMin) preMin = el }
    min + preMin
  }

  def sumTwoSmallest2(numbers: List[Int]): Int = numbers.sorted.take(2).sum

  def sumTwoSmallest3(numbers: List[Int]): Int =
    numbers.drop(2).foldLeft(numbers.take(2)) { (acc, x) => if (x < acc.max) List(x, acc.min) else acc }.sum

}

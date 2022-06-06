package ru.dust.codewars.kyu8

import ru.dust.codewars.support.int.NumGenerator
import ru.dust.codewars.support.time.StopWatch

object CountPositivesSumNegatives {

  def main(args: Array[String]): Unit = {
    val stopWatch: StopWatch = new StopWatch

    val intCount: Int = 400000000

    println(" 1")
    stopWatch.changeStartTime
    countPositivesSumNegatives(NumGenerator.genIntArray(intCount))
    println(s" 1 $intCount ints duration in sec: ${stopWatch.getDurationSec}")

    println(" 2")
    stopWatch.changeStartTime
    countPositivesSumNegatives2(NumGenerator.genIntArray(intCount))
    println(s" 2 $intCount ints duration in sec: ${stopWatch.getDurationSec}")

    println("3")
    stopWatch.changeStartTime
    countPositivesSumNegatives3(NumGenerator.genIntArray(intCount))
    println(s" 3 $intCount ints duration in sec: ${stopWatch.getDurationSec}")

    println("4")
    stopWatch.changeStartTime
    countPositivesSumNegatives4(NumGenerator.genIntArray(intCount))
    println(s" 4 $intCount ints duration in sec: ${stopWatch.getDurationSec}")

    println("5")
    stopWatch.changeStartTime
    countPositivesSumNegatives5(NumGenerator.genIntArray(intCount))
    println(s" 5 $intCount ints duration in sec: ${stopWatch.getDurationSec}")
  }

  def countPositivesSumNegatives(integers: Array[Int]): (Int, Int) = {
    var posCount: Int = 0
    var negSum: Int = 0
    integers.foreach(num => {if (num > 0) posCount+=1 else negSum = negSum + num})
    (posCount, negSum)
  }

  def countPositivesSumNegatives2(xs: Array[Int]): (Int, Int) = (xs.count(_ > 0), xs.filter(_ < 0).sum)

  def countPositivesSumNegatives3(integers: Array[Int]): (Int, Int) = integers.partition(_ > 0) match { case (pos, neg) => (pos.size, neg.sum) }

  def countPositivesSumNegatives4(integers: Array[Int]): (Int, Int) = {
    (integers.count(_ > 0), integers.filter(_ < 0).sum)
  }

  def countPositivesSumNegatives5(input: Array[Int]): (Int, Int) = {
    if (input == null || input.length == 0) return (0, 0)

    var pos = 0
    var neg = 0

    for (i <- input) {
      if (i > 0)
        pos += 1
      else
        neg += i
    }

    return (pos, neg)
  }

}

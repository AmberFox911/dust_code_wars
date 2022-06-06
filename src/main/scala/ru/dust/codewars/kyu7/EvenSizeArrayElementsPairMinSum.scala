package ru.dust.codewars.kyu7

import ru.dust.codewars.support.int.NumGenerator
import ru.dust.codewars.support.time.StopWatch

import scala.collection.mutable
import scala.collection.mutable.LinkedHashSet

/*
* Given an array of integers , Find the minimum sum which is obtained from summing each Two integers product .
*
* Notes
* Array/list will contain positives only .
* Array/list will always has even size
*
* Input >> Output Examples
*   minSum({5,4,2,3}) ==> return (22)
*
*Explanation:
*   The minimum sum obtained from summing each two integers product , 5*2 + 3*4 = 22
*   minSum({12,6,10,26,3,24}) ==> return (342)
*Explanation:
*   The minimum sum obtained from summing each two integers product , 26*3 + 24*6 + 12*10 = 342
*   minSum({9,2,8,7,5,4,0,6}) ==> return (74)
*Explanation:
*   The minimum sum obtained from summing each two integers product , 9*0 + 8*2 +7*4 +6*5 = 74
* */

object EvenSizeArrayElementsPairMinSum {

  def main(args: Array[String]): Unit = {
    val stopWatch: StopWatch = new StopWatch

    val stringCount: Int = 100000

    println(" 1")
    stopWatch.changeStartTime
    minSum(NumGenerator.genIntArrayFromRange(1, stringCount).toList)
    println(s" 1 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

    println(" 2")
    stopWatch.changeStartTime
    minSum2(NumGenerator.genIntArrayFromRange(1, stringCount).toList)
    println(s" 2 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

    println(" 3")
    stopWatch.changeStartTime
    minSum3(NumGenerator.genIntArrayFromRange(1, stringCount).toList)
    println(s" 3 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")
  }

  def minSum(passed: List[Int]): Int = {
    val sortedPassed: List[Int] = passed.sorted
    val passedSize: Int = sortedPassed.size
    val prodCount: Int = passedSize / 2
    val operations: Range = 1 to prodCount

    operations
      .map(el => sortedPassed(el - 1) * sortedPassed(passedSize - el))
      .sum
  }

  def minSum2(passed: List[Int]): Int = {
    val (sorted, half) = (passed.sorted, passed.size/2)
    (sorted.take(half) zip sorted.reverse.take(half)).map { case (a, b) => a*b }.sum
  }

  def minSum3(passed: List[Int]): Int = {
    val (left, right) = passed.sorted.splitAt(passed.length / 2)
    (left zip right.reverse).map { case (a, b) => a * b }.sum
  }

}

package ru.dust.codewars.kyu5

import ru.dust.codewars.support.int.NumGenerator
import ru.dust.codewars.support.time.StopWatch

object MaximumSubArraySum {

  def main(args: Array[String]): Unit = {
    val stopWatch: StopWatch = new StopWatch

    val intCount: Int = 2000

//    println(" 1")
//    stopWatch.changeStartTime
//    val arr = Array(-2, -100) ++ NumGenerator.genIntArray(intCount) :+ -1
//    println(arr.mkString(" ,"))
//    println(sequence(arr))
//    println(s" 1 $intCount ints duration in sec: ${stopWatch.getDurationSec}")

    println(" 2")
    stopWatch.changeStartTime
    val arr2 = Array(-2, -100) ++ NumGenerator.genIntArray(intCount) :+ -1
    println(arr2.mkString(" ,"))
    println(sequence2(arr2))
    println(s" 2 $intCount ints duration in sec: ${stopWatch.getDurationSec}")

    println(sequence(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4))) //6
    println(sequence2(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4))) //6
  }

  def sequence(arr: Array[Int]): Int = {
    if (arr.forall(_ < 0) || arr.isEmpty) return 0
    else if (arr.forall(_ > 0)) return arr.sum
    var maxSum: Int = Int.MinValue
    val indexes = 0 to arr.length-1
    indexes.foreach(ind => {
      val tmpSum = arr.sliding(ind + 1).map(_.sum).max
      if (maxSum < tmpSum) maxSum = tmpSum
    }
    )
    maxSum
  }

  def sequence2(arr: Array[Int]): Int = {
    if (arr.forall(_ < 0) || arr.isEmpty) return 0
    else if (arr.forall(_ > 0)) return arr.sum
    var sum, maxSum, startIndex, endIndex, maxStartIndexUntilNow = 0

    for (idx <- arr.indices) {
      sum += arr(idx)

      if (arr(idx) > sum) {
        sum = arr(idx)
        startIndex = idx
      }

      if (sum > maxSum) {
        maxSum = sum
        startIndex = maxStartIndexUntilNow
        endIndex = idx
      } else if (sum < 0) {
        maxStartIndexUntilNow = idx + 1
        sum = 0;
      }
    }
    maxSum
  }

  def sequence3(arr: Array[Int]): Int =
    arr.scanLeft(0)(_ + _ max 0).max

}

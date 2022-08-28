package ru.dust.algo.simple

import ru.dust.codewars.support.time.StopWatch

object BinarySearch {

  def main(args: Array[String]): Unit = {
    val stopWatch: StopWatch = new StopWatch

    val elementsCount: Int = 2000000000
    val testData: Array[Int] = {1 to elementsCount}.toArray

    val searched1 = elementsCount
    println(s"search $searched1 binary")
    stopWatch.changeStartTime
    println(binarySearch(testData, searched1)()())
    println(s"search $searched1 binary duration in mills: ${stopWatch.getDurationMillis}")
    println(s"search $searched1 binary duration in sec: ${stopWatch.getDurationSec}")

    println("search find")
    stopWatch.changeStartTime
    println(findSearch(testData, elementsCount))
    println(s"search $searched1 find duration in mills: ${stopWatch.getDurationMillis}")
    println(s"search find $elementsCount  duration in sec: ${stopWatch.getDurationSec}")

    println("search default")
    stopWatch.changeStartTime
    println(defaultSearch(testData, elementsCount))
    println(s"search $searched1 default duration in mills: ${stopWatch.getDurationMillis}")
    println(s"search default $elementsCount duration in sec: ${stopWatch.getDurationSec}")
  }

  def binarySearch(data: Array[Int], someSearch: Int)(low: Int = 0, high: Int = data.length)(opsCount: Int = 1): Int = {
    println(s"opsCount = $opsCount")
    val middle: Int = getMiddle(low, high)
    if (data(middle) == someSearch)
      data(middle)
    else
      if (data(middle) > someSearch) binarySearch(data, someSearch)(low, middle)(opsCount + 1)
    else
      binarySearch(data, someSearch)(middle, high)(opsCount + 1)
  }

  private def getMiddle( low: Int, high: Int): Int = {
    low + (high - low)/2
  }

  def findSearch(data: Array[Int], someSearch: Int): Int = {
    data.find(_ == someSearch).getOrElse(-1)
  }

  def defaultSearch(data: Array[Int], someSearch: Int): Int = {
    for (num <- data) if (num == someSearch) return num
    -1
  }

}

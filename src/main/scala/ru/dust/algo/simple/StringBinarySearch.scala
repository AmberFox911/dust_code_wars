package ru.dust.algo.simple

import ru.dust.codewars.support.string.StringGenerator
import ru.dust.codewars.support.time.TimeManager.time

object StringBinarySearch {

  def main(args: Array[String]): Unit = {

    val elementsCount: Int = 100000
    val testData: Array[String] = StringGenerator.genStringArray(elementsCount).sorted
    val randomIndex: Int = (testData.length * Math.random()).asInstanceOf[Int]
    println(s"randomIndex = $randomIndex")

    val searched1 = testData(randomIndex)

    time(binarySearch(testData, searched1)()(), s"binary search")

    time(findSearch(testData, searched1), s"find search")

    time(defaultSearch(testData, searched1), "default search")
  }

  def binarySearch(data: Array[String], someSearch: String)(low: Int = 0, high: Int = data.length)(opsCount: Int = 1): String = {
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

  def findSearch(data: Array[String], someSearch: String): String = {
    data.find(_.equals(someSearch)).getOrElse("ERROR")
  }

  def defaultSearch(data: Array[String], someSearch: String): String = {
    for (num <- data) if (num equals someSearch) return num
    "ERROR"
  }

}

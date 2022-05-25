package ru.dust.codewars.kyu8

import ru.dust.codewars.support.string.StringGenerator
import ru.dust.codewars.support.time.StopWatch

object RemoveEveryOther {

  def main(args: Array[String]): Unit = {

    val stopWatch: StopWatch = new StopWatch

    val stringCount: Int = 1000000

    println(" 1")
    stopWatch.changeStartTime
    removeEveryOther(StringGenerator.genStringArray(stringCount).toList)
    println(s" 1 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

    println(" 2")
    stopWatch.changeStartTime
    removeEveryOther2(StringGenerator.genStringArray(stringCount).toList)
    println(s" 2 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

    println(" 3")
    stopWatch.changeStartTime
    removeEveryOther3(StringGenerator.genStringArray(stringCount).toList)
    println(s" 3 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

    println(" 4")
    stopWatch.changeStartTime
    removeEveryOther4(StringGenerator.genStringArray(stringCount).toList)
    println(s" 4 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

    println(" 5")
    stopWatch.changeStartTime
    removeEveryOther5(StringGenerator.genStringArray(stringCount).toList)
    println(s" 5 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

  }

  def removeEveryOther[T](list: List[T]): List[T] = {
    val listIterator = 0 until list.size by 2
    listIterator.toList.map(i => list(i))
  }

  def removeEveryOther2[T](list: List[T]): List[T] =
    list.zipWithIndex.collect { case (x, i) if i%2==0 => x }

  def removeEveryOther3[T](list: List[T]): List[T] =
    list match {
      case Nil => Nil
      case x :: Nil => x :: Nil
      case x :: y :: tail => x :: removeEveryOther(tail)
    }

  def removeEveryOther4[T](list: List[T]): List[T] = list.grouped(2).map(_(0)).toList

  def removeEveryOther5[T](list: List[T]): List[T] = list.grouped(2).map(_.head).toList

}

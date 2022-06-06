package ru.dust.codewars.kyu6

import ru.dust.codewars.support.string.StringGenerator
import ru.dust.codewars.support.time.StopWatch

object CharCount {

  def main(args: Array[String]): Unit = {
    val stopWatch: StopWatch = new StopWatch

    val stringCount: Int = 20000000

    println("noSpace 1")
    stopWatch.changeStartTime
    StringGenerator.genStringArray(stringCount).foreach(count)
    println(s"noSpace 1 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")
    println(s"noSpace 1 $stringCount strings duration in mills: ${stopWatch.getDurationMillis}")

    println("noSpace 2")
    stopWatch.changeStartTime
    StringGenerator.genStringArray(stringCount).foreach(count2)
    println(s"noSpace 2 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")
    println(s"noSpace 2 $stringCount strings duration in mills: ${stopWatch.getDurationMillis}")
  }

  def count(string: String): Map[Char,Int] = {
    var res: Map[Char, Int] = Map()
    string.foreach { ch =>
      if (res.contains(ch)) res = res.updated(ch, res(ch) + 1)
      else res = res.updated(ch, 1)
    }
    res
  }

  def count2(string: String): Map[Char,Int] =
    string.groupMapReduce(identity)(_ => 1)(_ + _)

}

package ru.dust.codewars.kyu8

import ru.dust.codewars.support.string.StringGenerator
import ru.dust.codewars.support.time.StopWatch

import scala.util.Random

object NoSpace  {

  def main(args: Array[String]): Unit = {
    val stopWatch: StopWatch = new StopWatch

    val stringCount: Int = 100000000

    println("noSpace 1")
    stopWatch.changeStartTime
    StringGenerator.genStringArray(stringCount).foreach(noSpace)
    println(s"noSpace 1 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

    println("noSpace 2")
    stopWatch.changeStartTime
    StringGenerator.genStringArray(stringCount).foreach(noSpace2)
    println(s"noSpace 2 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

    println("noSpace 3")
    stopWatch.changeStartTime
    StringGenerator.genStringArray(stringCount).foreach(noSpace3)
    println(s"noSpace 3 $stringCount strings duration in sec: ${stopWatch.getDurationSec}")

  }

  def noSpace(s: String): String = s.replaceAll(" ", "")

  def noSpace2(s: String): String = s.filterNot(_.isWhitespace)

  def noSpace3(s: String): String = s.filter(_ != ' ')

}

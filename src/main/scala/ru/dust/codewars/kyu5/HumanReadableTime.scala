package ru.dust.codewars.kyu5

import java.time.LocalDate
import java.time.format.DateTimeFormatter


object HumanReadableTime {

  def main(args: Array[String]): Unit = {
    println(makeReadable(0))//00:00:00
    println(makeReadable(59))//00:00:59
    println(makeReadable(60))//00:01:00
    println(makeReadable(3599))//00:59:59
    println(makeReadable(3600))//01:00:00
    println(makeReadable(86399))//23:59:59
    println(makeReadable(86400))//24:00:00
    println(makeReadable(359999))//99:59:59
  }

  def makeReadable(seconds: Int): String =
    "%02d:%02d:%02d".format(seconds/3600, seconds%3600/60, seconds%3600%60)



}

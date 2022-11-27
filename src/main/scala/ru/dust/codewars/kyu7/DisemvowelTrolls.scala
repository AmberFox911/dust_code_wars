package ru.dust.codewars.kyu7

object DisemvowelTrolls {

  def main(args: Array[String]): Unit = {
    println(disemvowel("This website is for losers LOL"))
  }

  def disemvowel(str: String): String = {
    val vowels: Array[Char] = Array('A','E','I','O','U')
    str.filter(ch => !vowels.contains(ch.toUpper))
  }

}

package ru.dust.codewars.kyu5

object TheHashtagGenerator {

  def main(args: Array[String]): Unit = {
    println(generateHashtag(" Hello there thanks for trying my Kata")) // #HelloThereThanksForTryingMyKata
    println(generateHashtag(" "))
    println(generateHashtag(""))
  }

  def generateHashtag(s: String): String = {
    if (s.isEmpty) return ""
    val res: String = s.split(" ").filter(_.nonEmpty).map(word => s"${word.head.toUpper}${word.tail.toLowerCase}").mkString
    if (res.length > 140 || res.isEmpty) return ""
    "#".concat(res)
  }

}

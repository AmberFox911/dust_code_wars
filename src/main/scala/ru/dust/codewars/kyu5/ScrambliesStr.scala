package ru.dust.codewars.kyu5

import scala.io.StdIn

object ScrambliesStr {

  def main(args: Array[String]): Unit = {

  }

  def scramble(s1: String, s2: String): Boolean = {
    val full: Map[Char, Int] = getCharCountMap(s1)
    val sub: Map[Char, Int] = getCharCountMap(s2)
    sub.keys.toArray.forall(full.keys.toArray.contains) && sub.keys.toArray.forall(ch => sub(ch) <= full(ch))
  }

  def getCharCountMap(s: String): Map[Char, Int] = {
    val unicChars: String = s.distinct
    unicChars.map(unicChar => (unicChar, s.count(ch => ch.equals(unicChar)))).toMap
  }

  def scrambleClever(s1: String, s2: String): Boolean = s2.diff(s1).isEmpty

}

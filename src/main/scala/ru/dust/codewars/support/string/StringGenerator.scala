package ru.dust.codewars.support.string

import scala.util.Random

object StringGenerator {

  def genRandomNextString(size: Int): String = {
    Random.nextString(size)
  }

  def genJavaStringBuilderRandomString(length: Int): String = {
    val r = new scala.util.Random
    val sb = new StringBuilder
    for (i <- 1 to length) {
      sb.append(r.nextPrintableChar)
    }
    sb.toString
  }

  def genStringArray(arraySize: Int, stringSizeBorder: Int = 10): Array[String] = {
    new Array[String](arraySize).map(el => genRandomNextString(Random.between(1, stringSizeBorder)))
  }

}

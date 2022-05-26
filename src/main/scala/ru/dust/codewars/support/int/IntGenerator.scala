package ru.dust.codewars.support.int

import scala.util.Random

object IntGenerator {

  def genIntArray(arraySize: Int): Array[Int] = {
    new Array[Int](arraySize).map(el => Random.nextInt())
  }

  def genIntArrayFromRange(start: Int, end: Int): Array[Int] = {
    start.to(end).toArray
  }

}

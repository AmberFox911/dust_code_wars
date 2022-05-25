package ru.dust.codewars.support.int

import scala.util.Random

object IntGeneretor {

  def genIntArray(arraySize: Int): Array[Int] = {
    new Array[Int](arraySize).map(el => Random.nextInt())
  }

}

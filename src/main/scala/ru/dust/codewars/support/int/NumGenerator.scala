package ru.dust.codewars.support.int

import scala.util.Random

object NumGenerator {

  def genIntArray(arraySize: Int): Array[Int] = {
    new Array[Int](arraySize).map(el => {var res = Random.nextInt(); if (res<0) res = res * -1 ; res})
  }

  def genLongArray(arraySize: Int): Array[Long] = {
    new Array[Long](arraySize).map(el => Random.nextLong())
  }

  def genIntArrayFromRange(start: Int, end: Int): Array[Int] = {
    start.to(end).toArray
  }

}

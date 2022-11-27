package ru.dust.codewars

import ru.dust.codewars.support.time.StopWatch
import scala.collection.parallel.ParSeq
import scala.collection.parallel.CollectionConverters._


object Test {

  def main(args: Array[String]): Unit = {
    val timer: StopWatch = new StopWatch
    val testList = (1 to 1000000).toList

    timer.changeStartTime
    testList.map(num => {
      1
    })
    println(timer.getDurationMillis)

    timer.changeStartTime
    testList.par.map(num => {
      1
    })
    println(timer.getDurationMillis)
  }

}

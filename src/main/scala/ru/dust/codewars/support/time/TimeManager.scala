package ru.dust.codewars.support.time

object TimeManager {

  def time[T](action: => T, actionName: String = "Some action"): T = {
    val stopWatch: StopWatch = new StopWatch
    println(s"Start action $actionName")
    stopWatch.changeStartTime
    val res = action
    println(s"End $actionName duration in mills: ${stopWatch.getDurationMillis}")
    println(s"$actionName duration in sec: ${stopWatch.getDurationSec}\n")
    res
  }

}

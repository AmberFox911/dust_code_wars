package ru.dust.codewars.support.time

class StopWatch {

  var startTime: Long = System.currentTimeMillis()

  def changeStartTime: Long = {
    startTime = System.currentTimeMillis()
    startTime
  }

  def getDurationMillis: Long = System.currentTimeMillis() - startTime

  def getDurationSec: Long = getDurationMillis / 1000

  def getDurationMin: Long = getDurationSec / 60

}

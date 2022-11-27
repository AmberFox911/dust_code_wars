package ru.dust.patterns.command.game.location

import ru.dust.patterns.command.game.entityes.GameEntity
import ru.dust.patterns.command.game.entityes.gameobjects.Space

trait Location {
  val sizeX: Int
  val sizeY: Int
  val field: Array[Array[GameEntity]]

  def showLocation(): Unit = {
    for (line <- field) {
      println()
      for (entity <- line) {
        print(entity.getName + "\t")
      }
    }
    println()
  }

  def putEntityInToField(entity: GameEntity , x: Int, y: Int): Unit = {
    checkFieldCoordinates(x = x, y = y)
    field(y - 1)(x - 1) = entity
  }

  def moveEntityOnField(from:(Int, Int), to: (Int, Int)): Unit = {
//    var tmp: GameEntity =
  }

  def deleteEntityFromField(x: Int, y: Int): Unit = field(y - 1)(x - 1) match {
    case p: Space => return
    case _ =>
      checkFieldCoordinates(x = x, y = y)
      field(y - 1)(x - 1) = new Space
  }

  private def checkFieldCoordinates(x: Int, y: Int): Unit = {
    assert(x > 0 && x <= sizeX)
    assert(y > 0 && y <= sizeY)
  }

}

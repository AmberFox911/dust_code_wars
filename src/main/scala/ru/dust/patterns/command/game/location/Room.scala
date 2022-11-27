package ru.dust.patterns.command.game.location

import ru.dust.patterns.command.game.entityes.GameEntity
import ru.dust.patterns.command.game.entityes.gameobjects.Space

class Room(override val sizeX: Int, override val sizeY: Int) extends Location {
  assert(sizeX > 0)
  assert(sizeY > 0)

  val field: Array[Array[GameEntity]] = initialField

  private def initialField: Array[Array[GameEntity]] = 1.to(sizeY).toArray.map(line => initialLine)
  private def initialLine: Array[GameEntity] = 1.to(sizeX).toArray.map(tale => new Space)

}

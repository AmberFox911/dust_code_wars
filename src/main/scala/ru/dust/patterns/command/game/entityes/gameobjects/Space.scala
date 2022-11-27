package ru.dust.patterns.command.game.entityes.gameobjects

class Space extends GameObject {

  override val name: String = "Empty space"
  val mark: String = "[]"

  override def getName: String = mark

}

package ru.dust.patterns.command.game.entityes

trait GameEntity {
  val name: String

  def getName: String = name

}

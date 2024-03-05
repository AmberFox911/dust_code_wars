package ru.dust.codewars.kyu5

/*
* You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place! So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:

["WEST"]
or
{ "WEST" }
or
[West]
Other examples:
In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.

The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).

In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].

Task
Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

The Haskell version takes a list of directions with data Direction = North | East | West | South.
The Clojure version returns nil when the path is reduced to nothing.
The Rust version takes a slice of enum Direction {North, East, West, South}.
See more examples in "Sample Tests:"
*
Notes
Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST"
are not directly opposite of each other and can't become such. Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
if you want to translate, please ask before translating.*/

object DirectionsReduction {

  def main(args: Array[String]): Unit = {
    println(dirReduc(Array("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")).mkString(" ")) // WEST
    println(dirReduc(Array("NORTH", "WEST", "SOUTH", "EAST")).mkString(" ")) // NORTH WEST SOUTH EAST
    println(dirReduc(Array("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH")).mkString(" ")) // NORTH
    println(dirReduc(Array("WEST", "EAST", "NORTH", "SOUTH", "EAST", "SOUTH", "NORTH", "NORTH", "SOUTH", "WEST", "SOUTH", "SOUTH", "EAST", "EAST")).mkString(" ")) // SOUTH, SOUTH, EAST, EAST)
    println(dirReduc(Array("WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH", "NORTH", "SOUTH")).mkString(" ")) //  (WEST, SOUTH)
  }

  def dirReduc(arr: Array[String]): Array[String] = {
    var deleteIndexes: Array[Int] = Array()
    def appendIfDeletePath(ind1: Int, ind2: Int): Unit = {
      if (ind1 < 0 || ind2 > arr.length - 1 || deleteIndexes.contains(ind1) || deleteIndexes.contains(ind2)) return
      val paths = Seq(arr(ind1), arr(ind2))
      val isDelete: Boolean = (paths.contains("WEST") && paths.contains("EAST")) || (paths.contains("NORTH") && paths.contains("SOUTH"))
      if (isDelete) deleteIndexes = deleteIndexes ++ Array(ind1, ind2)
    }
    val indexes = arr.indices
    indexes.foreach(ind => appendIfDeletePath(ind, ind+1))
    val res = indexes.filterNot(deleteIndexes.contains).map(arr(_)).toArray
    if (deleteIndexes.isEmpty) res else dirReduc(res)
  }

}

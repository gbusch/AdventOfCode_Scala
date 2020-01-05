package advent2019

object Day03 {
  def goOneStep(oldState: (Int, Int), direction: Char): (Int, Int) = {
    direction match {
      case 'R' => (oldState._1 + 1, oldState._2)
      case 'L' => (oldState._1 - 1, oldState._2)
      case 'U' => (oldState._1, oldState._2 + 1)
      case 'D' => (oldState._1, oldState._2 - 1)
      case _ => throw new Exception("allowed directions R, L, U, D")
    }
  }

  def applyOneCommand(oldState: (Int, Int), command: String): List[(Int, Int)] = {
    val splitCommand = command.toCharArray
    val direction = splitCommand(0)
    val times = splitCommand.drop(1).mkString.toInt

    List.fill(times)(direction).scanLeft(oldState)(goOneStep).tail
  }

  def getOnePath(commands: List[String]): List[(Int, Int)] = {
    def addOneCommand(oldPath: List[(Int, Int)], command: String): List[(Int, Int)] = {
      oldPath ++ applyOneCommand(oldPath.last, command)
    }
    commands.foldLeft(List((0, 0)))(addOneCommand)
  }

  def getDistanceOfClosestIntersections(commands1: List[String], commands2: List[String]): Int = {
    val path1 = getOnePath(commands1).tail.toSet
    val path2 = getOnePath(commands2).tail.toSet
    val intersections = path1.intersect(path2)
    intersections.map((x: (Int, Int)) => x._1.abs + x._2.abs).min
  }

  def getStepsOfClosestIntersections(commands1: List[String], commands2: List[String]): Int = {
    val path1 = getOnePath(commands1).tail
    val path2 = getOnePath(commands2).tail
    val intersections = path1.toSet.intersect(path2.toSet)
    // index is 0 based, therefore +2
    intersections.map((x: (Int, Int)) => path1.indexOf(x) + path2.indexOf(x)).min + 2
  }


  val data: Seq[String] = io.Source.fromResource("day03.txt").mkString.trim.linesIterator.toSeq
  val paths: Seq[List[String]] = data.map(_.split(",").toList)

  def main(args: Array[String]): Unit = {
    println("PART ONE")
    println(getDistanceOfClosestIntersections(paths(0), paths(1)))

    println("PART TWO")
    println(getStepsOfClosestIntersections(paths(0), paths(1)))
  }
}

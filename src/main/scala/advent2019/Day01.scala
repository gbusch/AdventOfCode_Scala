package advent2019

object Day01 {
  def fuelPerModule(mass: Int): Int = {
    (math.floor(mass / 3) - 2).toInt
  }

  def allFuelPerModule(mass: Int): Int = {
    val additionalFuel: Int = fuelPerModule(mass)
    if (additionalFuel < 0) {
      0
    } else {
      additionalFuel + allFuelPerModule(additionalFuel)
    }

  }


  val data: String = io.Source.fromResource("day01.txt").mkString.trim
  val inputMasses: Seq[Int] = data.linesIterator.map(_.toInt).toSeq

  def main(args: Array[String]): Unit = {
    println("PART ONE")
    println(inputMasses.map(fuelPerModule).sum)

    println("PART TWO")
    println(inputMasses.map(allFuelPerModule).sum)
  }
}

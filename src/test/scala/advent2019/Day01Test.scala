package advent2019

import org.scalatest.FunSuite

class Day01Test extends FunSuite {
  test("Day01.fuelPerModule") {
    assert(Day01.fuelPerModule(12) == 2)
    assert(Day01.fuelPerModule(14) == 2)
    assert(Day01.fuelPerModule(1969) == 654)
    assert(Day01.fuelPerModule(100756) == 33583)
  }

  test("Day01.allFuelPerModule") {
    assert(Day01.allFuelPerModule(14) == 2)
    assert(Day01.allFuelPerModule(1969) == 966)
    assert(Day01.allFuelPerModule(100756) == 50346)
  }
}
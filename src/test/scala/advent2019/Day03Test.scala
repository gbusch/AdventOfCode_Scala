package advent2019

import org.scalatest.FunSuite

class Day03Test extends FunSuite {
  test("Day03.goOneStep") {
    assert(Day03.goOneStep((0, 0), 'R') == (1, 0))
    assert(Day03.goOneStep((1, 1), 'L') == (0, 1))
    assert(Day03.goOneStep((0, 0), 'U') == (0, 1))
    assert(Day03.goOneStep((-1, -1), 'D') == (-1, -2))
  }

  test("Day03.applyOneCommand") {
    assert(Day03.applyOneCommand((1, 1), "R2") == List((2, 1), (3, 1)))
  }

  test("Day03.getOnePath") {
    assert(Day03.getOnePath(List("R2", "U1")) == List((0, 0), (1, 0), (2, 0), (2, 1)))
  }

  test("get distance of closest intersection") {
    assert(Day03.getDistanceOfClosestIntersections(
      List("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"),
      List("U62", "R66", "U55", "R34", "D72", "R55", "D58", "R83")
    ) == 159)
    assert(Day03.getDistanceOfClosestIntersections(
      List("R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"),
      List("U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7")
    ) == 135)
  }

  test("get steps of closest intersections") {
    assert(Day03.getStepsOfClosestIntersections(
      List("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"),
      List("U62", "R66", "U55", "R34", "D72", "R55", "D58", "R83")
    ) == 610)
    assert(Day03.getStepsOfClosestIntersections(
      List("R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"),
      List("U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7")
    ) == 410)
  }
}

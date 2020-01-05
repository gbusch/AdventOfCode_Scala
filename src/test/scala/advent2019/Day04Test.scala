package advent2019

import org.scalatest.FunSuite

class Day04Test extends FunSuite {
  test("Day04 convert to List") {
    assert(Day04.convertToList("111111") == List(1, 1, 1, 1, 1, 1))
    assert(Day04.convertToList("223450") == List(2, 2, 3, 4, 5, 0))
    assert(Day04.convertToList("123789") == List(1, 2, 3, 7, 8, 9))
  }

  test("Day04 Part 1") {
    assert(Day04.checkPart1(List(1, 1, 1, 1, 1, 1)))
    assert(!Day04.checkPart1(List(2, 2, 3, 4, 5, 0)))
    assert(!Day04.checkPart1(List(1, 2, 3, 7, 8, 9)))
  }

  test("Day04 Part 2") {
    assert(Day04.checkPart2(List(1, 1, 2, 2, 3, 3)))
    assert(!Day04.checkPart2(List(1, 2, 3, 4, 4, 4)))
    assert(Day04.checkPart2(List(1, 1, 1, 1, 2, 2)))
  }
}

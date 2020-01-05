package advent2019
import Array._
import scala.collection.MapView

object Day04 {
  def convertToList(number: String): List[Int] = {
    number.toArray.map(_.asDigit).toList
  }

  def counter[T](l: List[T]): MapView[T, Int] = {
    l.groupBy(x => x).mapValues(_.length)
  }

  @scala.annotation.tailrec
  def neverDecrease(first: Int, tail: List[Int]): Boolean = {
    if (tail.isEmpty) true
    else {
      if (first <= tail.head) neverDecrease(tail.head, tail.tail)
      else false
    }
  }

  def checkPart1(input: List[Int]): Boolean = {
    neverDecrease(input.head, input.tail) && !counter(input).values.toList.filter(_>=2).isEmpty
  }

  def checkPart2(input: List[Int]): Boolean = {
    neverDecrease(input.head, input.tail) && counter(input).values.toList.contains(2)
  }

  val puzzleInput = "134564-585159"
  val inputValues = puzzleInput.split("-").map(_.toInt)
  val inputRange: List[List[Int]] = range(inputValues(0), inputValues(1)).map(_.toString).map(convertToList).toList

  def main(args: Array[String]): Unit = {
    println("PART ONE")
    println(inputRange.map(checkPart1).count(_==true))

    println("PART TWO")
    println(inputRange.map(checkPart2).count(_==true))
  }
}

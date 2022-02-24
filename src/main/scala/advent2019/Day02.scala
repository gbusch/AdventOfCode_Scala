// very much based on:
// https://github.com/sim642/adventofcode/blob/master/src/main/scala/eu/sim642/adventofcode2019/Day2.scala

package advent2019

object Day02 {
  type Memory = Vector[Int]

  case class ProgramState(memory: Memory, instruction_pointer: Int = 0) {
    def instruction(i: Int): Int = memory(instruction_pointer + i)
    def opcode: Int = instruction(0)
    def parameter(i: Int): Int = instruction(i + 1)

    def oneStep: Option[ProgramState] = {
      opcode match {
        case 1 =>
          val newValue = memory(parameter(0)) + memory(parameter(1))
          val newMemory = memory.updated(memory(2), newValue)
          Some(ProgramState(newMemory, instruction_pointer + 4))
        case 2 =>
          val newValue = memory(parameter(0)) * memory(parameter(1))
          val newMemory = memory.updated(memory(2), newValue)
          Some(ProgramState(newMemory, instruction_pointer + 4))
        case 99 => None
      }
    }

  }


  val data: String = io.Source.fromResource("day02.txt").mkString.trim
  val inputProgram: Seq[Int] = data.split(",").map(_.toInt).toVector

  def main(args: Array[String]): Unit = {
    println("PART ONE")
    println(inputProgram)
  }

}

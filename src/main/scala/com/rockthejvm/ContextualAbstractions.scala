package com.rockthejvm

object ContextualAbstractions {

  /*
  1 - context parameters/arguments
   */
  val aList = List(2,1,3,4)
  val anOrderedList = aList.sorted // (ordering)
  val otherList = aList.sorted(Ordering.Int.reverse)


  trait Combinator[A] {
    def combine(x: A, y: A) : A
  }

  /*
  2 - extension methods
   */

  case class Person(name: String) {
    def greet() : String = s"Hi, my name is $name, I love scala"
  }





  // combineAll(List(1,2,3,4))

  def main(args: Array[String]) : Unit = {
    println(otherList)
    println(otherList.sum)
  }

}

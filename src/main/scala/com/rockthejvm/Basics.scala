package com.rockthejvm

// We have to extend our class with App class so that we can get the capabilities of running it as an application
object Basics extends App {
  // defining a value
  // Reassigning of a value in scala is banned
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42;
  // Compiler is smart enough to figure out types so no need to specify it explicitly
  // Type mentioning is optional
  // Int, Boolean, Char, Double, Float, String are the standard types we use in scala
  val aBoolean = false
  val aString = "I Love Scala"
  val aComposedString = "I" + " " + "love" +" " +"Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife" //Like f string in python

  // expressions = structures that can be reduced to a value
  val anExpression = 2+3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // in other languages meaningOfLife > 43 ? 56 : 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife <0) -2
    else if (meaningOfLife > 999) 78
    else 0

    // code blocks can have other classes or methods or even nested code blocks
    // but they have to return something at the end
    val aCodeBlock = {
      // definitions
      val aLocalValue = 67

      // value of block is the value of the last expression
      aLocalValue + 3
    }

    // define a function
    def myFunction(x: Int, y: String): String = {
      y + " " + x
    }

  // recursive function
  def factorial(n: Int): Int =
    if (n<=1) 1
    else n* factorial(n-1)

  /*
  factorial(5) = 5 * factorial(4)
  factorial(4) = 4 * factorial(3)
  factorial(3) = 3 * factorial(2)
  factorial(2) = 2 * factorial(1)
  factorial(1) = 1
    */

  // In Scala we don't use loops or iteration, we use RECURSION!

  // the Unit type = no meaningful value === "void" in other languages
  // type of SIDE EFFECTS
  // Side effects are methods which don't do meaningful computation but instead are simply used for the purpose of returning something onto a screen or taking some input from user or connecting to a server socket etc..
  println("I love Scala") // System.put.println, printf, print, console.log
  def myUnitReturningFunction() : Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()


}

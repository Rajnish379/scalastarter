package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App{
  /**
   *
  lazy evaluation
   */
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }
  // Lazy value was evaluated because of this eagerValue and hence we can see te print statement and the answer to the expression
  val eagerValue = lazyValueWithSideEffect +2

  // useful in infinite collections

  /**
   "pseudo-collections" : Option Try
   */

  def methodWhichCanReturnNull() : String = "hello,Scala"
//  if (methodWhichCanReturnNull() == null) {
//    // defensive code against null
//  }
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string $string"
    case None => "I have obtained nothing"
  }

  // map, flatMap, filter

  def methodWhichCanThrowException() : String = throw new RuntimeException
//  try {
//    methodWhichCanThrowException()
//  } catch {
//    case e: Exception => "Evil exception"
//  }
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string $validValue"
    case Failure(ex) => s"I have obtained an exception $ex"
  }
  // map, flatMap, filter

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */
  val aFuture = Future{
    println("Loading....")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  }

    // future is a "collection" which contains a value when its evaluated
    // future is composable with map, flatMap and filter
  // monads

  /**
   * Implicits basics
   */

  //#1: Implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2: implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0

  }
  println(23.isEven()) // new MyRichInteger(23), isEven()
  // use this carefully



}

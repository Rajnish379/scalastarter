package com.rockthejvm

object ObjectOrientation extends App{
  // App class has a main method already implemented in it which is similar to the java code below
  // java public static voide main(String[] args)

  // class and instance
  class Animal {
    // define fields
    val age: Int = 0
    // define methods
    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal

  // inheritance
  class Dog(val name:String) extends Animal // constructor definition
  val aDog = new Dog("Lassie")

  // constructor arguments are NOT fields: need to put a val before the constructor argument to promote it to a class field
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    // protected means the class and it's descendants both will have access to the value
    // private means only the class alone will have access
    // private>protected>public in terms of privacy
    val hasLegs = true // by default public, can restrict by adding protected and private
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought:String) : Unit // valid method name

  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("Iam eating you, animal!")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")

  }
  val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog // infix notation = object method argument, only available for methods with one argument
    aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore{
    override def eat(animal: Animal): Unit = println("I am a dinosaur so i can eat pretty much anything")
  }
  /*
  What you tell the compiler:

  class Carnivore_Anonymous_35728 extends Carnivore {
      override def eat(animal: Animal): Unit = println("I am a dinosaur so i can eat pretty much anything")

  }
  val dinosaur = new Carnivore_Anonymous_35728
   */

  // singleton object
  object MySingleton{
    val mySpecialValue = 77
    def mySpecialMethod(): Int = 567
    def apply(x: Int) : Int = x+1
  } // the only instance of the MySingleton type
  MySingleton.mySpecialMethod()
  MySingleton.apply(56)
  MySingleton(56) // equivalent to MySingleton.apply(56)
  object Animal { // companions - Companion Object
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // 'static" fields/methods

  /*
  case classes = lightweight data structures with some boilerplate
   - sensible equals and hash code
   - serialization
   - companion with apply
   */

  case class Person(name:String, age: Int)

  // may be constructed without new
  val bob = Person("Bob", 54) // Person.apply("Bob",54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch { // catch(Exception e) {...}
    case e: Exception => "Some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail

  val aStringList = List("hello","scala")
  val firstString = aStringList.head // string

  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
  Benefits:
  1) works miracles in multithreaded/distributed env
  2) helps making sense of the code ("reasoning about")
   */
  val reversedList = aList.reverse // returns a NEW list

  // Point #2: Scala is closest to the Object oriented ideal
}

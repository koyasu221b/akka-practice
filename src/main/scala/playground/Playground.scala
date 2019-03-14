package playground

import akka.actor.ActorSystem

object Playground extends App {

  val actorSystem = ActorSystem("HelloAkka")
  println(actorSystem.name)


  val theUit = println("Hello, Scala")

  def aFunction(x: Int) = x + 1

  def factorial(n: Int, acc: Int): Int =
    if( n <= 0) acc
    else factorial(n-1, acc * n)

  //OPP
  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog

  trait Carnivore {
    def eat(a: Animal): Unit

  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("hi")

  }

  // method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)

  //anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = print("hihi")
  }

  // generics
  abstract class MyList[+A]

  // companion objects
  object MyList

  //case classes
  case class Person(name: String, age: Int)

  //Exceptions
  val aPotentialFailure = try {
    throw new RuntimeException("test") ; //Nothing
  }catch {
    case e: Exception => "exception1"
  }finally {
    println("finally")
  }

  val incrementer = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  val incremented = incrementer(42)

  val anonymousIncrementer = (x: Int) => x + 1
  // Int => Int === Function1[Int, Int]

  // FP is all about working with functions as first-class
  List(1, 2, 3).map(incrementer)

  // map = HOF

  // for comprehensions
  val pairs = for {
    num <- List(1, 2, 3, 4)
    char <- List('a', 'b', 'c', 'd')
  }yield num + "-" + char

  // List(1,2,3,4).flapMap(num => List('a', 'b', 'c', 'd').map(char => num + "-" + char))

  // Seq, Array, List, Vector, Map, Tuples

}

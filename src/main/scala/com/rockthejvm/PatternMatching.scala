package com.rockthejvm

object PatternMatching extends App {
    // switch expression
    val anInteger = 55
    val order = anInteger match {
      case 1 => "first"
      case 2 => "second"
      case 3 => "third"
      case _ => anInteger + "th"
    }
    println(order)

  // PM is an equivalent of a SWITCH expression
  // able to deconstruct data structures

  // case class decomposition
  case class Person(name: String, age: Int) // case classes don't need to ne extenciated with the command 'new', as they have a companion object with an apply function
  val bob = new Person("Bob", 99) // equivalent to Person.apply("Bob", 43)

  val personGreeting = bob match { // it matches Bob against this structure
    case Person(n ,a) => s"Hi, my name is $n and I am $a years old."
    case _ => "Something else"
  }
  println(personGreeting)

  // PM is available only for case classes

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about"
  }

  // decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on it's second position"
    case _ => "unknown list" // if PM doesn't match anything, it will throw a MatchError
    // including a _ in the end a.k.a. 'else' is best practice
    // PM will try all cases in sequence
  }
}

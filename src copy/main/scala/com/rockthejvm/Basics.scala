package com.rockthejvm

object Basics extends App {
  // defining a value
  // same in JS: const meaningOfLife = 42
  //reassigning of val is illegal
  // Int, Boolean, Char, Double, Float, String - possible types
  val meaningOfLife: Int = 42
  val aBoolean = false //mentioning type is optional

//Strings and strings operations
  val aString = "I love Scala"
  val aComposedString = "I" + " love" + " Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //Expressions - structures that can be reduced to a value
  val anExpression = 2 + 3

  //if-statement is also an expression as it resolves to a single value
  val ifExpression = if (meaningOfLife > 43) 56 else 999

  // this is still an expression -> we assign a value depending if the condition is true
  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0
  }

  //code blocks
  val aCodeBlock = { //compiler will figure out the Int type itself
    //definitions - can define values, functions, inner code blocks, etc
    val aLocalValue = 67

    //value of block is the value of the last expression
    aLocalValue + 3
  }

  //defining a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  //recursive function - depends on it's own definition
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }
  /*
    factorial(3) = 3 * factorial(2) = 3 * 2 = 6
    factorial(2) = 2 * factorial(1) = 2 * 1
    factorail(1) = 1
  */
  // Scala doesn't use loops or iterations, it uses RECURSIONS!

  // the Unit type = no meaningful value === 'void' in other languages
  // type of SIDE EFFECTS
  println("I love Scala") //equivalent of console.log

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()// the only value container by the Unit type
}

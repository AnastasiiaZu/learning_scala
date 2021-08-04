package com.rockthejvm

import java.awt.im.spi.InputMethod
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global // to run futures

object Advanced extends App {

  // lazy evaluation = expression is not evaluated until its first use

  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffects = {
    println("I am so very lazy!") // prints nothing
    43
  }

  val eagerValue = lazyValueWithSideEffects + 1 // the code block would get evaluated and printed only now
  // lazy eval is useful in infinite collections

  // pseudo-collections: Option type and Try type
  //Options
  // very useful in unsafe methods = method that might return NULL
  def methodWhichCanReturnNull(): String = "Hello, Scala"
  if (methodWhichCanReturnNull() == null){
    // would have to write defensive code against null here
  }
    // but in Scala we don't have to do that!
  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello, Scala) Some = subtype of an Option abstract type
  // option = "collection" which contains at most one element: Some(value) OR None = a singleton object
  // None is an equivalent of null but it has a value

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }
  // can also operate it with map, flatMap, filter

  // Try
  def methodWhichCanThrowException(): String = throw new RuntimeException // exceptions are very bad for JVM
  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "defend against this evil exception"
  } // we don't need this anymore

  val aTry = Try(methodWhichCanThrowException())
  // a Try = "collection" with either a value if the code went well, or an Exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }
  // have map, flatMap, filter compositional functions

  /* Evaluate something on another thread ->
  a.k.a. asynchronous programming
  -> futures!
  */

  val aFuture = Future { // = Future.apply
    println("Loading...")
    Thread.sleep(1000) // blocks the running thread by 1 sec
    println("I have computed a value.")
    67
  }

  // future is a "collection" which contains a value when it's evaluated. Until then it does not contain any value
  // future is composable with map, flatMap and filter
  // monads = Future, Try, Option types - super abstract and hard to explain

  /**
  * implicits basics
  */
  // #1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // = aMethodWithImplicitArgs(myImplicitInt)

  // #2: implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // = new MyRichInteger(23).isEven()






 





}

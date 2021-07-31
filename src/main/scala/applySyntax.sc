import cats.instances.option._
import cats.syntax.apply._

(Option(123), Option("abc")).tupled

case class Cat(name: String, born: Int, color: String)

(
  Option("Garfield"),
  Option(1978),
  Option("Orange & black")
).mapN(Cat.apply)

import cats.Monoid
import cats.instances.int._
import cats.instances.invariant._
import cats.instances.list._
import cats.instances.string._
import cats.syntax.apply._

case class Cat (name: String, yearOfBirth: Int, favoriteFoods: List[String])

val tupleToCat: (String, Int, List[String]) => Cat = Cat.apply
val catToTuple: Cat => (String, Int, List[String]) =
  cat => (cat.name, cat.yearOfBirth, cat.favoriteFoods)

implicit val catMonoid: Monoid[Cat] = (
  Monoid[String],
  Monoid[Int],
  Monoid[List[String]]
).imapN(tupleToCat)(catToTuple)

import cats.syntax.semigroup._

val garfield = Cat("Garfield", 1978, List("Lasagne"))
val healthcliff = Cat("HealthCliff", 1988, List("Junk Food"))

garfield |+| healthcliff
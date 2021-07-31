import cats.Semigroupal
import cats.instances.option._
import cats.instances.list._


Semigroupal[Option].product(Some(123), Some("abc"))
Semigroupal[List].product(List(1,2,3), List("a","b","c"))

Semigroupal.tuple3(Option(1), Option(2), Option(3))

Semigroupal.tuple3(Option(1), Option(2), Option.empty[Int])

Semigroupal.map3(Option(1), Option(2), Option(3))(_+_+_)

Semigroupal.map2(Option(1), Option.empty[Int])(_+_)

import cats.Semigroupal
import cats.instances.future._
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.higherKinds

val futurePair = Semigroupal[Future]
  .product(Future("Hello"), Future(123))

Await.result(futurePair, 1.second)
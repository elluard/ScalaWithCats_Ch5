import cats.syntax.either._

def parseInt(str: String): Either[String, Int] =
  Either
    .catchOnly[NumberFormatException](str.toInt)
    .leftMap(_ => s"Couldn't read $str")

val test = parseInt("123")

for{
  a <- parseInt("a")
  b <- parseInt("b")
  c <- parseInt("c")
} yield (a + b + c)


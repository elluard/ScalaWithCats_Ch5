name := "ScalaWithCats_Ch5"

version := "0.1"

scalaVersion := "2.13.6"

scalacOptions += "-Ypartial-unification"

addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.0" cross CrossVersion.full)

libraryDependencies += "org.typelevel" %% "cats-core" % "2.3.0"

libraryDependencies ++= (scalaBinaryVersion.value match {
  case "2.10" =>
    compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full) :: Nil
  case _ =>
    Nil
})
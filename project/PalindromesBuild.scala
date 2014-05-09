import sbt._
import sbt.Keys._

object PalindromesBuild extends Build {

  lazy val palindromes = Project(
    id = "palindromes",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "palindromes",
      organization := "net.mcarolan",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.3",
      libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.3" % "test",
      libraryDependencies += "org.specs2" %% "specs2" % "2.3.10" % "test"
    )
  )
}

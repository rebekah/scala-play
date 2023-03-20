ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "scala-3-play",
    idePackagePrefix := Some("org.rwaterbury.scaladev"),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.15" % "test",
      "com.github.nscala-time" %% "nscala-time" % "2.32.0"
    )
  )

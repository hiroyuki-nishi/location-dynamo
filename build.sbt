import Dependencies._

lazy val commonSettings = Seq(
  organization := "nishi",
  scalaVersion := "2.13.0",
  scalacOptions:= Seq(
    "-deprecation",
    "-feature"
  ),
  scalafmtOnCompile in ThisBuild := true
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(location)
  .settings(name := "root")

lazy val domain = (project in file("modules/domain")).settings(commonSettings: _*)

lazy val location = (project in file("./modules/application/location")).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= ScalaTest
  ).
  settings(
    name := "location",
    mainClass in Compile := Some("Main"),
  )

lazy val infraDynamoDB = (project in file("./modules/adapter/infrastructure/dynamodb")).
  dependsOn(domain).
  settings(commonSettings: _*).
  settings(
    name := "infrastructure-dynamodb",
    libraryDependencies ++= ScalaTest ++ awsDynamoDB ++ sprayJson
  )

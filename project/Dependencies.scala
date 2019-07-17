import sbt._

object Dependencies {
  val ScalaTest = Seq(
    "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )

  val awsSDKVersion = "1.11.+"
  val awsDynamoDB = Seq("com.amazonaws" % "aws-java-sdk-dynamodb" % awsSDKVersion)

  val sprayJson = Seq("io.spray" %%  "spray-json" % "1.3.5")
}

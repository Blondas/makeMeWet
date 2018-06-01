name := "scala-workshops"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % "2.5.12",
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.12" % Test,
  "com.typesafe.akka" %% "akka-http" % "10.1.1",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.1" % Test
)

mainClass in assembly := Some("com.krisdrum.Startpoint")
name := "akka-practice"

version := "0.1"

scalaVersion := "2.11.7"


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.21",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.21" % Test
)



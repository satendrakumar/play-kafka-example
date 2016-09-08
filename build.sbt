name := """play-kafka-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.11" % "0.10.0.1",
  "com.typesafe.akka" %% "akka-actor" % "2.4.10",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)


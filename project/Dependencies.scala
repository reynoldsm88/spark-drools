import sbt.Keys._
import sbt._

object Dependencies {

  val slf4jVersion = "1.7.21"
  val logbackVersion = "1.1.7"
  val junitVersion = "4.12"
  val junitInterfaceVersion = "0.8"
  val sparkVersion = "2.0.0"

  val slf4j = Seq( "org.slf4j" % "slf4j-api" % "1.7.5" )

  val logback = Seq( "ch.qos.logback" % "logback-classic" % logbackVersion )

  val junit = Seq( "junit" % "junit" % junitVersion % "test" )

  val junitInterface = Seq( "com.novocode" % "junit-interface" % junitInterfaceVersion % "test" )

  val spark = Seq( "org.apache.spark" %% "spark-core" % "2.0.2" % "provided" )

}
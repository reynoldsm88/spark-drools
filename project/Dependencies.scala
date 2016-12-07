import sbt.Keys._
import sbt._

object Dependencies {

  val slf4jVersion = "1.7.5"
  val logbackVersion = "1.1.7"
  val junitVersion = "4.12"
  val junitInterfaceVersion = "0.8"
  val sparkVersion = "2.0.0"
  val droolsVersion = "6.5.0.Final"
  val openNLPVersion = "1.6.0"
  val hadoopVersion = "2.7.3"
  val betterFilesVersion = "2.16.0"


  val slf4j = Seq( "org.slf4j" % "slf4j-api" % slf4jVersion )

  val logback = Seq( "ch.qos.logback" % "logback-classic" % logbackVersion )

  val junit = Seq( "junit" % "junit" % junitVersion % "test" )

  val junitInterface = Seq( "com.novocode" % "junit-interface" % junitInterfaceVersion % "test" )

  val spark = Seq( "org.apache.spark" %% "spark-core" % "2.0.2" % "provided" )
  val sparkEmbedded = Seq( "org.apache.spark" %% "spark-core" % "2.0.2" )

  val drools = Seq( "org.drools" % "drools-core" % droolsVersion,
                    "org.drools" % "drools-compiler" % droolsVersion )

  val kieAPI = Seq( "org.kie" % "kie-api" % droolsVersion,
                    "org.kie" % "kie-internal" % droolsVersion )

  val openNLP = Seq( "org.apache.opennlp" % "opennlp-tools" % openNLPVersion )

  val betterFiles = Seq( "com.github.pathikrit" %% "better-files" % betterFilesVersion )

  val hadoop = Seq( "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion % "provided",
                    "org.apache.hadoop" % "hadoop-client" % hadoopVersion % "provided" )

}
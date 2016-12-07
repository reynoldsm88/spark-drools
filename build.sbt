import sbt._
import Dependencies._

organization := "org.mireynol"
name := "spark-drools"
version := "0.0.1-SNAPSHOT"
scalaVersion in ThisBuild := "2.11.8"

ivyScala := ivyScala.value map {
  _.copy( overrideScalaVersion = true )
}

resolvers in ThisBuild ++= Seq( "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
                                "Spray IO Repository" at "http://repo.spray.io/",
                                "Maven Central" at "https://repo1.maven.org/maven2/" )

lazy val root = ( project in file( "." ) ).aggregate( model, droolsJob, corporaProcessingJobs )

lazy val model = ( project in file( "spark-drools-model" ) )

lazy val corporaProcessingJobs = ( project in file( "corpora-processing-jobs" ) )
  .settings( libraryDependencies ++= slf4j ++ logback ++ openNLP ++ betterFiles ++ hadoop ++ spark )
  .dependsOn( model )
  .enablePlugins( JavaAppPackaging )

lazy val droolsJob = ( project in file( "spark-drools-job" ) )
  .settings( libraryDependencies ++= slf4j ++ logback ++ drools ++ kieAPI ++ spark ++ openNLP )
  .dependsOn( model )
  .enablePlugins( JavaAppPackaging )
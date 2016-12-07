package org.mireynol.spark.drools

import org.kie.api.KieServices
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import scala.collection.mutable.HashSet


object Main {
  def main( args : Array[ String ] ) = {
    val logFile = "/Users/michael/tools/spark/README.md" // Should be some file on your system
    val conf = new SparkConf( ).setAppName( "Simple Application" )
    val sc = new SparkContext( conf )
    val logData = sc.textFile( logFile )
    val results = logData.flatMap( line => line.split( " " ) ).map( word => (word, 1) ).reduceByKey( _ + _ )
    results.foreach( x => println( x._1 + " = " + x._2 ) )
    sc.stop( )
  }
}
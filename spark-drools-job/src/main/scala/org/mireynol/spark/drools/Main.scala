package org.mireynol.spark.drools

import org.kie.api.KieServices

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object Main {
  def main( args : Array[ String ] ) = {
        val logFile = "/Users/michael/tools/spark/README.md" // Should be some file on your system
        val conf = new SparkConf( ).setAppName( "Simple Application" )
        val sc = new SparkContext( conf )
        val logData = sc.textFile( logFile, 2 ).cache( )
        val numAs = logData.filter( line => line.contains( "a" ) ).count( )
        val numBs = logData.filter( line => line.contains( "b" ) ).count( )
        println( s"Lines with a: $numAs, Lines with b: $numBs" )
        sc.stop( )
    val ks = KieServices.Factory.get( )
    println( ks )
  }
}
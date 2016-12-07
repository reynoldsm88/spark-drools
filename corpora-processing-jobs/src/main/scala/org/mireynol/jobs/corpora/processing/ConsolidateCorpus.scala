package org.mireynol.jobs.corpora.processing

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.mireynol.util.HDFS

import scala.collection.mutable.ListBuffer

object ConsolidateCorpus {

  def main( args : Array[ String ] ) = {
    val conf = new SparkConf( ).setAppName( "Consolidate Corpus" )
    val sc = new SparkContext( conf )

    val mergedFilename = "/etc/data/corpus-LATEST.dat"
    HDFS.rm( mergedFilename, true )

    val buffer : ListBuffer[ RDD[ String ] ] = ListBuffer[ RDD[ String ] ]( )
    HDFS.ls( "/etc/data" ).filter( _.endsWith( ".part" ) ).foreach( filename => {
      buffer += sc.textFile( filename )
    } )

    val combined = sc.union( buffer.toList ).coalesce( 1, false )
    combined.saveAsTextFile( mergedFilename )

    HDFS.ls( "/etc/data/" ).foreach( println )

    sc.stop( )
  }

}

package org.mireynol.util

import java.io.{BufferedInputStream, OutputStreamWriter}

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object HDFS {

  def log : Logger = LoggerFactory.getLogger( HDFS.getClass )

  val hadoop : FileSystem = {
    val conf = new Configuration( )
    conf.set( "fs.defaultFS", "hdfs://localhost:9000" )
    FileSystem.get( conf )
  }

  def readAndMap( path : String, mapper : ( String ) => Unit ) = {
    if ( hadoop.exists( new Path( path ) ) ) {
      val is = new BufferedInputStream( hadoop.open( new Path( path ) ) )
      Source.fromInputStream( is ).getLines( ).foreach( mapper )
    }
    else {
      // TODO - error logic here
    }
  }

  def write( filename : String, content : Iterator[ String ] ) = {
    val path = new Path( filename )
    val out = new OutputStreamWriter( hadoop.create( path, false ) )
    content.foreach( str => out.write( str + "\n" ) )
    out.flush( )
    out.close( )
  }

  def ls( path : String ) : List[ String ] = {
    val files = hadoop.listFiles( new Path( path ), false )
    val filenames = ListBuffer[ String ]( )
    while ( files.hasNext ) filenames += files.next( ).getPath( ).toString( )
    filenames.toList
  }

  def rm( path : String, recursive : Boolean ) : Unit = {
    if ( hadoop.exists( new Path( path ) ) ) {
      println( "deleting file : " + path )
      hadoop.delete( new Path( path ), recursive )
    }
    else {
      println( "File/Directory" + path + " does not exist" )
      log.warn( "File/Directory" + path + " does not exist" )
    }
  }

  def cat( path : String ) = Source.fromInputStream( hadoop.open( new Path( path ) ) ).getLines( ).foreach( println )

}

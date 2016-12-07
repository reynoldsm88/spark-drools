package org.mireynol.jobs.corpora.processing

import java.io.{File => JFile}
import java.nio.file.Paths

import better.files.File
import org.apache.hadoop.fs.{FileSystem, Path}
import org.mireynol.util.HDFS
import org.slf4j.LoggerFactory

object Main {

  val LOG = LoggerFactory.getLogger( Main.getClass )

  // TODO - move this all into configuration files
  val DATA_ROOT = "/Users/michael/tools/data"
  val RAW_INPUT_FILES = DATA_ROOT + JFile.separator + "raw"
  val PRE_PROCESSED_FILE_DIR = DATA_ROOT + JFile.separator + "pre-processed"
  val FILTER_NAME = "<Michael Reynolds>"

  def main( args : Array[ String ] ) : Unit = {
    val root = File( Paths.get( RAW_INPUT_FILES ) )
    root.list.filter( _.name.endsWith( "raw" ) ).foreach( rawFile => writeProcessedFile( rawFile, processFile( rawFile ) ) )
  }

  def writeProcessedFile( source : File, content : Iterator[ String ] ) = {
    val splitFileName = source.name.split( ".raw" )( 0 )
    println( "writing file : " + "/etc/data/" + splitFileName + "-" + System.currentTimeMillis( ) + ".part" )
    HDFS.write( "/etc/data/" + splitFileName + "-" + System.currentTimeMillis( ) + ".part", content )
  }

  def processFile( file : File ) : Iterator[ String ] = file.lines.filter( _.contains( FILTER_NAME ) ).map( removeMetadata( _ ) ).toIterator

  def removeMetadata( message : String ) : String = message.split( FILTER_NAME )( 1 ).trim
}
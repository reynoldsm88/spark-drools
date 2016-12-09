package org.mireynol.model

import scala.beans.BeanInfo
import scala.collection.mutable.ListBuffer

@BeanInfo
case class Phrase( text : String ) {

  final val ngrams : List[ NGram ] = makeNGrams( LangConfig.SENTENCE_BEGIN + " " + text + " " + LangConfig.SENTENCE_END )

  def makeNGrams( text : String ) : List[ NGram ] = {
    val strings : Array[ String ] = text.split( " " )
    val ngrams : ListBuffer[ NGram ] = ListBuffer[ NGram ]( )
    if ( strings.size >= LangConfig.NGRAM_SIZE ) {
      for ( i <- 0 to strings.size - LangConfig.NGRAM_SIZE ) {
        ngrams += NGram( strings.slice( i, strings.size ) )
      }
    }
    ngrams.toList
  }

}
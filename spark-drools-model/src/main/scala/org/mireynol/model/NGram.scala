package org.mireynol.model

import scala.beans.BeanInfo

@BeanInfo
case class NGram( strings : Array[ String ] ) {
  val root : String = deriveRoot( strings )
  val stem : String = deriveStem( strings )

  private def deriveRoot( strings : Array[ String ] ) : String = {
    val fullGram = strings.slice( 0, LangConfig.NGRAM_SIZE )
    val root = fullGram.slice( 0, fullGram.size - 1 )
    root.mkString( " " )
  }

  private def deriveStem( strings : Array[ String ] ) : String = {
    val fullGram = strings.slice( 0, LangConfig.NGRAM_SIZE )
    fullGram( LangConfig.NGRAM_SIZE - 1 )
  }

  override def toString( ) : String = "NGram{ ( " + root + " ) | " + stem + " }"

  override def equals( obj : scala.Any ) : Boolean = {
    if ( !obj.isInstanceOf[ NGram ] ) false
    val other = obj.asInstanceOf[ NGram ]
    if ( other.root == this.root && other.stem == this.stem ) {
      true
    }
    else {
      false
    }
  }
}

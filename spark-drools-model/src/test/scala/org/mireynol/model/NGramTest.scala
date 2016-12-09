package org.mireynol.model

import org.junit.Assert._
import org.junit.{Ignore, Test}

class NGramTest {

  @Test
  def getNGramRootForTrigramTest = {
    val sentence = "My name is Michael"
    val p : Phrase = Phrase( sentence )
    assertTrue( p.ngrams.size == 4 )

    // expected
    val n1 = NGram( Array[ String ]( LangConfig.SENTENCE_BEGIN, "My", "name" ) )
    val n2 = NGram( Array[ String ]( "My", "name", "is" ) )
    val n3 = NGram( Array[ String ]( "name", "is", "Michael" ) )
    val n4 = NGram( Array[ String ]( "is", "Michael", LangConfig.SENTENCE_END ) )

    println( p.ngrams( 0 ) == n1 )
    assertTrue( p.ngrams.contains( n1 ) )
    assertTrue( p.ngrams.contains( n2 ) )
    assertTrue( p.ngrams.contains( n3 ) )
    assertTrue( p.ngrams.contains( n4 ) )
  }

  @Test
  def edgeCaseOnlyOneWord = {
    val sentence = "one"
    val p : Phrase = Phrase( sentence )
    println( p.ngrams )
    // expected
    val n1 = NGram( Array[ String ]( LangConfig.SENTENCE_BEGIN, "one", LangConfig.SENTENCE_END ) )

    assertEquals( n1, p.ngrams( 0 ) )
    assertTrue( p.ngrams.contains( n1 ) )

  }

  @Test
  def edgeCaseEmptySentence = {
    val p : Phrase = Phrase( "" )
    println( p.ngrams )
//    assertTrue( p.ngrams.size == 0 )
  }
}

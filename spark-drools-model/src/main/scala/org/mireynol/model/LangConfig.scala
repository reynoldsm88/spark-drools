package org.mireynol.model

// TODO - make this so you can override it with system properties / properties file
object LangConfig {
  val NGRAM_SIZE : Short = 3
  final val SENTENCE_BEGIN : String = "[SENTENCE_BEGIN]"
  final var SENTENCE_END : String = "[SENTENCE_END]"
}
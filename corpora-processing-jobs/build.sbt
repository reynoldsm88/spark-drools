organization := "org.mireynol"
name := "named-entity-processor"
version := "0.0.1-SNAPSHOT"

//mainClass in assembly := Some( "org.mireynol.spark.named.entity.ConsolidateCorpus" )

assemblyMergeStrategy in assembly := {
  case PathList( "META-INF", "MANIFEST.MF" ) => MergeStrategy.discard
  case PathList( "reference.conf" ) => MergeStrategy.concat
  case x => MergeStrategy.first
}

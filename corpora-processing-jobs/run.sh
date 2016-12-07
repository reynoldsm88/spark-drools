#!/usr/bin/env bash
# use this to easily run the job on a local spark

SPARK_MASTER='spark://brian-PC:7077'
./bin/spark-submit \
  --class org.mireynol.jobs.corpora.processing.ConsolidateCorpus \
  --master $SPARK_MASTER \
  --deploy-mode cluster \
  --supervise \
  --executor-memory 4G \
  --total-executor-cores 4 \
   /Users/michael/norsepotions/spark-drools/corpora-processing-jobs/target/scala-2.11/named-entity-processor-assembly-0.0.1-SNAPSHOT.jar \
  1000
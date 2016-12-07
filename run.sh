#!/usr/bin/env bash
# use this to easily run the job on a local spark

SPARK_MASTER=''
./bin/spark-submit \
  --class org.mireynol.spark.drools.Main \
  --master $SPARK_MASTER \
  --deploy-mode cluster \
  --supervise \
  --executor-memory 4G \
  --total-executor-cores 4 \
  /Users/michael/norsepotions/spark-drools/spark-drools-job/target/scala-2.11/spark-drools-job-assembly-0.0.1-SNAPSHOT.jar \
  1000
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.deploy.pbs

import org.apache.spark.deploy.SparkApplication
import org.apache.spark.internal.Logging
import org.apache.spark.SparkConf

private[spark] class PbsClusterApplication extends SparkApplication with Logging {

  /**
   * Create and run a new spark application on a node in the cluster.
   *
   * @param args arguments from SparkSubmit
   * @param conf spark configuration
   */
  override def start(args: Array[String], conf: SparkConf): Unit = {
    logInfo("Starting new client with master URL: " + conf.get("spark.master"))
    new Client(new ClientArguments(args), conf).run()
  }
}

package com.taomee.topology;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import backtype.storm.utils.Utils;

import com.taomee.bolt.ReportBolt;
import com.taomee.bolt.SplitSentenceBolt;
import com.taomee.bolt.WordCountBolt;
import com.taomee.spolt.SentenceSpout;


/**
 * 
 * @author looper
 * @date 2016年5月20日
 */
public class WordCountTopology {
	
	private static final String SENTENCE_SPOUT_ID="sentence-spout";
	private static final String SPLIT_BOLT_ID="split-bolt";
	private static final String COUNT_BOLT_ID="count-bolt";
	private static final String REPORT_BOLT_ID="report-bolt";
	private static final String TOPOLOGY_NAME="word-count-topology";
	
      public static void main(String[] args) throws Exception {
		SentenceSpout spout=new SentenceSpout();
		SplitSentenceBolt splitBolt=new SplitSentenceBolt();
		WordCountBolt countBolt=new WordCountBolt();
		ReportBolt reportBolt=new ReportBolt();
		TopologyBuilder builder=new TopologyBuilder();
		
		//设置数据源Spout
		builder.setSpout(SENTENCE_SPOUT_ID, spout);
		//builder.setSpout(SENTENCE_SPOUT_ID, spout, 2);
		//设置bolt，同时通过调用shuffleGrouping方法，其会告诉storm将Spout发射的tuple元组信息均匀发给SplitSentenceBolt实例,同时设置2个executor线程4个task
		//builder.setBolt(SPLIT_BOLT_ID, splitBolt).shuffleGrouping(SENTENCE_SPOUT_ID);
		//builder.setBolt(SPLIT_BOLT_ID, splitBolt,2).setNumTask(4).shuffleGrouping(SENTENCE_SPOUT_ID);
		  //builder.setBolt(SPLIT_BOLT_ID, splitBolt,2).shuffleGrouping(SENTENCE_SPOUT_ID);
		  builder.setBolt(SPLIT_BOLT_ID, splitBolt).shuffleGrouping(SENTENCE_SPOUT_ID);
		//fieldsGrouping保证所有"word"字段值相同的tuple会被路由到同一个WordCountBolt当中。同时设置并发四个
		builder.setBolt(COUNT_BOLT_ID, countBolt).fieldsGrouping(SPLIT_BOLT_ID, new Fields("word"));
		//builder.setBolt(COUNT_BOLT_ID, countBolt,4).fieldsGrouping(SPLIT_BOLT_ID, new Fields("word"));
		//globalGrouping会保障WordCountBolt发送的所有tuple路由到唯一的ReportBolt任务中。
		builder.setBolt(REPORT_BOLT_ID, reportBolt).globalGrouping(COUNT_BOLT_ID);
		
		Config config=new Config();
		//利用Config给topology增加worker
		//config.setNumWorkers(2);
		//集群数据提交
		//StormSubmitter.submitTopology(TOPOLOGY_NAME, config, builder.createTopology());
		
		//单机测试如下所示
		/*LocalCluster cluster=new LocalCluster();
		cluster.submitTopology(TOPOLOGY_NAME, config, builder.createTopology());
		Utils.sleep(5000);
		cluster.killTopology(TOPOLOGY_NAME);
		cluster.shutdown();*/
		  if(args.length == 0)
		  {
			  LocalCluster cluster=new LocalCluster();
			  cluster.submitTopology(TOPOLOGY_NAME, config, builder.createTopology());
			//  builder.createTopology();
			  Utils.sleep(5000);
			  cluster.killTopology(TOPOLOGY_NAME);
			  cluster.shutdown();
		  }else
		  {
			  StormSubmitter.submitTopology(args[0],config,builder.createTopology());
		  }
		
	}

}

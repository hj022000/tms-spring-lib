package com.taomee.bolt;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;



/**
 * 实现语句分割bolt
 * @author looper
 * @date 2016年5月19日
 */
public class SplitSentenceBolt extends BaseRichBolt{
	private OutputCollector collector;
	private static final Logger LOG=LoggerFactory.getLogger(SplitSentenceBolt.class);
	/**
	 * 该方法在bolt组件被初始化时调用，这里准备一些bolt使用到的一些资源，比如数据库连接，类比spout当中的open方法
	 */

	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector=collector;
		LOG.info("SplitSentenceBolt 组件被初始化！");
		
	}

	/**
	 * 每当从订阅的数据流中接受一个tuple都会调用该方法，可以类比spout当中的nextTuple方法。
	 */

	public void execute(Tuple tuple) {
		// TODO Auto-generated method stub
		String sentence=tuple.getStringByField("sentence");
		String []words=sentence.split(" ");
		for(String word:words)
		{
			this.collector.emit(new Values(word));
			LOG.info("SplitSentenceBolt 发送的信息："+new Values(word).toString());
		}
		//this.collector.emit(tuple,new Values(word)); 实现tuple与下游的bolt锚定
	}

	/**
	 * 申明输出流，每个tuple字段包含一个字段"word"
	 */

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("word"));
		
	}

}

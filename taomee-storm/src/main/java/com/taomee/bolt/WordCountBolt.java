package com.taomee.bolt;

import java.util.HashMap;
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
 * 单词统计Bolt
 * 
 * @author looper
 * @date 2016年5月19日
 */
public class WordCountBolt extends BaseRichBolt {
	private OutputCollector collector;
	private HashMap<String, Long> counts = null;
	private static final Logger LOG=LoggerFactory.getLogger(WordCountBolt.class);

	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector = collector;
		this.counts = new HashMap<String, Long>();
		LOG.info("WordCountBolt 被初始化");
		

	}


	public void execute(Tuple tuple) {
		// TODO Auto-generated method stub
		String word = tuple.getStringByField("word");
		Long count = this.counts.get(word);
		if (count == null) {
			count = 0l;
		}
		count++;
		this.counts.put(word, count);
		this.collector.emit(new Values(word, count));
		LOG.info("WordCountBolt 发送的信息:"+new Values(word, count).toString());

	}


	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("word", "count"));
	}

}

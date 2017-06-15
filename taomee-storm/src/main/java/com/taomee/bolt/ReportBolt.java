package com.taomee.bolt;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class ReportBolt extends BaseRichBolt{
	
	private HashMap<String,Long> counts=null;
	private static final Logger LOG=LoggerFactory.getLogger(ReportBolt.class);


	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		// TODO Auto-generated method stub
	  this.counts=new HashMap<String, Long>();	
	  LOG.info("ReportBolt 组件被初始化");
	}


	public void execute(Tuple tuple) {
		// TODO Auto-generated method stub
		String word=tuple.getStringByField("word");
		Long count=tuple.getLongByField("count");
		this.counts.put(word, count);
		Long time=System.currentTimeMillis();
		//LOG.info("ReportBolt 统计的信息,word:"+word+",count:"+count);
		for(Entry<String, Long> entry:counts.entrySet())
		{
			LOG.info("ReportBolt 统计的信息,word:"+entry.getKey()+",count:"+entry.getValue()+",time:"+time);
		}
	}


	public void cleanup() {
		// TODO Auto-generated method stub
		//super.cleanup();
		System.out.println("----final Counts-----");
		List<String> keys=new ArrayList<String>();
		keys.addAll(this.counts.keySet());
		Collections.sort(keys);
		for(String key:keys)
		{
			System.out.println(key+":"+this.counts.get(key));
		}
		System.out.println("------------------------");
	}


	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

}

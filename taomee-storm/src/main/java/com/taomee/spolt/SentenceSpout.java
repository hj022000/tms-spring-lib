package com.taomee.spolt;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;


/**
 * 
 * @author looper
 * @date 2016年5月19日
 */
public class SentenceSpout extends BaseRichSpout {
	
	private SpoutOutputCollector collector;
	private String[] sentences={"storm bolt spout hadoop","jdk hadoop flume spout bolt","hive storm spark kafka hadoop"};
    private int index=0;
    private static final Logger LOG=LoggerFactory.getLogger(SentenceSpout.class);
    /**
     * 发射tuple。
     */

	public void nextTuple() {
		// TODO Auto-generated method stub
		//this.collector.e
		
		this.collector.emit(new Values(sentences[index]));
		LOG.info("发送的信息："+new Values(sentences[index]).toString());
		index++;
		if(index>=sentences.length)
		{
			index=0;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 暂时设置数组当中的数据只发送一次
		 */
		/*if(index < sentences.length)
		{
			this.collector.emit(new Values(sentences[index]));
			index++;
		}
		try {
			Thread.sleep(1l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * 该方法为当所有Spout组件被初始化的时候被调用
	 */

	public void open(Map config, TopologyContext context, SpoutOutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector=collector;
		LOG.info("Spout组件初始化");
	}

	/**
	 * 该方法是是在IComponent接口中定义的，storm通过该方法告诉storm该组件会发射哪些数据，每个数据流的tuple中包含哪些字段
	 */

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("sentence"));
		
	}

}

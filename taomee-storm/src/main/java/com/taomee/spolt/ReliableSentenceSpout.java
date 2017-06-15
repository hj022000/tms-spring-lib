package com.taomee.spolt;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

/**
 * 可靠的单词统计
 * @author looper
 * @date 2016年6月6日
 */
public class ReliableSentenceSpout extends BaseRichSpout{
	private ConcurrentHashMap<UUID, Values> pending;
	private SpoutOutputCollector collector;
	private String[] sentences={"my dog has fleas","i like cold beverages","the dog ate my homework"};
    private int index=0;


	public void open(Map conf, TopologyContext context,
			SpoutOutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector=collector;
		this.pending=new ConcurrentHashMap<UUID, Values>();
		
	}


	public void nextTuple() {
		// TODO Auto-generated method stub
		Values values=new Values(sentences[index]);
		UUID msgId=UUID.randomUUID();
		this.pending.put(msgId, values);
		//tuple锚定
		this.collector.emit(values, msgId);
		index++;
		if(index>=sentences.length)
		{
			index=0;
		}
		Utils.sleep(1000);
	}


	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("sentence"));
	}

	/**
	 * 当该条信息发送完成后，其会发送ack确定，此时其在其数组当中移除掉已经发送成功的记录
	 */
	@Override
	public void ack(Object msgId) {
		// TODO Auto-generated method stub
		//super.ack(msgId);
		this.pending.remove(msgId);
	}

	/**
	 * 对于发送失败的记录，storm会调用fail方法，然后重新发送该条消息。
	 */
	@Override
	public void fail(Object msgId) {
		// TODO Auto-generated method stub
		//super.fail(msgId);
		this.collector.emit(this.pending.get(msgId), msgId);
	}

}

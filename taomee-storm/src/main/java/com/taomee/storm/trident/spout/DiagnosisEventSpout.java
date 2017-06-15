package com.taomee.storm.trident.spout;

import java.util.Map;

import com.taomee.storm.trident.model.DefaultCoordinator;
import com.taomee.storm.trident.model.DiagnosisEventEmitter;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import storm.trident.spout.ITridentSpout;

/**
 *
 */
public class DiagnosisEventSpout implements ITridentSpout<Long> {

	private static final long serialVersionUID = 1L;
	SpoutOutputCollector collector;
	BatchCoordinator<Long> coordinator = new DefaultCoordinator();
	Emitter<Long> emitter=new DiagnosisEventEmitter();


	public Map getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * BatchCoordinator 负责管理批次和元数据
	 * @param arg0
	 * @param arg1
	 * @param arg2
     * @return
     */
	public BatchCoordinator<Long> getCoordinator(String arg0, Map arg1,
			TopologyContext arg2) {
		// TODO Auto-generated method stub
		//arg2.
		return coordinator;
	}


	public Emitter<Long> getEmitter(String arg0, Map arg1, TopologyContext arg2) {
		// TODO Auto-generated method stub
		return emitter;
	}


	public Fields getOutputFields() {
		// TODO Auto-generated method stub
		return new Fields("event");
	}

}

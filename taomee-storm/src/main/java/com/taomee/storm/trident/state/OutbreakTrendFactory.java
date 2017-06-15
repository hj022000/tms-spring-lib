package com.taomee.storm.trident.state;

import java.util.Map;

import backtype.storm.task.IMetricsContext;
import storm.trident.state.State;
import storm.trident.state.StateFactory;

public class OutbreakTrendFactory implements StateFactory{

	private static final long serialVersionUID = 1L;


	public State makeState(Map conf, IMetricsContext metrics,
			int partitionIndex, int numPartitions) {
		// TODO Auto-generated method stub
		return new OutbreakTrendState(new OutbreakTrendBackingMap());
	}

}

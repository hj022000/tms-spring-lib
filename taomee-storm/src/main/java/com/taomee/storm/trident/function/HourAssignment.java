package com.taomee.storm.trident.function;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taomee.storm.trident.bean.DiagnosisEvent;

import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public class HourAssignment extends BaseFunction{

	private static final long serialVersionUID = 1L;

	private static final Logger LOG=LoggerFactory.getLogger(HourAssignment.class);

	public void execute(TridentTuple tuple, TridentCollector collector) {
		// TODO Auto-generated method stub
		DiagnosisEvent diagnosisEvent=(DiagnosisEvent) tuple.getValue(0);
		String city=(String) tuple.getValue(1);
		long timestamp=diagnosisEvent.getTime();
		long hourSinceEpoch=timestamp/1000/60/60;
		LOG.debug("key="+city+":"+hourSinceEpoch);
		String key=city+":"+diagnosisEvent.getDiagnosisCode()+":"+hourSinceEpoch;
		List<Object> values=new ArrayList<Object>();
		values.add(hourSinceEpoch);
		values.add(key);
		collector.emit(values);
		
	}

}

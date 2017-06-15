package com.taomee.storm.trident.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taomee.storm.trident.bean.DiagnosisEvent;

import storm.trident.operation.TridentCollector;
import storm.trident.spout.ITridentSpout.Emitter;
import storm.trident.topology.TransactionAttempt;

public class DiagnosisEventEmitter implements Emitter<Long>,Serializable{

	private static final long serialVersionUID = 1L;
	AtomicInteger successfulTransactions = new AtomicInteger(0);
	private static final Logger LOG = LoggerFactory.getLogger(DiagnosisEventEmitter.class);


	public void close() {
		// TODO Auto-generated method stub
		
	}


	public void emitBatch(TransactionAttempt tx, Long coordinatorMeta,
			TridentCollector collector) {
		// TODO Auto-generated method stub
		for(int i=0;i<10000;i++)
		{
			List<Object> events=new ArrayList<Object>();
			double lat=new Double(-30+(int)(Math.random()*75));
			double lng=new Double(-120+(int)(Math.random()*70));
			long time=System.currentTimeMillis();
			String diag=new Integer(320+(int)(Math.random()*7)).toString();
			DiagnosisEvent event=new DiagnosisEvent(lat, lng, time, diag);
			events.add(event);
			collector.emit(events);
		}
	}


	public void success(TransactionAttempt tx) {
		// TODO Auto-generated method stub
		successfulTransactions.incrementAndGet();
		
	}

}

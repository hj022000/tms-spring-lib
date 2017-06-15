package com.taomee.storm.trident.function;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taomee.storm.trident.utils.DateFormat;

import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;
public class OutbreakDetector extends BaseFunction{
	private static final long serialVersionUID = 1L;
	public static final int THRESHOLD=1000;


	public void execute(TridentTuple tuple, TridentCollector collector) {
		// TODO Auto-generated method stub
		String key=(String) tuple.getValue(0);
		Long count=(Long) tuple.getValue(1);
		if(count>THRESHOLD)
		{
			List<Object> values=new ArrayList<Object>();
			String tmp[]=key.split(":");
			Long time=Long.parseLong(tmp[2]);
			time=time*60*60*1000;
			String date=DateFormat.formatDate(time);//
			values.add("Outbreak detected for ["+tmp[0]+":"+tmp[1]+":"+date+"]!");
			collector.emit(values);
		}
	}

}

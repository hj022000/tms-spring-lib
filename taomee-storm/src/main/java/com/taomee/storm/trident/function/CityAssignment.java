package com.taomee.storm.trident.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taomee.storm.trident.bean.DiagnosisEvent;

import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

public class CityAssignment extends BaseFunction {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory
			.getLogger(CityAssignment.class);

	private static Map<String, double[]> CITIES = new HashMap<String, double[]>();

	{
		double[] phl = { 39.875365, -75.249524 };
		CITIES.put("PHL", phl);
		double[] nyc = { 40.71448, -74.00598 };
		CITIES.put("NYC", nyc);
		double[] sf = { -31.4250142, -62.0841809 };
		CITIES.put("SF", sf);
		double[] la = { -34.05374, -118.24307 };
		CITIES.put("LA", la);
	}


	public void execute(TridentTuple tuple, TridentCollector collector) {
		// TODO Auto-generated method stub
		DiagnosisEvent diagnosisEvent = (DiagnosisEvent) tuple.getValue(0);
		double leastDistance = Double.MAX_VALUE;
		String closestCity = "NONE";
		for (Entry<String, double[]> city : CITIES.entrySet()) {
			double R = 6371;
			double x = (city.getValue()[0] - diagnosisEvent.getLng())
					* Math.cos((city.getValue()[0] + diagnosisEvent.getLng()) / 2);
			double y = (city.getValue()[1] - diagnosisEvent.getLat());
			double d = Math.sqrt(x * x + y * y) * R;
			if (d < leastDistance) {
				leastDistance = d;
				closestCity = city.getKey();
			}		
		}
		List<Object> values = new ArrayList<Object>();
		values.add(closestCity);
		LOG.debug("closest city to lat=[" + diagnosisEvent.getLat()
				+ "],lng=[" + diagnosisEvent.getLng() + "] == ["
				+ closestCity + "],d=[" + leastDistance + "]");
		collector.emit(values);

	}

}

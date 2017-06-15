package com.taomee.storm.trident.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import storm.trident.state.map.IBackingMap;


public class OutbreakTrendBackingMap implements IBackingMap<Long> {
	private static final Logger LOG = LoggerFactory
			.getLogger(OutbreakTrendBackingMap.class);

	Map<String, Long> storage = new ConcurrentHashMap<String, Long>();


	public List<Long> multiGet(List<List<Object>> keys) {
		// TODO Auto-generated method stub
		LOG.info("keys message" + keys.toString() + "");
		List<Long> values = new ArrayList<Long>();
		for (List<Object> key : keys) {
			LOG.info("key message" + key.toString() + "");
			Long value = storage.get(key.get(0));
			if (value == null) {
				values.add(new Long(0));
			} else {
				LOG.info("value" + value);
				values.add(value);

			}
		}
		return values;
	}


	public void multiPut(List<List<Object>> keys, List<Long> vals) {
		// TODO Auto-generated method stub
		for (int i = 0; i < keys.size(); i++) {
			LOG.info("persisting [" + keys.get(i).get(0) + "] ===> ["
					+ vals.get(i) + "]");
			storage.put((String) keys.get(i).get(0), vals.get(i));
		}
	}

}

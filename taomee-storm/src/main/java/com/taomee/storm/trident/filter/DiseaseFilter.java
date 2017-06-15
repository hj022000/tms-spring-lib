package com.taomee.storm.trident.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taomee.storm.trident.bean.DiagnosisEvent;

import storm.trident.operation.BaseFilter;
import storm.trident.tuple.TridentTuple;

/**
 * 过滤器的作用是过滤掉不需要往下游传播的消息
 */
public class DiseaseFilter extends BaseFilter {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory
			.getLogger(DiseaseFilter.class);

	/**
	 * 返回true的数据会被发送到下游进行操作，如果方法返回值为false，不会返回到下游
	 * @param tuple
	 * @return
     */
	public boolean isKeep(TridentTuple tuple) {
		// TODO Auto-generated method stub
		DiagnosisEvent diagnosisEvent = (DiagnosisEvent) tuple.getValue(0);
		//tuple.get
		Integer code = Integer.parseInt(diagnosisEvent.getDiagnosisCode());
		if (code.intValue() <= 322) {
			LOG.debug("Emitting disease[" + diagnosisEvent.getDiagnosisCode()
					+ "]");
			return true;
		} else {
			LOG.debug("Filtering disease[" + diagnosisEvent.getDiagnosisCode()
					+ "]");
			return false;
		}
	}

}

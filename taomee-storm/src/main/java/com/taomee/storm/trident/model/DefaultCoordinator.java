package com.taomee.storm.trident.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import storm.trident.spout.ITridentSpout.BatchCoordinator;

public class DefaultCoordinator implements BatchCoordinator<Long>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory
			.getLogger(DefaultCoordinator.class);


	public void close() {
		// TODO Auto-generated method stub

	}


	public Long initializeTransaction(long txid, Long prevMetadata, Long arg2) {
		// TODO Auto-generated method stub
		LOG.info("Initializing Transaction [" + txid + "]");
		return null;
	}


	public boolean isReady(long arg0) {
		// TODO Auto-generated method stub
		return true;
	}


	public void success(long txid) {
		// TODO Auto-generated method stub
		LOG.info("Successful Transaction [" + txid + "]");
	}

}

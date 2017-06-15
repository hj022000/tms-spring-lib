package com.taomee.storm.trident.state;


import storm.trident.state.map.NonTransactionalMap;

public class OutbreakTrendState extends NonTransactionalMap<Long>{

	protected OutbreakTrendState(OutbreakTrendBackingMap backing) {
		super(backing);
		// TODO Auto-generated constructor stub
	}

}

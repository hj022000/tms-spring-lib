package com.taomee.storm.trident.test;

public class TestDate {

	public void testDateHour()
	{
		Long time=System.currentTimeMillis();
		System.out.println(time);
		System.out.println(time/1000/60/60);
	}
	

}

package com.taomee.storm.trident.utils;
import java.text.SimpleDateFormat;
public class DateFormat {

	public static String formatDate(Long time)
	{
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=format.format(time);
		return date;
	}
}

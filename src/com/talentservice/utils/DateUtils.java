package com.talentservice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static String formatDateTime(Date d){
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 if (d == null){
			 return "";
	     }
	     return datetimeFormat.format(d);
	}
	
	public static String formatDate(Date d){
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy/MM/dd");
		if (d == null){
			return "";
		}
		return datetimeFormat.format(d);
	}
	
	/**
	 * 返回时间字符串加上当前时间之后的时间戳   减去当前系统时间时间戳的值
	 * @param time
	 * @param day
	 * @return
	 * @throws ParseException 
	 */
	public static long getTimestamp(String time, String day) throws ParseException{
		Calendar cal = Calendar.getInstance() ;
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    Date date = simpleDateFormat.parse(time);
	    cal.setTime(date) ;
	    cal.add(Calendar.DATE, Integer.parseInt(day)) ;
	    date = cal.getTime() ;
	    long timestamp = date.getTime() ;
	    long currenttime = new Date().getTime() ;
	    
	    return timestamp - currenttime ;
	}
}

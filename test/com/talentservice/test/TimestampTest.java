package com.talentservice.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TimestampTest extends BaseSpring {
	@Test
	public void testTimestamp() throws ParseException{
		String time = "2015/05/06" ;
		String amount = "3" ;
		/*SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy/MM/dd");
	    Date date=simpleDateFormat .parse(time);
	    long timeStemp = date.getTime();
	    System.out.println(timeStemp);*/
	     
	    Calendar cal = Calendar.getInstance() ;
	    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy/MM/dd");
	    Date date=simpleDateFormat.parse(time);
	    cal.setTime(date) ;
	    cal.add(Calendar.DATE, Integer.parseInt(amount)) ;
	    date = cal.getTime() ;
	    long timestamp = date.getTime() ;
	    System.out.println(timestamp);
	    
	    /*String time2 = "2015/05/09" ;
	    Date d = simpleDateFormat.parse(time2) ;
	    System.out.println(d.getTime());
	    */
	    long currenttime = new Date().getTime() ;
		System.out.println(currenttime);
		
		System.out.println(timestamp-currenttime);
	}
	
}

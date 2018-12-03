package com.zy.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {
	

	public static void main(String[] args) throws Exception {
		String time = dateMinusYears("2018-5-8", Calendar.DATE, -1);
		System.out.println(time);
	}
	
	/**
	 * 日期减几年,几月,几日
	 * @param str
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public static String dateMinusYears(String str,int field,int index) throws Exception {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = sdf.parse(str);
		 Calendar rightNow = Calendar.getInstance();
		 rightNow.setTime(date);
		 rightNow.add(field, index);
		 Date date1 = rightNow.getTime();
		 String dateStr = sdf.format(date1);
		 return dateStr;
	 }
}

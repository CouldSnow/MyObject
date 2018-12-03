package com.zy.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static  void main(String[] args) {
		/*Long stamp = getTime();
		System.out.println(stamp);*/
		Date date = new Date(Long.parseLong("587314800000"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
	}
	/**
	 * 获取当日时间
	 * @return
	 */
	public static String getTodayTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr = sdf.format(date);
		return datestr;
	}
	/**
	 * 获取当日日期
	 * @return
	 */
	public static String getTody() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = sdf.format(date);
		return datestr;
	}
	/**
	 * 获取当前时间的时间戳
	 * @return
	 */
	public static Long getTime() {
		Date date = new Date();
		Long stamp = date.getTime();
		return stamp;
	}
	
	/**
	 * 日期转时间戳
	 * @param dateStr
	 * @return
	 */
	public static String dateToStamp(String dateStr)  {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Long stamp = date.getTime();
		return stamp.toString();
	}
	/**
	 * 时间戳转日期
	 * @param stamp
	 * @return
	 */
	public static String stampToDate(String stamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long stamp1 = Long.parseLong(stamp);
		Date date = new Date(stamp1);
		String dateStr = sdf.format(date);
		return dateStr;
	}
	/**
	 * 中文，年月日，星期几
	 * @return
	 */
	public static String zh_Date() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  EEEE");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日  EEEE");
		String dateStr = sdf1.format(date);
		System.out.println(dateStr);
		return dateStr;
	}
}

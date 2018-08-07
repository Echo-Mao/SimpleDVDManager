package com.myj.dvdmanage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DVDDate {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//将String类型的时间转换为Date类型
	public static String dateToString(Date date){
		
		String dateStr = null;
		dateStr = sdf.format(date);
		return dateStr;
		
	}
	
	//将Date类型的时间转换为String类型
	public static Date stringToDate(String date){
		
		Date strDate = null;
		try {
			strDate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strDate;
		
	}
	
	//计算借出时间与归还时间间隔的天数
	public static int timeInterval(Date date1, Date date2){
		
		int day;
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long interval = Math.abs(time2-time1);
		day = (int)(interval/(1000*3600*24));
		return day;
		
	}
//	public static void main(String[] args) {
//		String str = DVDDate.dateToString(new Date());
//		System.out.println(str);
//		System.out.println(DVDDate.stringToDate(str));
//	}

}

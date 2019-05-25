package com.HLXY.util;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String format(Date date, String format)  {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String str = sdf.format(date);
			return str;
		} catch (Exception e) {
			throw new ServerException("日期转换错误");
		}

	}
	public static String format(Date date, String format,String mes)  {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String str = sdf.format(date);
			return str;
		} catch (Exception e) {
			throw new ServerException(mes+"日期转换错误");
		}

	}

	public static Date parse(String strDate, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (Exception e) {
			throw new ServerException("字符转换错误");
		}
	}
	public static Date parse(String strDate, String format,String mes) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (Exception e) {
			throw new ServerException(mes+"字符转换错误");
		}
	}
}

package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
	public static Date StringToDate(String src,String pattern) throws ParseException {
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern);
		return simpleDateFormat.parse(src);
	}
	
	public static void main(String[] args) throws ParseException {
		String src="24/03/2003";
		String pattern= "dd/MM/yyyy";
		Date d=StringToDate(src, pattern);
		DateFormat df= new SimpleDateFormat(pattern);
		System.out.println(df.format(d));
	}
}

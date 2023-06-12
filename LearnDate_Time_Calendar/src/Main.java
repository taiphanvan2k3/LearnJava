import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
public class Main {
	public static void test_class_Date() {
		Date d= new Date(System.currentTimeMillis());
		System.out.println(d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900));
	}
	public static void  test_class_TimeUnit() {
		System.out.println(TimeUnit.SECONDS.toHours(3600));
		System.out.println(TimeUnit.DAYS.toSeconds(1));
	}
	public static void test_class_Calendar() {
		Calendar c=Calendar.getInstance();
		System.out.println(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));
		c.add(Calendar.DATE, 8);
		System.out.println(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));
	}
	public static void test_class_DateFormat() {
		Date d= new Date(System.currentTimeMillis());
		DateFormat df=new SimpleDateFormat("hh:mm a\ndd/MM/yyyy");
		System.out.println(df.format(d));
	}
	public static void main(String[] args) {
		test_class_Date();
		test_class_Calendar();
		test_class_DateFormat();
	} 
}

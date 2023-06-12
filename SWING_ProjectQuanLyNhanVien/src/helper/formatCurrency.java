package helper;

import java.text.NumberFormat;
import java.util.Locale;

public class formatCurrency {
	private static NumberFormat numberFormat;
	public formatCurrency() {
		Locale lc= new Locale("vi","vn");
		numberFormat= NumberFormat.getInstance(lc);
	}
	
	public static String format(Object x) {
		Locale lc= new Locale("vi","vn");
		numberFormat= NumberFormat.getInstance(lc);
		return numberFormat.format(x);
	}
}

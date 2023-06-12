import java.util.Objects;

public class MyDate {
	private int day, month, year;

	public MyDate(int day, int month, int year) {
		if (day >= 1 && day <= 31)
			this.day = day;
		else
			this.day = 1;
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			this.month = 1;
		this.year = year;
	}

	void setDay(int day) {
		if(day>=1 && day<=31)
			this.day = day;
	}

	void setMonth(int month) {
		if(month>=1 && month<=12)
			this.month = month;
	}

	void setYear(int year) {
		this.year = year;
	}

	int getDay() {
		return this.day;
	}

	int getMonth() {
		return this.month;
	}

	int getYear() {
		return this.year;
	}

	void display() {
		String date="";
		if(day>=1 && day<=9)
			date+="0"+day+"";
		else date+=day+"";
		date+="-";
		if(month>=1 && month<=9)
			date+="0"+month+"";
		else date+=month+"";
		date+="-"+year+"";
		System.out.println(date);
	}
	
	//Xây dựng phương thức toString()
	public String toString() {
		String date="";
		if(day>=1 && day<=9)
			date+="0"+day+"";
		else date+=day+"";
		date+="-";
		if(month>=1 && month<=9)
			date+="0"+month+"";
		else date+=month+"";
		date+="-"+year+"";
		return date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month,year);
	}

	
	//Xây dựng phương thức equals
//	@Override
//	public boolean equals(Object a) {
//		if(this==a)
//			return true;
//		MyDate other=(MyDate)a;
//		System.out.println(other);
//		if(day!=other.day || month!=other.month || year!=other.year)
//			return false;
//		return true;
//	}
}
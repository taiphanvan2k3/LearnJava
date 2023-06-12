
public class NgaySinh {
	private static final Object NULL = null;
	private int day,month,year;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public NgaySinh(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==NULL || this.getClass() != obj.getClass())
			return false;
		NgaySinh x=(NgaySinh)obj;
		return this.day==x.day && this.month==x.month && this.year==x.year;
	}
}

import java.util.Scanner;
public class Date {
	private int day,month,year;
	public Date() {}
	public Date(int day,int month,int year) {
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public void nhap_tt() {
		Scanner sc=new Scanner (System.in);
		System.out.print("Day:");
		day=sc.nextInt();
		System.out.print("Month:");
		month=sc.nextInt();
		System.out.print("Year:");
		year=sc.nextInt();
	}
	public String toString() {
		return day+"/"+month+"/"+year;
	}
}

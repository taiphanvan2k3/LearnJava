package Vidu;

public class ThoiKhoaBieu {
	private DayOfWeek dow;
	private String monHoc;
	public ThoiKhoaBieu(DayOfWeek dow, String monHoc) {
		this.dow = dow;
		this.monHoc = monHoc;
	}
	public DayOfWeek getDow() {
		return dow;
	}
	public void setDow(DayOfWeek dow) {
		this.dow = dow;
	}
	public String getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	public String toString() {
		return dow+" "+this.monHoc;
	}
}

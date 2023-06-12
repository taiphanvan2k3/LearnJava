
public class person {
	private String name;
	int dob;
	protected int num;
	public person(String name, int dob) {
		this.name = name;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public void An() {
		System.out.println("Đang ăn");
	}
	public void Uong() {
		System.out.println("Dang uong");
	}
	public void display() {
		System.out.println(name+","+dob);
	}
	
}

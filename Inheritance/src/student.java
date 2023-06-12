
public class student extends person {
	private String tenTruong;
	private double gpa;
	public student(String name,int dob,String tenTruong,double gpa){
		super(name,dob);
		this.tenTruong=tenTruong;
		this.gpa=gpa;
	}
	public void display() {
		System.out.println(super.getName()+","+super.getDob()+","+this.tenTruong+","+this.gpa);
	}
}

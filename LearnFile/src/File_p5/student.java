package File_p5;

public class student {
	private String name,lop;

	public student(String name, String lop) {
		this.name = name;
		this.lop = lop;
	}

	@Override
	public String toString() {
		return "student [name=" + name + ", lop=" + lop + "]";
	}
	
}

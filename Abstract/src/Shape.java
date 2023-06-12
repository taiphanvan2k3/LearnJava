
public abstract class Shape {
	private ToaDo p;
	//Constructor này không được dùng để
	//khởi tạo ra đối tượng vì class này là
	//abstract class
	public Shape(ToaDo p) {
		this.p=p;
	}
	public abstract double getArea();
	
	public void test() {
		System.out.println("đây là test");
	}
}

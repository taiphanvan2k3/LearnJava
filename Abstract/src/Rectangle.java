
public class Rectangle extends Shape {
	private int width, height;

	public Rectangle(ToaDo p, int width, int height) {
		super(p);
		this.width = width;
		this.height = height;
		this.test();
		//Hoặc:
		super.test();
	}

	@Override
	public double getArea() {
		return width * height;
	}

	public void display() {
		System.out.println("test");
	}
}

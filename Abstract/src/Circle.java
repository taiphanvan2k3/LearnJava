
public class Circle extends Shape{
	private double radius;
	public Circle(ToaDo p,double radius) {
		super(p);
		this.radius=radius;
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
}

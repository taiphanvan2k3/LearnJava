package DUT_06;

public class MyVector {
	double x, y;

	public MyVector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public MyVector add(MyVector v) {
		return new MyVector(x + v.x, y + v.y);
	}

	public MyVector sub(MyVector v) {
		return new MyVector(x - v.x, y - v.y);
	}

	public MyVector multi(double l) {
		return new MyVector(x * l, y * l);
	}

	public double len() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}

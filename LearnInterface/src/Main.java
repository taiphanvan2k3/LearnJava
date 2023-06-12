
public class Main {
	public static void main(String[] args) {
		double[] a1 = { 6, 7, 1, 5, 9, 2, -2, 7 };
		double[] a2 = { 1, 4, 2, 0, -5, 4, 7, 8 };
		SapXepChen sx1 = new SapXepChen();
		SapXepChon sx2 = new SapXepChon();
		// sx1.sapXepGiam(a1);
		// sx2.sapXepTang(a2);
		PhanMemMayTinh pmmt = new PhanMemMayTinh();
		pmmt.sapXepGiam(a1);
		for (double i : a1)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("3*5=" + pmmt.Multiply(3, 5));
	}
}

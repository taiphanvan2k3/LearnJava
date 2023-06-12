
public class MayTinhCasio implements MayTinhBoTuiInterface {

	@Override
	public double Add(double a, double b) {
		return a + b;
	}

	@Override
	public double Subtract(double a, double b) {
		return a - b;
	}

	@Override
	public double Multiply(double a, double b) {
		return a * b;
	}

	@Override
	public double Divide(double a, double b) {
		if(b==0)
			return Double.MAX_VALUE;
		return a/b;
	}

}

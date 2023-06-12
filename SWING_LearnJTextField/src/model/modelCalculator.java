package model;

public class modelCalculator {
	private double firstValue, secondValue, answer;

	
	public modelCalculator() {}

	public double getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(double firstValue) {
		this.firstValue = firstValue;
	}

	public double getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(double secondValue) {
		this.secondValue = secondValue;
	}

	public void add() {
		this.answer = this.firstValue + this.secondValue;
	}

	public double getAnswer() {
		return answer;
	}

	public void minus() {
		this.answer = this.firstValue - this.secondValue;
	}

	public void multiply() {
		this.answer = this.firstValue * this.secondValue;
	}

	public void divide() {
		if (this.secondValue == 0)
			System.out.println("Lỗi phép tính");
		this.answer = this.firstValue / this.secondValue;
	}

	public void power() {
		this.answer = Math.pow(firstValue, secondValue);
	}

	public void mod() {
		this.answer = (int) this.firstValue % (int) this.secondValue;
	}
}

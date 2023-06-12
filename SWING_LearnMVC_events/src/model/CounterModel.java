package model;

public class CounterModel {
	private int value;

	public CounterModel() {
		this.value = 0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void upValue() {
		this.value++;
	}

	public void downValue() {
		this.value--;
	}
	
	public void resetValue() {
		this.value=0;
	}
}

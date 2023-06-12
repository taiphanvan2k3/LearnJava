package main;

public class player {
	private double money;

	public player() {
		this.money = 5000000;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public void updateMoney(double x) {
		this.money+=x;
	}
}

package model;

public class mouse {
	private int x, y, count;
	private String checkPos;

	public mouse() {
		this.count = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCheckPos() {
		return checkPos;
	}

	public void setCheckPos(String checkPos) {
		this.checkPos = checkPos;
	}

	public void click() {
		this.count++;
	}

	public void enter() {
		this.checkPos = "Yes";
	}

	public void exit() {
		this.checkPos = "No";
	}
}

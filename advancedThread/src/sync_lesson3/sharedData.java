package sync_lesson3;

public class sharedData {
	private int x, sum;

	// Đối với bài toán có nhiều hơn 2 luồng thì
	// để dễ dàng thiết lập thứ tự chạy của từng luồng theo ý
	// mình thì dùng index để biết được thread nào đang được chạy
	private int index;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public sharedData() {
		this.sum = 0;
		this.index = 1;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean isContinueRand() {
		return sum < 1000;
	}

	public void addSum(int x) {
		this.sum += x;
	}
}

package DUT_03;

public class HoTen implements Comparable<HoTen> {
	// Phải implements Comparable thì mới có thể so sánh được.
	private String hoten;

	public HoTen() {
	}

	public HoTen(String hoten) {
		this.hoten = hoten;
	}

	private String getLastName() {
		return hoten.substring(hoten.lastIndexOf(' ') + 1);
	}

	private String getFirstName() {
		return hoten.substring(0, hoten.indexOf(' '));
	}

	@Override
	public int compareTo(HoTen o) {
		String name1 = this.getLastName();
		String name2 = o.getLastName();
		if (name1.equals(name2))
			return this.getFirstName().compareTo(o.getFirstName());
		return name1.compareTo(name2);
	}

	@Override
	public String toString() {
		return hoten;
	}
}

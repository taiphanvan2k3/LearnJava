
public class Test {
	public static void main(String[] args) {
		String ds[]= {"1","a","2"};
		try {
			int x=Integer.valueOf(ds[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

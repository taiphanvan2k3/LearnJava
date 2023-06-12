package DUT_09;

public class JDBC_MySQL {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver ok");
		} catch (Exception e) {
		}
	}
}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextInt()) {
			int x=sc.nextInt();
			System.out.println(x);
		}
	}
}

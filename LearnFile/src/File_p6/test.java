package File_p6;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class test {
	public static void main(String[] args) {
		File f=new File("test.txt");
		try {
			BufferedReader br=Files.newBufferedReader(f.toPath());
			while(true) {
				String s=br.readLine();
				if(s==null)
					break;
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

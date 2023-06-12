package File_p0;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		File f = new File("vd.txt");
		try {
			List<String> lines = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
			for(String line:lines)
				System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

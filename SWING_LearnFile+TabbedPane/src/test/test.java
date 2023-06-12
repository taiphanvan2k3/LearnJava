package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.UIManager;

import view.MyNotePadView;

public class test {
	public void Test() throws IOException {
		File f = new File("E:\\BtJava\\phienam.txt");
		List<String>ds=Files.readAllLines(f.toPath());
		for(String str:ds)
			System.out.println(str);
	}
	public static void main(String[] args) throws IOException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MyNotePadView();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

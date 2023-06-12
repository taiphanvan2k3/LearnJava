package File_p3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

//Học cách xoá file
public class DeleteFile {
	public static void xoaFile(File f) {
		if(f.isDirectory()) {
				File ds[]=f.listFiles();
				for(File i:ds)
					xoaFile(i);
			}
		System.out.println(f.getAbsolutePath());
		f.delete();
	}
	
	public static void main(String[] args) {
		File f= new File("E:\\BtJava\\LearnFile\\F1");
		xoaFile(f);
	}
}

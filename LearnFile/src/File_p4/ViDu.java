package File_p4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ViDu {
	public static void copyAll(File f1,File f2) {
		//Nếu là file thì ko bàn, nhưng nếu là folder thì ta phải copy 
		//ra cái vỏ của nó trước rồi mới đi copy các tập con của nó
		try {
			Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(f1.isDirectory()) {
			File ds[]=f1.listFiles();
			for(File file:ds) {
				File file_new= new File(f2.getAbsoluteFile()+"\\"+file.getName());
				copyAll(file,file_new);
			}
		}
	}
	public static void main(String[] args) {
		// Đổi tên file hoặc folder bằng class File
//		File folder_1= new File("E:\\BtJava\\LearnFile\\F1"); 
//		File folder_1_new =new File("E:\\BtJava\\LearnFile\\F1_new"); 
//		folder_1.renameTo(folder_1_new);
		
		
		//Di chuyển file hoặc thư mục
//		File folder = new File("E:\\BtJava\\LearnFile\\F1_new");
//		File folder_new = new File("E:\\BtJava\\LearnFile\\Backup\\F1_new");
//		File f1 = new File("E:\\BtJava\\LearnFile\\hihi.txt");
//		File f1_moved = new File("E:\\BtJava\\LearnFile\\Backup\\haha.txt");
//		try {
//			//Files.move(folder.toPath(), folder_new.toPath(), StandardCopyOption.REPLACE_EXISTING);
//			Files.move(f1.toPath(), f1_moved.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Copy all nếu 1 thư mục chứa các thư mục,tập tin con khác
		File folder_copy= new File("E:\\BtJava\\LearnFile\\test\\Backup");
		File folder =new File("E:\\BtJava\\LearnFile\\Backup");
		copyAll(folder, folder_copy);
		
	}
}

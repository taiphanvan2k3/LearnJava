import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {
	public static File newFile(File destinationDir,ZipEntry zipEntry) throws IOException {
		//Tạo 1 File có tên zipEntry.getName() từ đường dẫn cha của nó
		File destFile= new File(destinationDir, zipEntry.getName());
		
		String destDirPath= destinationDir.getCanonicalPath();
		String destFilePath=destFile.getCanonicalPath();
		//File.separator: trả về tuỳ vào OS m, vd MacOS là /, Windows là \
		
		//destDirPath dẫn đến destFile do đó nếu destFilePath mà ko bắt đầu
		//là destDirPath\ thì quăng ngoại lệ
		if(!destFilePath.startsWith(destDirPath+File.separator)) {
			 throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
		}
		return destFile;
	}
	public static void main(String[] args) throws IOException {
		//Inpput là 1 file zip
		FileInputStream fis= new FileInputStream("Backup.zip");
		ZipInputStream zis= new ZipInputStream(fis);
		//Thư mục sau khi giải nén
		File destDir= new File("unzipFolder");
		byte bytes[]= new byte[1024];
		
		ZipEntry zipEntry=zis.getNextEntry();
		while(zipEntry!=null) {
			File NewFile= newFile(destDir,zipEntry);
			if(zipEntry.isDirectory()) {
				//Nếu zipEntry là thư mục nhưng NewFile lại không phải là thư mục thì quăng ngoại lệ
				//vì zipEntry là thư mục thì buộc newFile sẽ trả về 1 thư mục
				if(!NewFile.isDirectory() && !NewFile.mkdirs()) {
					//mkdirs:true if and only if the directory was created,
					//along with all necessary parent directories; falseotherwise
					
					throw new IOException("Failed to create directory " + NewFile);
				}
			}else {
				File parent= NewFile.getParentFile();
				//Nếu zipEntry hiện tại là tệp tin nhưng cha của nó
				// lại ko phải thư mục hoặc không thể tạo thư mục thì...
				if(!parent.isDirectory() && !parent.mkdirs())
					throw new IOException("Failed to create directory " + parent);
				FileOutputStream fos= new FileOutputStream(NewFile);
				int len;
				while((len=zis.read(bytes))>0)
					fos.write(bytes,0,len);
				fos.close();
			}
			//Cho zipEntry đến vị trí tiếp theo để giải nén
			zipEntry=zis.getNextEntry();
		}
		zis.close();
		fis.close();
	}
}

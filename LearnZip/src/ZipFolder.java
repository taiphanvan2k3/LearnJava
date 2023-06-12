import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {
	private static FileOutputStream fos;
	private static ZipOutputStream zipOut;

	public static void zipFolder(File fileToZip, String fileName) throws IOException {
		if (fileToZip.isDirectory()) {
			File[] children = fileToZip.listFiles();
			for (File childFile : children)
				zipFolder(childFile, fileName + "\\" + childFile.getName());
		} else {
			FileInputStream fis = new FileInputStream(fileToZip);
			ZipEntry zipEntry = new ZipEntry(fileName);
			zipOut.putNextEntry(zipEntry);
			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) > 0)
				zipOut.write(bytes, 0, length);
			fis.close();
		}
	}

	public static void main(String[] args) throws IOException {
		fos = new FileOutputStream("Backup.zip");
		zipOut = new ZipOutputStream(fos);
		File f = new File("Backup");
		
		zipFolder(f, f.getName());
		//Phải đóng zipOut trước rồi mới đóng fos. Làm ngược lại là sai
		zipOut.close();
		fos.close();
	}
}

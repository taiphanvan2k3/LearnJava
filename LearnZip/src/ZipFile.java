import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {
	private static FileOutputStream fos;
	private static ZipOutputStream zipOut;

	public static void zipFile(File f) throws IOException {
		FileInputStream fis = new FileInputStream(f);

		ZipEntry zipEntry = new ZipEntry(f.getName());
		// putNextEntry: bắt đầu việc ghi một file zip mới và định
		// vị luồng vào vị trí bắt đầu ghi file
		zipOut.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		// Đọc mỗi lần tối đa 1024 bytes từ file fis
		// lưu vào mảng bytes. Giá trị trả về length là số byte
		// ghi vào mảng.Đọc đến khi nào hết bytes của file source thôi
		// Đọc xong length bytes đó, đã lưu vào
		// mảng, bây giờ ghi lại vào file zip
		while ((length = fis.read(bytes)) > 0)
			zipOut.write(bytes, 0, length);
		
		fis.close();
	}

	public static void zipMultipleFiles(File fileSource) throws IOException{
		if(fileSource.isDirectory()) {
			File ds[]=fileSource.listFiles();
			for (File file : ds)
				zipFile(file);
		}else zipFile(fileSource);
	}

	public static void main(String[] args) throws IOException {
		// Tên file zip khi giải nén file source là compressed.zip
		// Khởi tạo đối tượng fos để ghi dữ liệu ra file, cụ thể ở đây là
		// file zip
		fos = new FileOutputStream("compressedFolder.zip");
		zipOut = new ZipOutputStream(fos);

		File fileSource =new File("FolderTest");
		zipMultipleFiles(fileSource);
		zipOut.close();
		fos.close();
	}
}

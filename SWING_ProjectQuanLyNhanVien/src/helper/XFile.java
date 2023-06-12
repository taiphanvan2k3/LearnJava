package helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class XFile {
	public static Object readObject(String path) throws Exception {
		Object obj= null;
		FileInputStream fis= new FileInputStream(path);
		ObjectInputStream ois= new ObjectInputStream(fis);
		obj=ois.readObject();
		return obj;
	}
	
	
	public static void writeObject(String path,Object obj) throws Exception {
		FileOutputStream fos= new FileOutputStream(path);
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(obj);
	}
}

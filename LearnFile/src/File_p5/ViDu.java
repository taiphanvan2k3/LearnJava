package File_p5;
//Ghi dữ liệu ra file
import java.io.PrintWriter;
public class ViDu {
	public static void main(String[] args) {
		try {
			//in ra file
			PrintWriter pw= new PrintWriter("E:\\BtJava\\LearnFile\\test.txt", "utf-8");
			pw.println("Hello Phan Văn Tài");
			pw.print("Sinh ngày:"+24);
			student s=new student("Tiến", "21T_DT");
			//Nối vào file đã có bằng 
			pw.append("\nhello:"+s);			
			pw.close();
			//In ra màn hình console
			PrintWriter pw2= new PrintWriter(System.out);
			pw2.print("hello các bạn");
			pw2.flush();//phải có dòng này mới 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

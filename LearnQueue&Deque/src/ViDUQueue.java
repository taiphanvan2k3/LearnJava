import java.util.LinkedList;
import java.util.Queue;

public class ViDUQueue {
	public static void main(String[] args) {
		Queue<String> q=new LinkedList<String>();
		q.add("Nguyễn Văn A");
		q.add("Phan Văn Tài");
		q.add("Tiến");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}

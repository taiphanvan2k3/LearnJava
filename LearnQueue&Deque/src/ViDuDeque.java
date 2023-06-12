import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ViDuDeque {
	public static void main(String[] args) {
		Deque<Integer>dq=new LinkedList<Integer>();
		dq.offer(1);
		dq.offer(2);
		dq.offer(-5);
		dq.offerFirst(4);
		dq.offerLast(10);
//		while(!dq.isEmpty()) {
//			System.out.print(dq.poll()+" ");
//		}
		while(true) {
			Integer tam=dq.poll();
			if(tam==null)
				break;
			System.out.print(tam+" ");
		}
	}
}

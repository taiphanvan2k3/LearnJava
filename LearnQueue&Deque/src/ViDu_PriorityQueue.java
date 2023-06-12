import java.util.Comparator;
import java.util.PriorityQueue;
public class ViDu_PriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Integer>pq=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2)
					return -1;
				else if(o1<o2)
					return 1;
				return 0;
			}
			
		});
		pq.add(2);
		pq.add(9);
		pq.add(5);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}

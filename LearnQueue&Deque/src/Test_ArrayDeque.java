import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class Test_ArrayDeque {
	public static void main(String[] args) {
		ArrayList<Integer>a=new ArrayList<>();
		Vector<Integer>v=new Vector<>();
		
		v.add(2);
		a.add(3);
		a.set(0, 3);
		System.out.println(v.get(0));
		
	}
}

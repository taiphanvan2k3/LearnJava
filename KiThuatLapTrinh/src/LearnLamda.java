import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
interface StringFunction{
	String run(String str);
}

interface test{
	int add(int a,int b);
}
public class LearnLamda {
	public static void printFormat(String str,StringFunction format) {
		String res=format.run(str);
		System.out.println(res);
	}
	
	public static void testLamda1() {
		Consumer<Integer> consumer= (n)->{
			System.out.println("Đây là số "+n);
		};
		ArrayList<Integer>arr= new ArrayList<>();
		arr.add(3);
		arr.add(5);
		arr.forEach(consumer);
	}
	
	public static void testLamda2() {
		ArrayList<Integer>arr= new ArrayList<>();
		arr.add(3);
		arr.add(5);
		arr.forEach((n)->{
			System.out.println("Đây là số "+n);
		});
	}
	
	public static void testLamdaSort() {
		ArrayList<Integer>arr= new ArrayList<>();
		arr.add(5);
		arr.add(6);
		arr.add(2);
		Collections.sort(arr, (integer1,integer2)->{
			if(integer1>integer2)
				return -1;
			else if(integer1<integer2)
				return 1;
			return 0;
		});
		int b[]= {1,2,3};
		System.out.println(arr.toString());
	}
	public static void main(String[] args) {
//		Consumer<Integer> consumer=(m)->{
//			System.out.println("v");
//		};
//		testLamda2();
//		StringFunction test= (s)->s+" các bạn";
//		System.out.println(test.run("Chào"));
//		printFormat("Xin chào", test);
//		test t =(a,b)->a+b;
//		test t2= (a,b)->{
//			return a+b;
//		};
//		System.out.println(t2.add(3, 5));
		testLamdaSort();
	}
}

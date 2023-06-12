package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class test2 {
	public static void main(String[] args) {
//		ArrayList<SinhVien> dssv = new ArrayList<>();
//		SinhVien sv3=new SinhVien("102","C",2003,9);
//		SinhVien sv1=new SinhVien("102","A",2003,9);
//		SinhVien sv2=new SinhVien("103","B",2003,9.2);
//		SinhVien tam=new SinhVien("102", null, 0, 0);
//		dssv.add(sv1);
//		dssv.add(sv2);
//		dssv.add(sv3);
//		System.out.println(dssv.contains(tam));
//		System.out.println(dssv.size());
//		dssv.remove(dssv.get(1));
//		for (SinhVien sinhVien : dssv) {
//			System.out.println(sinhVien);
//		}
		ArrayList<Integer> ds= new ArrayList<>();
		ds.add(1);
		ds.add(3);
		ds.add(-2);
		ds.add(7);
		Collections.sort(ds,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2)
					return -1;
				else if(o1<o2)
					return 1;
				return 0;
			}
		});
		for (Integer i : ds) {
			System.out.println(i);
		}
	}
}

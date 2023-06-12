package test;

import java.util.ArrayList;

import model.employee;

public class Test {
	public static void main(String[] args) {
		ArrayList<employee>ds= new ArrayList<>();
		employee e=new employee("1", "Tai", 25,"taiphanvan", 2000);
		ds.add(e);
		employee res=ds.get(0);
		res.setId("001");
		System.out.println(e);
	}
}

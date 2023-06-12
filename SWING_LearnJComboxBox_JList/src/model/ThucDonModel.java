package model;

import java.util.Arrays;
import java.util.Hashtable;

public class ThucDonModel {
	private String monChinh;
	private String monPhu;
	private int tongTien;

	public ThucDonModel() {
		this.monChinh="";
		this.monPhu="";
		this.tongTien = 0;
	}
	
	public String getMonChinh() {
		return monChinh;
	}

	public void setMonChinh(String monChinh) {
		this.monChinh = monChinh;
	}

	public String getMonPhu() {
		return monPhu;
	}

	public void setMonPhu(String monPhu) {
		this.monPhu = monPhu;
	}

	public int getTongTien() {
		return this.tongTien;
	}

	public void tinhTongTien() {
		Hashtable<String, Integer> h= new Hashtable<>();
		h.put("Cơm", 20000);
		h.put("Bánh mì", 10000);
		h.put("Mì", 15000);
		h.put("Trà sữa", 20000);
		h.put("Coca", 12000);
		h.put("Bánh ngọt", 10000);
		int sum=0;
		if(h.get(monChinh)!=null)
			sum+=h.get(monChinh);
		String ds[]=this.monPhu.split(",");
		for (String str : ds) {
			if(h.get(str)!=null)
				sum+=h.get(str);
		}
		this.tongTien=sum;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}


}

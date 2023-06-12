package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class modelTool {
	private String vanBan,tuKhoa,ketQua;

	public String getVanBan() {
		return vanBan;
	}

	public void setVanBan(String vanBan) {
		this.vanBan = vanBan;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	
	public void thongKe() {
		if(this.vanBan.equals("") || this.tuKhoa.equals(""))
			this.ketQua="Kết quả: ";
		else {
			int cnt=0;
			Pattern p=Pattern.compile(tuKhoa);
			Matcher m=p.matcher(vanBan);
			while(m.find())
				cnt++;
			this.ketQua="Kết quả: có "+cnt+" từ "+this.tuKhoa;
		}
	}

}

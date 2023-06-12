package model;

import java.util.ArrayList;

public class HeThong {
	private ArrayList<ThiSinh> dsThiSinh;
	// Biến này để biết là người dùng trước đó chọn thêm
	// hay chỉnh sửa mới update được
	private String luaChon;
	private ThiSinh temp;
	private String tenFile;

	public HeThong() {
		this.tenFile = "";
		this.temp = new ThiSinh();
		this.luaChon = "";
		this.dsThiSinh = new ArrayList<>();
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public ThiSinh search(int mssv) {
		int n = this.dsThiSinh.size();
		for (int i = 0; i < n; i++)
			if (this.dsThiSinh.get(i).getMssv() == mssv)
				return this.dsThiSinh.get(i);
		return null;
	}

	public void insertThiSinh(ThiSinh t) {
		this.dsThiSinh.add(t);
	}

	public void deleteThiSinh(ThiSinh t) {
		this.dsThiSinh.remove(t);
	}

	public void update(ThiSinh t) {
		this.dsThiSinh.remove(t);
		this.dsThiSinh.add(t);
	}

	public void setLuaChon(String str) {
		this.luaChon = str;
	}

	public String getLuaChon() {
		return this.luaChon;
	}

	public boolean checkExist(int mssv) {
		for (ThiSinh ts : this.dsThiSinh)
			if (ts.getMssv() == mssv)
				return true;
		return false;
	}

	public void setThiSinhTemp(ThiSinh temp) {
		this.temp = temp;
	}

	public ThiSinh getThiSinhTemp() {
		return this.temp;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public void clearListThiSinh() {
		this.dsThiSinh.clear();
	}
}

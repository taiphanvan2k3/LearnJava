package model;

import java.io.File;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import helper.XFile;

public class danhSachEmployee {
	private ArrayList<employee> ds;
	private String path = "employee.txt";
	private int currentIndex = -1;

	public void writeIntoFile() throws Exception {
		XFile.writeObject(path, ds);
	}

	public void loadFromFile() throws Exception {
		File f= new File(path);
		if(f.exists()) {
			ds = (ArrayList<employee>) XFile.readObject(path);
		}
		else this.initDataEmployee();
	}

	public void loadFromFile(String path) throws Exception  {
		File f= new File(path);
		ds = (ArrayList<employee>) XFile.readObject(path);
		this.path=path;
	}
	
	public void writeIntoFile(String ds) throws Exception {
		XFile.writeObject(path, ds);
	}
	
	public void initDataEmployee() {
		this.insertEmployee(new employee("E01", "Ngân", 24, "abc@", 2000));
		this.insertEmployee(new employee("E02", "Tiến", 24, "tienze@", 2000));
		this.insertEmployee(new employee("E03", "Tài", 24, "taiphanvan@", 2000));
		this.insertEmployee(new employee("E04", "Trường", 24, "truong@", 2000));
	}
	
	public danhSachEmployee() {
		this.ds = new ArrayList<>();
	}

	public ArrayList<employee> getDs() {
		return ds;
	}

	public void setDs(ArrayList<employee> ds) {
		this.ds = ds;
	}

	public void insertEmployee(employee e) {
		this.ds.add(e);
	}

	public employee searchEmployee(String id) {
		for (employee e : ds) {
			if (e.getId().equals(id))
				return e;
		}
		return null;
	}

	public boolean deleteById(String id) {
		for (employee e : ds) {
			if (e.getId().equals(id)) {
				this.ds.remove(e);
				return true;
			}
		}

		return false;
	}

	public boolean update(employee e) {
		employee res = this.searchEmployee(e.getId());
		if (res != null) {
			res.setName(e.getName());
			res.setAge(e.getAge());
			res.setSalary(e.getSalary());
			res.setEmail(e.getEmail());
			return true;
		}
		return false;

	}

	// Xây dựng các phương thức để trả về employee khi bấm vào các button
	// next,previous,first,last
	public void first() {
		if (this.ds.size() > 0)
			this.currentIndex = 0;
	}

	public void previous() {
		if (this.currentIndex > 0)
			this.currentIndex--;
	}

	public void next() {
		if (currentIndex < this.ds.size() - 1)
			this.currentIndex++;
	}

	public void last() {
		this.currentIndex = this.ds.size() - 1;
	}

	public int getCurrentIndexEmployee() {
		return this.currentIndex;
	}

	public employee getCurrentEmployee() {
		if (currentIndex == -1)
			return null;
		return this.ds.get(currentIndex);
	}

	// Hiển thị lên table
	public void renderToTable(DefaultTableModel tableModel) {
		tableModel.setRowCount(0);
		for (employee e : ds)
			tableModel.addRow(e.covertIntoRow());

		tableModel.fireTableDataChanged();
	}

	public employee getEmployeeByIndex(int index) {
		return this.ds.get(index);
	}

	public int getSize() {
		return this.ds.size();
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	// Khi chọn hàng trên bảng thì phải cập nhật lại label là đang ở employee thứ
	// mấy
	public void setCurrentIndex(employee e) {
		this.currentIndex = this.ds.indexOf(e);
	}
}

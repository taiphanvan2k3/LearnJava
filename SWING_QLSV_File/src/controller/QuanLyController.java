package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

import model.ThiSinh;
import model.XDate;
import view.viewQuanLy;

public class QuanLyController implements ActionListener {

	private viewQuanLy view;

	public QuanLyController(viewQuanLy view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Insert")) {
			this.view.clearTextField();
		} else if (str.equals("Update")) {
			// Load dữ liệu thông tin sinh viên đó xuống textField
			this.view.hienThiThongTinDaChon();
		} else if (str.equals("Save")) {
			ThiSinh ts = this.view.loadDataFromTextField();
			this.view.themHoacCapNhatThiSinh(ts);
		} else if (str.equals("Delete")) {
			this.view.model.setLuaChon("Delete");
			this.view.xoaThiSinh();

		} else if (str.equals("Undo")) {
			// Undo: nút để hoàn tác
			// Nếu trước đó thêm mà bây giờ bấm cancel là xoá thí sinh vừa thêm đó
			// Nếu là xoá thì thêm lại
			// Cập nhật rồi thì quay lại dữ liệu cũ
			String luaChon = this.view.model.getLuaChon();
			if (!luaChon.equals("")) {
				ThiSinh previous = this.view.model.getThiSinhTemp();
				if (luaChon.equals("Insert"))
					this.view.xoaThiSinh(previous);
				else // Khi delete thì bây giờ thêm vào lại bảng, nếu update thì sửa lại dữ liệu cũ
					this.view.themHoacCapNhatThiSinh(previous);
				this.view.model.setLuaChon("");
			}
		} else if (str.equals("Tìm kiếm")) {
			this.view.TimKiem();
		} else if (str.equals("Huỷ")) {
			this.view.HuyTim();
		} else if (str.equals("Open")) {
			this.view.thucHienOpen();
		}
		else if (str.equals("SaveFile")) {
			this.view.thucHienSave();
		} else if (str.equals("Exit")) {
			int check = JOptionPane.showConfirmDialog(this.view.frame, "Bạn có muốn lưu lại tiến trình của mình không?");
			if (check == JOptionPane.YES_OPTION) {
				System.out.println("Đã lưu lại tiến trình.");
				System.exit(0);
			}
		} else if (str.equals("About me")) {
			JOptionPane.showMessageDialog(this.view.frame, "Chương trình quản lí sinh viên 1.0");
		}
	}

}

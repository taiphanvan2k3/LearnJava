package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import view.ThucDonView;

public class ThucDonController implements ActionListener {

	private ThucDonView thucDonView;

	public ThucDonController(ThucDonView thucDonView) {
		this.thucDonView = thucDonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String monChinh = thucDonView.jComboBox_monChinh.getSelectedItem().toString();
		String monPhu = "";
		List<String> luaChonMonPhu = thucDonView.jList_monPhu.getSelectedValuesList();

		int n = luaChonMonPhu.size();
		for (int i = 0; i < n; i++) {
			monPhu += luaChonMonPhu.get(i);
			if (i < n - 1)
				monPhu += ",";
		}

		thucDonView.setMonChinh(monChinh);
		thucDonView.setMonPhu(monPhu);
		thucDonView.updateTongTien();
		thucDonView.InHoaDon();

		String input = JOptionPane.showInputDialog(thucDonView.f,
				thucDonView.jLabel_hoaDon.getText() + "\nNhập vào số tiền", "Thông báo", JOptionPane.PLAIN_MESSAGE);
		try {
			int soTien = Integer.valueOf(input);
			if (soTien < thucDonView.getTongTien())
				JOptionPane.showMessageDialog(thucDonView.f, "Số tiền nhập vào chưa đủ để thanh toán!", "Error",
						JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(thucDonView.f,
						"Số tiền thối lại cho khách:" + (soTien - thucDonView.getTongTien()), "Infor",
						JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(thucDonView.f, "Nhập dữ liệu sai!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}

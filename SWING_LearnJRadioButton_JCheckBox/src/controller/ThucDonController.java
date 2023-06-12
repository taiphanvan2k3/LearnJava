package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

import view.ThucDonView;

public class ThucDonController implements ActionListener{
	
	private ThucDonView thucDonView;
	
	public ThucDonController(ThucDonView thucDonView) {
		this.thucDonView=thucDonView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str="";
		Enumeration<AbstractButton> button_MonChinh =thucDonView.buttonGroup_monChinh.getElements();
		while(button_MonChinh.hasMoreElements()) {
			AbstractButton b= button_MonChinh.nextElement();
			if(b.isSelected()) {
				str=b.getText();
				break;
			}
		}
		
		this.thucDonView.setMonChinh(str);
		str="";
		for(JCheckBox b:this.thucDonView.list_monPhu) {
			if(b.isSelected()) {
				if(str=="")
					str+=b.getText();
				else str+=","+b.getText();
			}
		}
		this.thucDonView.setMonPhu(str);
		this.thucDonView.updateTongTien();
		str=e.getActionCommand();
		if(str.equals("Thanh toán"))
			this.thucDonView.InHoaDon();
	}

}

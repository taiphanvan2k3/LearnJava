package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.danhSachEmployee;
import model.employee;
import view.FormInfoEmployee;

public class controllerEmployee implements ActionListener {
	private FormInfoEmployee form;

	public controllerEmployee(FormInfoEmployee form) {
		this.form = form;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("New")) {
			this.form.resetAllTextFields();
		} else if (src.equals("Save")) {
			this.form.saveFunction();
		} else if (src.equals("Delete")) {
			this.form.deleteFunction();
		}else if(src.equals("Find")) {
			this.form.findFunction();
		}else if(src.equals("Open")) {
			this.form.openFunction();
		} else if (src.equals("Exit")) {
			this.form.exitFunction();
		}else {
			danhSachEmployee list=this.form.getListEmployee();
			if(src.equals("|<"))
				list.first();
			else if(src.equals("<<"))
				list.previous();
			else if(src.equals(">>"))
				list.next();
			else list.last();
			int idx=list.getCurrentIndexEmployee();
			this.form.displayEmployee(idx);
		}
	}

}

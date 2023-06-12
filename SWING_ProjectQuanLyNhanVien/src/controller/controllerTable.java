package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import view.FormInfoEmployee;


public class controllerTable implements MouseListener{
	private FormInfoEmployee form;
	public controllerTable(FormInfoEmployee form) {
		this.form=form;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row_selected=this.form.getSelectedRow();
		this.form.displayRowSelected(row_selected);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

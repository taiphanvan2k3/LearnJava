package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewTool;

public class controllerTool implements ActionListener{
	private viewTool ViewTool;
	public controllerTool(viewTool viewTool) {
		ViewTool = viewTool;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.ViewTool.updateAnswer();
	}
	
}

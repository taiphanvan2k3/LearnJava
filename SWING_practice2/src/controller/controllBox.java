package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.viewBox;

public class controllBox implements ActionListener {

	private viewBox vBox;

	public controllBox(viewBox v) {
		this.vBox = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		int value = src.charAt(0) - '0';
		this.vBox.updateLabel(value);
	}

}

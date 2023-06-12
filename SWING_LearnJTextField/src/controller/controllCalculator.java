package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewCalculator;

public class controllCalculator implements ActionListener{
	private viewCalculator view;
	public controllCalculator(viewCalculator view) {
		this.view = view;
	}
	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();
		if(str.equals("+"))
			this.view.add();
		if(str.equals("-"))
			this.view.minus();
		if(str.equals("*"))
			this.view.multiply();
		if(str.equals("/"))
			this.view.divide();
		if(str.equals("^"))
			this.view.power();
		if(str.equals("%"))
			this.view.mod();
	}
	
}

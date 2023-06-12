package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ColorView;

public class colorListener implements ActionListener {
	private ColorView colorview;
	public colorListener(ColorView colorview) {
		this.colorview = colorview;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src=e.getActionCommand();
		if(src.equals("RED TEXT"))
			this.colorview.updateColorText(Color.red);
		else if(src.equals("YELLOW TEXT"))
			this.colorview.updateColorText(Color.yellow);
		else if(src.equals("GREEN TEXT"))
			this.colorview.updateColorText(Color.green);
		else if(src.equals("RED BACKGROUND"))
			this.colorview.updateColorBackGround(Color.red);
		else if(src.equals("YELLOW BACKGROUND"))
			this.colorview.updateColorBackGround(Color.yellow);
		else if(src.equals("GREEN BACKGROUND"))
			this.colorview.updateColorBackGround(Color.green);
	}

}

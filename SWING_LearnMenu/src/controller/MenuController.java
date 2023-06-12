package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MenuExample;

public class MenuController implements ActionListener{
	private MenuExample menuExample;
	
	public MenuController(MenuExample menuExample) {
		this.menuExample = menuExample;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();
		if(!str.equals("Exit"))
			this.menuExample.updateJLabel(str);
		else System.exit(0);
	}

}

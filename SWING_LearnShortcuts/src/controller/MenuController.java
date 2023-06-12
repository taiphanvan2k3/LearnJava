package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import view.MenuView;

public class MenuController implements ActionListener {
	private MenuView menuView;

	public MenuController(MenuView menuView) {
		this.menuView = menuView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		AbstractButton checkBox=(AbstractButton) e.getSource();
		if(checkBox.getModel().isSelected())
			System.out.println("Button is selecting");
		else System.out.println("Button is not selecting");
		if (src.equals("Exit")) {
			System.exit(0);
		} else if (src.equals("Toolbar")) {
			this.menuView.setVisibleOfToolbar();
//			AbstractButton checkBox=(AbstractButton) e.getSource();
//			if(checkBox.getModel().isSelected())
//				System.out.println("Button is selecting");
//			else System.out.println("Button is not selecting");
		}
		else
			this.menuView.updateLabel(src);
	}

}

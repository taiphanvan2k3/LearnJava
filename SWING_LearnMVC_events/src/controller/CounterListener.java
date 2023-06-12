package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CounterView;

public class CounterListener implements ActionListener {
	private CounterView counterView;

	public CounterListener(CounterView ctv) {
		this.counterView = ctv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Up"))
			this.counterView.increase();
		else if(str.equals("Down"))
			this.counterView.decrease();
	}

}

package Threading;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ThreadCheckTkMk extends Thread {
	private JTextField tk;
	private JPasswordField mk, confirm;
	private JLabel checkTk, checkMk, checkConfirm;

	public ThreadCheckTkMk(JTextField tk, JPasswordField mk, JPasswordField confirm, JLabel checkTk, JLabel checkMk,
			JLabel checkConfirm) {
		this.tk = tk;
		this.mk = mk;
		this.checkTk = checkTk;
		this.checkMk = checkMk;
		this.checkConfirm = checkConfirm;
		this.confirm = confirm;
	}

	public ThreadCheckTkMk(JTextField tk, JPasswordField mk, JLabel checkTk, JLabel checkMk) {
		super();
		this.tk = tk;
		this.mk = mk;
		this.checkTk = checkTk;
		this.checkMk = checkMk;
		this.confirm = null;
	}

	public void run() {
		while (true) {
			String tk_str = tk.getText();
			if (tk_str != null) {
				if (tk.getText().equals("")) {
					checkTk.setText("*");
					checkTk.setForeground(Color.red);
				} else
					checkTk.setText("");
			}

			String pass = new String(mk.getPassword());
			if (pass.equals("")) {
				checkMk.setText("*");
				checkMk.setForeground(Color.red);
			} else
				checkMk.setText("");

			if (confirm != null) {
				String passConfirm = new String(confirm.getPassword());
				if (passConfirm.equals("")) {
					checkConfirm.setText("*");
					checkConfirm.setForeground(Color.red);
				} else
					checkConfirm.setText("");
			}
		}
	}
}

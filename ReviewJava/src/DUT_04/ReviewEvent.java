package DUT_04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ReviewEvent extends JFrame implements ActionListener {
	JButton buttonOK;
	JButton buttonOk2;
	JTextField textField;

	public void initComponents() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public ReviewEvent() {
		this.initComponents();
		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.CENTER);
		this.add(textField);

		buttonOK = new JButton("OK");
		this.add(buttonOK, BorderLayout.NORTH);
		buttonOK.addActionListener(new XuLy1(textField));

		buttonOk2 = new JButton("Ok");
		this.add(buttonOk2, BorderLayout.SOUTH);

		// buttonOk2.addActionListener(this);
		// buttonOk2.addActionListener(new XuLy2(textField));
		buttonOk2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("Hihi");
			}
		});
	}

	public static void main(String[] args) {
		new ReviewEvent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if (src.equals("OK"))
			textField.setText("Haha");
		else
			textField.setText("Hihi");
	}
}

class XuLy1 implements ActionListener {
	private JTextField ta;

	public XuLy1(JTextField ta) {
		this.ta = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("Haha");
	}
}

class XuLy2 implements ActionListener {
	private JTextField ta;

	public XuLy2(JTextField ta) {
		this.ta = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("Hihi");
	}
}
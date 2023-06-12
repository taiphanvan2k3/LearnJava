package view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class courses extends JPanel{
	public courses() {
		JButton addCourse= new JButton("Add Course");
		JButton clear= new JButton("Clear");
		this.add(addCourse);
		this.add(clear);
	}
}

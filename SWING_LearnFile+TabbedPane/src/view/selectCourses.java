package view;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class selectCourses extends JPanel{
	selectCourses(){
		JCheckBox java,swing,hibernate;
		java=new JCheckBox("Java");
		swing= new JCheckBox("Swing");
		hibernate= new JCheckBox("Hibernate");
		this.add(java);
		this.add(swing);
		this.add(hibernate);
	}
}

package view;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.MenuController;

public class MenuExample extends JFrame{

	private JLabel jLabel_screen;

	public MenuExample() {
		this.init();
		//Tạo thanh menu
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu_File= new JMenu("File");
		JMenuItem jMenuItem_new= new JMenuItem("New");
		JMenuItem jMenuItem_open = new JMenuItem("Open");
		JMenuItem jMenuItem_recentFile = new JMenuItem("Recent Files");
		JMenuItem jMenuItem_exit= new JMenuItem("Exit");
		jMenu_File.add(jMenuItem_new);
		jMenu_File.addSeparator();
		jMenu_File.add(jMenuItem_open);
		jMenu_File.addSeparator();
		jMenu_File.add(jMenuItem_recentFile);
		jMenu_File.addSeparator();
		jMenu_File.add(jMenuItem_exit);
		jMenu_File.addSeparator();
		JMenu jMenu_Help= new JMenu("Help");
		JMenuItem jMenuItem_Search= new JMenuItem("Search");
		jMenu_Help.add(jMenuItem_Search);
		jMenuBar.add(jMenu_File);
		jMenuBar.add(jMenu_Help);
		
		
		//Tạo JLabel hiển thị thao tác nhấn menu
		jLabel_screen = new JLabel();
		this.setLayout(new BorderLayout());
		Font font= new Font("Arial",Font.BOLD,20);
		jLabel_screen.setFont(font);
		this.add(jLabel_screen,BorderLayout.CENTER);
		//Thêm thanh menu vào JFrame
		this.setJMenuBar(jMenuBar);
		
		//Add sự kiện
		ActionListener ac= new MenuController(this);
		jMenuItem_new.addActionListener(ac);
		jMenuItem_open.addActionListener(ac);
		jMenuItem_recentFile.addActionListener(ac);
		jMenuItem_Search.addActionListener(ac);
		jMenuItem_exit.addActionListener(ac);
	}
	
	public void init() {
		this.setTitle("Menu Example");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void updateJLabel(String s) {
		this.jLabel_screen.setText(s);
	}
}

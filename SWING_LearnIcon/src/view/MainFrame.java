package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class MainFrame extends JFrame{
	public void init() {
		this.setTitle("Test app");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public MainFrame() {
		this.init();
		//set icon cho JFrame
		URL url_iconNotepad= MainFrame.class.getResource("screen.jpg");
		Image img= Toolkit.getDefaultToolkit().createImage(url_iconNotepad);
		this.setIconImage(img);
		
		JMenuBar jMenuBar= new JMenuBar();
		JMenu jMenu_file= new JMenu("File");
		JMenuItem jMenuItem_New= new JMenuItem("New");
		jMenuItem_New.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("icon_new.png"))));
		JMenuItem jMenuItem_Open= new JMenuItem("Open");
		jMenuItem_Open.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("icon_open.png"))));
		JMenuItem jMenuItem_Save= new JMenuItem("Save");
		jMenuItem_Save.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("icon_save.png"))));
		jMenu_file.add(jMenuItem_New);
		jMenu_file.add(jMenuItem_Save);
		jMenu_file.add(jMenuItem_Open);
		jMenuBar.add(jMenu_file);
		
		JButton jButton_enter= new JButton("Button Test");
		jButton_enter.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("icon_button.png"))));
		JLabel jLabel_screen= new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("screen.jpg"))), JLabel.CENTER);
		this.setLayout(new BorderLayout());
		this.setJMenuBar(jMenuBar);
		this.add(jButton_enter,BorderLayout.SOUTH);
		this.add(jLabel_screen,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MainFrame();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

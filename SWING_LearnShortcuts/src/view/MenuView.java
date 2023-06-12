package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import controller.MenuController;
import controller.MenuMouseController;

public class MenuView extends JFrame {
	private JLabel screen;
	public JPopupMenu jPopupMenu;
	// Tạo jToolBar toàn cục để setVisible toolbar
	private JToolBar jToolBar;

	public MenuView() {
		this.init();
		ActionListener ac = new MenuController(this);
		// Tạo thanh menu
		JMenuBar jMenuBar = new JMenuBar();
		// jMenu File
		JMenu jMenu_file = new JMenu("File");
		JMenuItem jMenuItem_new = new JMenuItem("New", KeyEvent.VK_N);
		jMenuItem_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));// Ctrl+N
		JMenuItem jMenuItem_open = new JMenuItem("Open", KeyEvent.VK_O);
		jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));// Ctrl+O
		JMenuItem jMenuItem_exit = new JMenuItem("Exit", KeyEvent.VK_E);
		jMenuItem_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		jMenu_file.add(jMenuItem_new);
		jMenu_file.add(jMenuItem_open);
		jMenu_file.addSeparator();
		jMenu_file.add(jMenuItem_exit);
		// JMenu View
		JMenu jMenu_view = new JMenu("View");
		// Tạo tích chọn menu để hiển thị/tắt thanh công cụ
		JCheckBoxMenuItem jCheckBoxMenuItem_toolbar = new JCheckBoxMenuItem("Toolbar");
		jMenu_view.add(jCheckBoxMenuItem_toolbar);

		// JMenu Help
		JMenu jMenu_help = new JMenu("Help");
		JMenuItem jMenuItem_welcome = new JMenuItem("Welcome");
		jMenu_help.add(jMenuItem_welcome);
		jMenu_file.setMnemonic(KeyEvent.VK_F);
		jMenu_help.setMnemonic(KeyEvent.VK_H);

		// Thêm các JMenu vào JMenuBar
		jMenuBar.add(jMenu_file);
		jMenuBar.add(jMenu_view);
		jMenuBar.add(jMenu_help);
		this.setJMenuBar(jMenuBar);

		// Tạo thanh công cụ
		jToolBar = new JToolBar();
		JButton jButton_undo = new JButton("Undo");
		jButton_undo.setToolTipText("Nhấn vào đây để quay lại thao tác vừa rồi.");
		// add phím tắt cho button bằng phương thức setMnemonic
		jButton_undo.setMnemonic(KeyEvent.VK_U);
		JButton jButton_redo = new JButton("Redo");
		JButton jButton_copy = new JButton("Copy");
		JButton jButton_cut = new JButton("Cut");
		JButton jButton_paste = new JButton("Paste");
		jToolBar.add(jButton_undo);
		jToolBar.add(jButton_redo);
		jToolBar.add(jButton_copy);
		jToolBar.add(jButton_cut);
		jToolBar.add(jButton_paste);

		// Tạo menu chuột phải
		jPopupMenu = new JPopupMenu();
		JMenu test = new JMenu("test");
		JMenu jMenuPoupFont = new JMenu("Font");
		JMenuItem jMenuItemType = new JMenuItem("Type");
		jMenuItemType.addActionListener(ac);
		JMenuItem jMenuItemSize = new JMenuItem("Size");
		jMenuItemSize.addActionListener(ac);
		jMenuPoupFont.add(jMenuItemType);
		jMenuPoupFont.add(jMenuItemSize);
		// 1 JMenu có thể chứa 1 JMenu khác,....
		test.add(jMenuPoupFont);
		JMenuItem jMenuItemCut = new JMenuItem("Cut");
		jMenuItemCut.addActionListener(ac);
		JMenuItem jMenuItemCopy = new JMenuItem("Copy");
		jMenuItemCopy.addActionListener(ac);
		JMenuItem jMenuItemPaste = new JMenuItem("Paste");
		jMenuItemPaste.addActionListener(ac);

		jPopupMenu.add(test);
		jPopupMenu.addSeparator();
		jPopupMenu.add(jMenuItemCut);
		jPopupMenu.add(jMenuItemCopy);
		jPopupMenu.add(jMenuItemPaste);
		// Thêm menu chuột phải vào JFrame
		this.add(jPopupMenu);

		// Thêm sự kiện phải chuột vào JLabel
		MenuMouseController menuMouseController = new MenuMouseController(this);
		this.addMouseListener(menuMouseController);

		// Add sự kiện cho các menubar và button

		jMenuItem_new.addActionListener(ac);
		jMenuItem_open.addActionListener(ac);
		jMenuItem_exit.addActionListener(ac);
		jMenuItem_welcome.addActionListener(ac);
		jButton_undo.addActionListener(ac);
		jButton_redo.addActionListener(ac);
		jButton_copy.addActionListener(ac);
		jButton_cut.addActionListener(ac);
		jButton_paste.addActionListener(ac);
		jCheckBoxMenuItem_toolbar.addActionListener(ac);

		screen = new JLabel("", JLabel.CENTER);
		screen.setFont(new Font("Arial", Font.BOLD, 20));
		this.setLayout(new BorderLayout());
		this.add(screen, BorderLayout.CENTER);
		this.add(jToolBar, BorderLayout.NORTH);
		// Mặc định ban đầu không thấy thanh toolbar vì ban đầu chưa
		// tích chọn jCheckBoxMenuItem
		jToolBar.setVisible(false);
	}

	public void init() {
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void updateLabel(String src) {
		this.screen.setText(src);
	}

	public void setVisibleOfToolbar() {
		if (jToolBar.isVisible())
			jToolBar.setVisible(false);
		else
			jToolBar.setVisible(true);
	}
}

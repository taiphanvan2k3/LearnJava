package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawExample extends JFrame implements KeyListener {
	Stack<Integer> st;

	public DrawExample() {
		st = new Stack<>();
		this.setTitle("Draw Example");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		// JPanelDraw jPanelDraw = new JPanelDraw();
		// jPanelDraw.setBackground(Color.cyan);
		// this.add(jPanelDraw, BorderLayout.CENTER);
		this.addKeyListener(this);

	}

	public static void main(String[] args) {
		new DrawExample();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// việc có thể nhấn giữ nên nếu phần tử đầu stack giống với
		// key mình vừa nhấn thì
		if (st.size() == 0 || (st.size() != 0 && st.peek() != key))
			st.add(key);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(st.toString());
		if (st.size() >= 2 && key == KeyEvent.VK_X && st.get(0) == KeyEvent.VK_CONTROL)
			System.exit(0);
		st.clear();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {

	private ArrayList<Point> dsTam;
	private Vector<Vector<Integer>> adj;
	private boolean[] visited;
	private JTextField txtRandPoint;
	private JTextField txtRandPair;
	private JPanel panelDraw;

	private JTextField txtCheck;

	private void initComponents() {
		this.setTitle("Phan Văn Tài-102210230-21TCLC_DT3");
		this.setSize(600, 400);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

		JPanel panelTop = new JPanel();
		// subpanel1
		JPanel subPanel1 = new JPanel();
		subPanel1.setLayout(new FlowLayout());
		
		JButton btnRandPoint = new JButton("Rand Point");
		btnRandPoint.setBackground(Color.blue);
		btnRandPoint.setForeground(Color.white);
		
		txtRandPoint = new JTextField(10);
		txtRandPoint.setHorizontalAlignment(JTextField.RIGHT);
		
		JButton btnRandPair = new JButton("Rand Pair");
		btnRandPair.setBackground(Color.blue);
		btnRandPair.setForeground(Color.white);
		
		txtRandPair = new JTextField(10);
		txtRandPair.setHorizontalAlignment(JTextField.RIGHT);
		
		subPanel1.add(btnRandPoint);
		subPanel1.add(txtRandPoint);
		subPanel1.add(btnRandPair);
		subPanel1.add(txtRandPair);
		subPanel1.setBackground(Color.white);

		// subpanel2
		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout());
		
		JButton btnCheck = new JButton("Check?");
		btnCheck.setBackground(Color.blue);
		btnCheck.setForeground(Color.white);
		
		txtCheck = new JTextField(10);
		txtCheck.setForeground(Color.black);
		txtCheck.setHorizontalAlignment(JTextField.RIGHT);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.blue);
		btnExit.setForeground(Color.white);
		
		subPanel2.add(btnCheck);
		subPanel2.add(txtCheck);
		subPanel2.add(btnExit);
		subPanel2.setBackground(Color.white);

		panelTop.setLayout(new GridLayout(2, 1));
		panelTop.add(subPanel1);
		panelTop.add(subPanel2);

		panelDraw = new JPanel();
		this.setLayout(new BorderLayout());
		this.add(panelTop, BorderLayout.NORTH);
		this.add(panelDraw, BorderLayout.CENTER);

		// Add action Listener
		btnRandPoint.addActionListener(this);
		btnRandPair.addActionListener(this);
		btnCheck.addActionListener(this);
		btnExit.addActionListener(this);
		
		//Phải đặt visible ở cuối
		this.setVisible(true);
	}

	public GUI() {
		dsTam = new ArrayList<Point>();
		adj = new Vector<Vector<Integer>>();
		visited = new boolean[1000];
		initComponents();
//		JOptionPane.showMessageDialog(this,
//				"Nếu không thấy hiển thị giao diện thì vui lòng nhấn nút thu nhỏ (-)\n ở góc phải");
	}

	public static void main(String[] args) {
		new GUI();
	}

	private void drawCircle(int n) {
		Graphics g = panelDraw.getGraphics();
		Random r = new Random();
		int curr = adj.size();
		for (int i = 0; i < n; i++) {
			int x = r.nextInt(panelDraw.getWidth() - 50);
			int y = r.nextInt(panelDraw.getHeight() - 50);
			g.setColor(Color.blue);
			g.fillOval(x, y, 10, 10);
			dsTam.add(new Point(x + 10 / 2, y + 10 / 2));
			adj.add(new Vector<>());
		}
	}

	private void drawPair(int n) {
		Graphics g = panelDraw.getGraphics();
		g.setColor(Color.blue);
		int currEdge = dsTam.size() * (dsTam.size() - 1) / 2;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			int idx1 = r.nextInt(dsTam.size());
			int idx2 = r.nextInt(dsTam.size());
			int j = 0;
			while ((idx2 == idx1 || adj.get(idx1).indexOf(idx2) != -1) && j < 2 * currEdge) {
				idx2 = r.nextInt(dsTam.size());
				System.out.println(idx1 + " " + idx2);
				j++;
			}
			if (j == 2 * currEdge)
				continue;
			adj.get(idx1).add(idx2);
			adj.get(idx2).add(idx1);
			Point p1 = dsTam.get(idx1);
			Point p2 = dsTam.get(idx2);
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
	}

	private void dfs(int u) {
		visited[u] = true;
		for (int x : adj.get(u)) {
			if (!visited[x])
				dfs(x);
		}
	}

	private boolean checkLienThong() {
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;
		dfs(0);
		for (int i = 0; i < adj.size(); i++)
			System.out.print(visited[i] + " ");
		System.out.println();
		for (int i = 0; i < adj.size(); i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Exit")) {
			this.dispose();
		} else if (src.equals("Rand Point")) {
			int n = -1;
			try {
				n = Integer.valueOf(txtRandPoint.getText());
				txtRandPoint.setBackground(Color.white);
				drawCircle(n);
			} catch (Exception e2) {
				JOptionPane.showConfirmDialog(this, "Error: " + e2.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE,
						JOptionPane.ERROR_MESSAGE);
				txtRandPoint.setBackground(Color.red);
			}
		} else if (src.equals("Rand Pair")) {
			int n = -1;
			try {
				n = Integer.valueOf(txtRandPair.getText());
				txtRandPair.setBackground(Color.white);
				int num = dsTam.size();
				if (num * (num - 1) / 2 < n) {
					JOptionPane.showConfirmDialog(this, "Không đủ điểm để tạo số đường thẳng đã nhập", "Lỗi",
							JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
					return;
				}
				drawPair(n);
			} catch (Exception e2) {
				JOptionPane.showConfirmDialog(this, "Error: " + e2.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE,
						JOptionPane.ERROR_MESSAGE);
				txtRandPair.setBackground(Color.red);
			}
		} else if (src.equals("Check?")) {
			if (adj.size() > 0)
				txtCheck.setText(checkLienThong() + "");
			else
				JOptionPane.showConfirmDialog(this, "Bạn chưa nhập điểm nào.", "Chú ý", JOptionPane.PLAIN_MESSAGE,
						JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

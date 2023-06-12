import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test extends JFrame implements ActionListener {
	private ArrayList<Point> dsTam = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> adj;
	private boolean[] visited = new boolean[10000];
	private JPanel panelDraw;
	private JTextField txtRandPoint;
	private JTextField txtRandPair;
	private JTextField txtCheck;

	private void initComponents() {
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

		JPanel panelTop = new JPanel();

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

		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout());

		JButton btnCheck = new JButton("Check?");
		btnCheck.setBackground(Color.blue);
		btnCheck.setForeground(Color.white);

		txtCheck = new JTextField(10);
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

		btnRandPoint.addActionListener(this);
		btnRandPair.addActionListener(this);
		btnExit.addActionListener(this);
		btnCheck.addActionListener(this);
		this.setVisible(true);
	}

	public Test() {
		initComponents();
		adj = new ArrayList<>();
	}

	public static void main(String[] args) {
		new Test();
	}

	private void drawCircle(int n) {
		Random r = new Random();
		Graphics g = panelDraw.getGraphics();
		g.setColor(Color.BLUE);
		for (int i = 0; i < n; i++) {
			int x = r.nextInt(panelDraw.getWidth() - 50);
			int y = r.nextInt(panelDraw.getHeight() - 50);
			g.fillOval(x, y, 10, 10);
			dsTam.add(new Point(x + 10 / 2, y + 10 / 2));
			adj.add(new ArrayList<>());
		}
	}

	private int currNoEdge = 0;

	private void drawLine(int n) {
		Random r = new Random();
		Graphics g = panelDraw.getGraphics();
		g.setColor(Color.BLUE);
		int maxEdge = dsTam.size() * (dsTam.size() - 1) / 2;
		for (int i = 0; i < n; i++) {
			int idx1 = r.nextInt(dsTam.size());
			int idx2 = r.nextInt(dsTam.size());
			int j = 0;
			while ((idx1 == idx2 || adj.get(idx1).indexOf(idx2) != -1) && j < 2 * maxEdge) {
				idx1 = r.nextInt(dsTam.size());
				idx2 = r.nextInt(dsTam.size());
				j++;
			}
			if (j == 2 * maxEdge)
				continue;
			Point p1 = dsTam.get(idx1);
			Point p2 = dsTam.get(idx2);
			adj.get(idx1).add(idx2);
			adj.get(idx2).add(idx1);
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			currNoEdge++;
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
		for (int i = 0; i < dsTam.size(); i++)
			if (!visited[i])
				return false;
		return true;
	}

	private boolean checkTriangle() {
		int n = adj.size();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = adj.get(i);
			for (int k = 0; k < temp.size() - 1; k++) {
				for (int l = k + 1; l < temp.size(); l++) {
					int v1 = temp.get(k);
					int v2 = temp.get(l);
					if (adj.get(v1).indexOf(v2) != -1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Exit"))
			this.dispose();
		else if (src.equals("Rand Point")) {
			try {
				int n = Integer.valueOf(txtRandPoint.getText());
				if (n < 0)
					throw new Exception("Giá trị không hợp lệ");
				txtRandPoint.setBackground(Color.white);
				drawCircle(n);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Error: " + e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				txtRandPoint.setBackground(Color.red);
			}

		} else if (src.equals("Rand Pair")) {
			try {
				int maxEdge = dsTam.size() * (dsTam.size() - 1) / 2;
				int n = Integer.valueOf(txtRandPair.getText());
				if (n < 0) {
					throw new Exception("Giá trị không hợp lệ");
				} else if (n + currNoEdge > maxEdge) {
					throw new Exception("Số cạnh nhập vào vượt quá số cạnh có thể thêm của đồ thị");
				}
				txtRandPair.setBackground(Color.white);
				drawLine(n);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Error: " + e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				txtRandPair.setBackground(Color.red);
			}

		} else if (src.equals("Check?")) {
			if (dsTam.size() > 0)
//				txtCheck.setText(this.checkLienThong() + "");
				txtCheck.setText(this.checkTriangle() + "");
			else
				JOptionPane.showMessageDialog(this, "Không có số đỉnh nào để nối cạnh", "Error",
						JOptionPane.ERROR_MESSAGE);

		}
	}

}

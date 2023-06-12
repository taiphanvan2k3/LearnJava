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

public class PhanVanTai_102210230 extends JFrame implements ActionListener {
	private JTextField txtRandOval;
	private JTextField txtRandRect;
	private JTextField txtCheck;
	private JPanel rightPanel;

	private ArrayList<HinhVuong> dsHinhVuong = new ArrayList<>();
	private ArrayList<Circle> dsCiclre = new ArrayList<>();

	private void initCompoents() {
		this.setTitle("Thi giữa kì");
		this.setSize(600, 300);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);

		JPanel leftPanel = new JPanel();

		JPanel subPanel1 = new JPanel();

		JPanel subPanel1_1 = new JPanel();
		subPanel1_1.setLayout(new FlowLayout());
		subPanel1_1.setBackground(Color.white);

		JButton btnRandOval = new JButton("Rand Oval");
		btnRandOval.setBackground(Color.BLUE);
		btnRandOval.setForeground(Color.white);

		txtRandOval = new JTextField(10);
		txtRandOval.setHorizontalAlignment(JTextField.RIGHT);
		subPanel1_1.add(btnRandOval);
		subPanel1_1.add(txtRandOval);

		JPanel subPanel1_2 = new JPanel();
		subPanel1_2.setLayout(new FlowLayout());
		subPanel1_2.setBackground(Color.white);
		JButton btnRandRect = new JButton("Rand Rect");
		btnRandRect.setBackground(Color.BLUE);
		btnRandRect.setForeground(Color.white);

		txtRandRect = new JTextField(10);
		txtRandRect.setHorizontalAlignment(JTextField.RIGHT);
		subPanel1_2.add(btnRandRect);
		subPanel1_2.add(txtRandRect);

		subPanel1.setLayout(new GridLayout(2, 1));
		subPanel1.setBackground(Color.white);
		subPanel1.add(subPanel1_1);
		subPanel1.add(subPanel1_2);

		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout());
		subPanel2.setBackground(Color.white);

		JButton btnCheck = new JButton("Check ?   ");
		btnCheck.setBackground(Color.BLUE);
		btnCheck.setForeground(Color.white);

		txtCheck = new JTextField(10);
		txtCheck.setHorizontalAlignment(JTextField.RIGHT);
		txtCheck.setBackground(Color.LIGHT_GRAY);
		txtCheck.setForeground(Color.black);
		txtCheck.setText("false");
		subPanel2.add(btnCheck);
		subPanel2.add(txtCheck);

		JPanel subPanel3 = new JPanel();
		subPanel3.setLayout(new FlowLayout());
		subPanel3.setBackground(Color.white);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.BLUE);
		btnExit.setForeground(Color.white);
		subPanel3.add(btnExit);

//		leftPanel.setLayout(new GridLayout(3, 1));
//		leftPanel.setBackground(Color.white);
//		leftPanel.add(subPanel1);
//		leftPanel.add(subPanel2);
//		leftPanel.add(subPanel3);

		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(subPanel1, BorderLayout.NORTH);
		leftPanel.add(subPanel2, BorderLayout.CENTER);
		leftPanel.add(subPanel3, BorderLayout.SOUTH);

		rightPanel = new JPanel();
		rightPanel.setBackground(Color.lightGray);
		this.setLayout(new GridLayout(1, 2));
		this.add(leftPanel);
		this.add(rightPanel);

		btnRandOval.addActionListener(this);
		btnRandRect.addActionListener(this);
		btnCheck.addActionListener(this);
		btnExit.addActionListener(this);

		this.setVisible(true);
	}

	public PhanVanTai_102210230() {
		initCompoents();
	}

	public static void main(String[] args) {
		new PhanVanTai_102210230();
	}

	private void drawCircle(int n) {
		Random r = new Random();
		Graphics g = rightPanel.getGraphics();
		g.setColor(Color.BLUE);
		for (int i = 0; i < n; i++) {
			int x = r.nextInt(rightPanel.getWidth());
			int y = r.nextInt(rightPanel.getHeight());

			int rand = r.nextInt(3);
			int width = 0;
			if (rand == 1)
				width = 40;
			else if (rand == 2)
				width = 70;
			else
				width = 80;
			if (x + width > rightPanel.getWidth())
				x -= width;

			if (y + width > rightPanel.getHeight())
				y -= width;

			g.drawOval(x, y, width, width);
			dsCiclre.add(new Circle(new Point(x + width / 2, y + width / 2), width));
		}
	}

	private void veHinhVuong(int n) {
		Random r = new Random();
		Graphics g = rightPanel.getGraphics();
		g.setColor(Color.BLUE);
		for (int i = 0; i < n; i++) {
			int x = r.nextInt(rightPanel.getWidth());
			int y = r.nextInt(rightPanel.getHeight());

			int rand = r.nextInt(3);
			int width = 0;
			if (rand == 1)
				width = 40;
			else if (rand == 2)
				width = 70;
			else
				width = 80;
			if (x + width > rightPanel.getWidth())
				x -= width;

			if (y + width > rightPanel.getHeight())
				y -= width;
			g.drawRect(x, y, width, width);
			dsHinhVuong.add(new HinhVuong(new Point(x + width / 2, y + width / 2), width));
		}
	}

	private int tinhDoanThang(Point p1, Point p2) {
		return (int) (Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
	}

	private boolean checkIntersection() {
		for (Circle c : dsCiclre) {
			Point tamHinhTron = c.getP();
			int r = c.getR();

			for (int i = 0; i < dsHinhVuong.size(); i++) {
				HinhVuong hv = dsHinhVuong.get(i);
				Point tamHV = hv.getP();
				int width = hv.getWidth();
				Point[] dsDinh = new Point[4];
				//Tìm ra 4 đỉnh hình vuông
				dsDinh[0] = new Point(tamHV.x - width / 2, tamHV.y - width / 2);
				dsDinh[1] = new Point(tamHV.x + width / 2, tamHV.y - width / 2);
				dsDinh[2] = new Point(tamHV.x + width / 2, tamHV.y + width / 2);
				dsDinh[3] = new Point(tamHV.x - width / 2, tamHV.y + width / 2);

				int inside = 0, outside = 0;
				int intersec = 0;
				for (int j = 0; j < 4; j++) {
					int len = tinhDoanThang(tamHinhTron, dsDinh[j]);
					if (len < r * r)
						inside++;
					else if (len > r * r)
						outside++;
					else
						intersec++;
				}

				if ((inside > 0 && inside < 4 && outside > 0 && outside < 4) || intersec == 1) {
					System.out.println(inside + " " + outside);
					return true;
				}

				// Đoạn nối 2 tâm
				if (Math.sqrt(tinhDoanThang(tamHinhTron, tamHV)) < width / 2 + r) {
					System.out.println("a");
					return true;
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
		else if (src.equals("Rand Oval")) {
			try {
				int n = Integer.valueOf(txtRandOval.getText());
				if (n < 0)
					throw new Exception("Dữ liệu không hợp lệ");
				txtRandOval.setBackground(Color.white);
				drawCircle(n);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Error: " + e2.getMessage());
				txtRandOval.setBackground(Color.red);
			}

		} else if (src.equals("Rand Rect")) {
			try {
				int n = Integer.valueOf(txtRandRect.getText());
				if (n < 0)
					throw new Exception("Dữ liệu không hợp lệ");
				txtRandRect.setBackground(Color.white);
				veHinhVuong(n);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Error: " + e2.getMessage());
				txtRandRect.setBackground(Color.red);
			}
		} else if (src.equals("Check ?   ")) {
			txtCheck.setText(this.checkIntersection() + "");
		}
	}
}

class HinhVuong {
	private Point p;
	int width;

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public HinhVuong(Point p, int width) {
		super();
		this.p = p;
		this.width = width;
	}

}

class Circle {
	private Point p;
	int r;

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public Circle(Point p, int r) {
		super();
		this.p = p;
		this.r = r;
	}

}
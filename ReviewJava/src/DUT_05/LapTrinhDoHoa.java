package DUT_05;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class LapTrinhDoHoa extends JFrame {

	private static int SCREEN_WIDTH = 500;
	private static int SCREEN_HEIGHT = 500;

	private void initComponents() {
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	public LapTrinhDoHoa() {
		initComponents();
	}

	public static void main(String[] args) {
		new LapTrinhDoHoa();
	}

	double a = 0;
	@Override
	public void paint(Graphics g) {
		// Vẽ lại phông nền
		super.paint(g);
		g.setColor(Color.red);
		g.fillRect(100, 140, 300, 185);

		g.setColor(Color.yellow);
		int xTam = 250, yTam = 240;

		// r1: bán kính đường tròn bao quanh 5 điểm bên ngoài
		double r1 = 80;

		// r2: bán kính đường tròn bao quanh 5 điểm bên trong
		double r2 = (r1 * Math.sin(Math.PI / 10) / Math.sin(Math.PI * 7 / 10));

		int x1[] = new int[10];
		int y1[] = new int[10];

		// Vẽ 5 đỉnh bên trong trước
		for (int i = 0; i < 5; i++) {
			x1[i * 2] = (int) (xTam + r2 * Math.cos(Math.PI / 2 + Math.PI * 2 * i / 5));
			y1[i * 2] = (int) (yTam + r2 * Math.sin(Math.PI / 2 + Math.PI * 2 * i / 5));
		}

		for (int i = 0; i < 5; i++) {
			x1[i * 2 + 1] = (int) (xTam + r1 * Math.cos(Math.PI * 7 / 10 + Math.PI * 2 / 5 * i));
			y1[i * 2 + 1] = (int) (yTam + r1 * Math.sin(Math.PI * 7 / 10 + Math.PI * 2 / 5 * i));
		}

		g.fillPolygon(x1, y1, 10);
		
		try {
			Thread.sleep(100);
			a++;
			this.repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

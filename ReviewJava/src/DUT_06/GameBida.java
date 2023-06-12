package DUT_06;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;

public class GameBida extends JFrame {
	int WIDTH = 400;
	int HEIGHT = 300;
	int OFFSET = 50;
	double masat = 0.001;
	Bi[] balls;
	BufferedImage img;
	Graphics g;

	private void initComponents() {
		this.setSize(WIDTH + 2 * OFFSET, HEIGHT + 2 * OFFSET);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

	}

	public GameBida() {
		initComponents();
		img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = img.getGraphics();
		balls = new Bi[5];
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			int x = r.nextInt(WIDTH);
			int y = r.nextInt(HEIGHT);
			if (x + 2 * 20 >= WIDTH)
				x -= 2 * 20;
			if (y + 2 * 20 >= HEIGHT)
				y -= 2 * 20;
			balls[i] = new Bi(this, x, y, 0.4, 0.5, 20);
			balls[i].start();
		}
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g1) {
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(Color.blue);
		g.fillRect(OFFSET, OFFSET, WIDTH, HEIGHT);
		for (int i = 0; i < 5; i++) {
			g.setColor(Color.yellow);
			g.fillOval((int) (balls[i].x + OFFSET - balls[i].r), (int) (balls[i].y + OFFSET - balls[i].r),
					(int) balls[i].r * 2, (int) balls[i].r * 2);

			g.setColor(Color.black);
			g.drawOval((int) (balls[i].x + OFFSET - balls[i].r), (int) (balls[i].y + OFFSET - balls[i].r),
					(int) balls[i].r * 2, (int) balls[i].r * 2);
		}

		g1.drawImage(img, 0, 0, null);

		this.repaint();
	}

	public static void main(String[] args) {
		new GameBida();
	}
}

class Bi extends Thread {
	GameBida table;
	double x, y;
	double vx;
	double vy;
	double r;

	public Bi(GameBida table, double x, double y, double vx, double vy, double r) {
		super();
		this.table = table;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			x += vx;
			y += vy;

			if (vx < 0 && x - r <= 0)
				vx = -vx;
			if (vx > 0 && x + r >= table.WIDTH)
				vx = -vx;

			if (vy < 0 && y - r <= 0)
				vy = -vy;
			if (vy > 0 && y + r >= table.HEIGHT)
				vy = -vy;

			// Ma sát
			MyVector v = new MyVector(vx, vy);
			double len = v.len();
			if (len > 0) {
				if (len > table.masat)
					len -= table.masat;
				else
					len = 0;
				MyVector new_vt = v.multi(len / v.len());
				vx = new_vt.x;
				vy = new_vt.y;
			}

			// Va chạm giữa 2 bi
			int idx = 0;
			for (int i = 0; i < table.balls.length; i++) {
				if (table.balls[i] == this) {
					idx = i;
					break;
				}
			}
			
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package DUT_07;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class VikingJump extends JFrame implements KeyListener {
	Background bgr;
	Charactor viking;
	Graphics g;
	BufferedImage img;
	int width = 600, height = 360;

	public VikingJump() {
		this.setDefaultCloseOperation(3);
		this.setSize(width, height);

		bgr = new Background();
		bgr.start();
		viking = new Charactor();
		img = new BufferedImage(width, height, 3);
		g = img.getGraphics();

		this.addKeyListener(this);
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g1) {
		bgr.paint(g, 0, 0, this.getWidth(), this.getHeight());
		// cần chỉnh
		viking.paint(g, 150, 200, 80, 100, viking.getStatus());
		g1.drawImage(img, 0, 0, null);
		repaint();
	}

	public static void main(String[] args) {
		new VikingJump();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			viking.setJump();
			if (e.getKeyChar() == 'e')
				viking.exit = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

class Charactor extends Thread {
	BufferedImage img;
	double yc = 0;
	double vc = 0;
	double gc = -0.1;

	private int status = 0;

	public Charactor() {
		try {
			img = ImageIO.read(new File("data/viking.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g, int x, int y, int w, int h, int id) {
		// Thay đổi
		int ix = id % 5;
		int iy = id / 5;
		double widthImg = (img.getWidth() + 30) / 5;
		double heightImg = img.getHeight() / 2;

		g.drawImage(img, x, y - (int) yc, x + w, y - (int) yc + h, (int) (ix * widthImg), (int) (iy * heightImg),
				(int) ((ix + 1) * widthImg), (int) ((iy + 1) * heightImg), null);
	}

	public int getStatus() {
		if (vc > 0) {
			if (yc < 40)
				status = 1;
			else
				status = 2;
		} else {
			if (yc > 40)
				status = 3;
			else
				status = 4;
		}
		return status;
	}

	public void setJump() {
		if (yc == 0)
			vc = 5;
	}

	boolean exit = false;

	@Override
	public void run() {
		while (!exit) {
			yc += vc;
			vc += gc;
			if (yc < 0) {
				yc = 0;
				vc = 0;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Background extends Thread {
	BufferedImage bgr;
	double x1 = 0;
	int y1 = 90, w1 = 180, h1 = 425;

	public Background() {
		try {
			bgr = ImageIO.read(new File("data/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Không phải phương thức override
	public void paint(Graphics g, int x, int y, int w, int h) {
		// 4 tham số cuối là góc trên bên trái và góc dưới bên phải của bức ảnh img gốc,
		// và sẽ đem bức ảnh này bỏ vào HCN đc tạo bởi 4 tham số toạ độ đầu
		// 4 tham số toạ độ đầu là góc trên bên trái và góc dưới bên phải của vị trí sẽ
		// đc vẽ vào
		g.drawImage(bgr, x, y, x + w, y + h, (int) x1, y1, (int) x1 + w1, y1 + h1, null);

	}

	@Override
	public void run() {
		while (x1 + w1 < bgr.getWidth()) {
			x1 += 0.1;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (x1 + w1 >= bgr.getWidth())
				x1 = 50;
		}
	}
}
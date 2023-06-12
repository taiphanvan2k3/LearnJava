package DUT_05;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

/**
 * @author Admin
 * @category Caro Class này học cách làm Caro mà không dùng button
 */
public class Caro extends JFrame implements MouseListener {

	int n = 20;
	private int cell_width = 30;
	int offset = 50;
	List<Point> ds = new ArrayList<>();

	public Caro() {
		this.setSize(n * cell_width + 2 * offset, n * cell_width + 2 * offset);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(Color.black);
		for (int i = 0; i <= n; i++) {
			g.drawLine(offset, offset + i * cell_width, offset + n * cell_width, offset + i * cell_width);
			g.drawLine(offset + i * cell_width, offset, offset + i * cell_width, offset + n * cell_width);
		}

		for (Point point : ds) {

		}
	}

	public static void main(String[] args) {
		new Caro();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + " " + y);
		if (x < offset || x >= offset + n * cell_width)
			return;
		if (x < offset || x >= offset + n * cell_width)
			return;
		int i = (x - offset) / cell_width;
		int j = (y - offset) / cell_width;
		for (Point point : ds) {
			if (point.x == i && point.y == j)
				return;
		}
		ds.add(new Point(i, j));
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}

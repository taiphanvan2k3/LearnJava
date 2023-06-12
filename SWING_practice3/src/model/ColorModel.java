package model;

import java.awt.Color;

public class ColorModel {
	private Color foreground;
	private Color background;
	private boolean opaque;

	public ColorModel() {
		//Mặc định là màu chữ là màu đen, màu nền là màu trắng
		this.foreground = Color.BLACK;
		this.background = Color.WHITE;
		
		//Tô màu đường viền
		this.opaque = true;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public boolean isOpaque() {
		return opaque;
	}

	public void setOpaque(boolean opaque) {
		this.opaque = opaque;
	}

	
	
}

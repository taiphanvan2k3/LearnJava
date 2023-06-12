package flipImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class flipVertical_Horizental {
	public final static int ROTATE_VERTICAL = 1;
	public final static int ROTATE_HORIZENTAL = -1;

	public static void flip(File input, int direction) {
		try {
			BufferedImage image = ImageIO.read(input);
			int width = image.getWidth();
			int height = image.getHeight();
			BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (direction == ROTATE_VERTICAL) {
						flipped.setRGB(x, (height - 1) - y, image.getRGB(x, y));
					} else
						flipped.setRGB((width - 1) - x, y, image.getRGB(x, y));
				}
			}

			String path=input.getPath();
			String extensionOfFile=path.substring(path.lastIndexOf('.')+1);
			ImageIO.write(flipped, extensionOfFile, input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

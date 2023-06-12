package helper;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHelper {
	public static Image resizeImage(Image originalImage, int targetWidth, int targetHeight) {
		Image resImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
		return resImage;
	}

	public static byte[] toByteArray(Image img, String type) throws IOException {
		BufferedImage bfImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = bfImage.createGraphics();
		//Vẽ img lên BufferedImage rồi lấy BufferedImage đó ghi ra ByteArrayOutputStream
		g.drawImage(img, 0, 0, null);
		g.dispose();
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(bfImage, type, byteArrayOutputStream);
		byte[] imageToByte = byteArrayOutputStream.toByteArray();
		return imageToByte;
	}

	public static Image createImageFromByteArray(byte[] array) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(array);
		BufferedImage bfImage = ImageIO.read(bais);
		Image img = bfImage.getScaledInstance(bfImage.getWidth(), bfImage.getHeight(), Image.SCALE_SMOOTH);
		return img;
	}
}

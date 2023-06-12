package flipImage;

import java.io.File;

public class test {
	public static void main(String[] args) {
		File input=new File("data/goku.png");
		flipVertical_Horizental.flip(input,flipVertical_Horizental.ROTATE_HORIZENTAL);
	}
}

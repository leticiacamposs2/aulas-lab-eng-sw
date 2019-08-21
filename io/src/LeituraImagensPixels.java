import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class LeituraImagensPixels {
	public static void main(String[] args) {
		File f = new File("C:/Temp/90831-novo-logotipo-da-google-continua-opengraph_1200-1.jpeg");
		
		try {
			FileInputStream imgIS = new FileInputStream(f);
			BufferedImage img = ImageIO.getImageReader(imgIS);
			WritableRaster raster = img.getRaster();
			int i = 0;
			int count = 0;
			for(int y = 0; y < raster.getHeight(); y++) {
				for(int x = 0; x < raster.getWidth(); x++) {
					double[] pixel = raster.getPixel(x, y, new double[] {});
					System.out.print(Integer.toHexString((int)pixel[0]));
				}
				System.out.println(count++);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

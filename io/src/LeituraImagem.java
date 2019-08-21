import java.io.File;
import java.io.FileInputStream;

public class LeituraImagem {
	public static void main(String[] args) {
		File f = new File("C:/Temp/90831-novo-logotipo-da-google-continua-opengraph_1200-1.jpeg");
		
		try {
			FileInputStream imgIS = new FileInputStream(f);
			int i = 0;
			int count = 0;
			while((i = imgIS.read()) != -1) {
				System.out.print(Integer.toHexString(i));
				count++;
				if (count % 100 == 0) {
					System.out.println();
				}
			}
			System.out.println("Bytes lidos" + count);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

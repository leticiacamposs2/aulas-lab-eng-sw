import java.io.File;
import java.io.FileReader;

public class TesteArquivoLeitura {
	public static void main(String[] args) {
		File f = new File("C:/Temp/teste.txt");
		try {
			FileReader fr = new FileReader(f);
			int i = fr.read();
			System.out.println("Leitura do Caracter: " + (char)i);
			i = fr.read();
			System.out.println("Leitura do Caracter: " + (char)i);
			i = fr.read();
			System.out.println("Leitura do Caracter: " + (char)i);
			i = fr.read();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TesteLeituraObjeto {
	public static void main(String[] args) {
		File f = new File("C:/Temp/tmpnomes.dat");
		
		try {
			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream objIn = new ObjectInputStream(fin);
			String[] o = (String[]) objIn.readObject();
			// faz leitura de imagem == ImageIo.read
			for (String nome: o) {
				System.out.println("Nome: " + nome);
			}
			objIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

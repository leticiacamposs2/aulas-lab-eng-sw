import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteGravacaoObjeto {
	public static void main(String[] args) throws IOException {
		String[] nomes = {"Bruno", "Ludimilla", "Leticia", "Henrique",
				"Victor"};
		
		File f = new File("C:/Temp/tmpnomes.dat");
		
		try {
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream objOut = new ObjectOutputStream(fout);		
			objOut.writeObject(nomes);
			objOut.close();
			System.out.println("Nomes gravados no arquivo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

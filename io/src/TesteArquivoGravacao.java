import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TesteArquivoGravacao {
	public static void main(String[] args) throws IOException {
		System.out.println("Inicio do teste de gravação do arquivo");
		
		//criando um ponteiro para o arquivo
		File f = new File("C:/Temp/teste.txt");
			
		System.out.println(
				String.format("Arquivo %s existe %s", 
						f.getAbsolutePath(), f.exists())
		);
		
		System.out.println(String.format("Pode ler o arquivo: %s", f.canRead()));
		System.out.println(String.format("Pode gravar no arquivo: %s", f.canWrite()));
		System.out.println(String.format("Caminho é de um arquivo ?: %s", f.isFile()));
		System.out.println(String.format("Caminho é uma pasta?: %s", f.isDirectory()));

		//criando um stream de Output para o arquivo, gravando o texto com o caracter stream
		FileWriter fw = new FileWriter(f, true);
				
		//dados para o dispositivo
		fw.write("Hello, World!!\n");

		//envia os dados do buffer/cache pro arquivo
		fw.flush();
		
		//enviando mais dados pro arquivo
		fw.write("Linha 2...\n");
		
		fw.flush();
		
		//fechando o dispositivo
		fw.close();
		
		System.out.println("Fim do programa");
	}
}

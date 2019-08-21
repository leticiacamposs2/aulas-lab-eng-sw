package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;

public class Servidor {

	public static void main(String[] args) {
		try {
			System.out.println("Servidor iniciado..");
			ServerSocket server = new ServerSocket(17777);
			System.out.println("Porta reservada, aguardando comunicação do cliente");
			Socket s = server.accept(); //aqui ele para esperando alguem se comunicar
			OutputStream out = s.getOutputStream();
			byte[] bytes = "Bem Vindo ao Servidor :D\r\n".getBytes();
			out.write( bytes );
			out.flush();
 			Scanner scan = new Scanner(System.in);
 			String texto = "";
 			int i = 0;
 			
 			while(i != 27) {
 				if(System.in.available() > 0) {
 					i = System.in.read();
 					out.write( i );
 					out.flush();
 				}
 				
 				if(System.in.available() < 0) {
 					char c = (char)System.in.read();
 					System.out.println(c);
 				}
 			}
 			
			System.out.println("Cliente conectado.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Servidor finalizado!");
		// pra fazer o teste basta ir no navegador e colocar o IP e a porta, ex: http://192.168.56.1:7777/

		//instalar o telnet no recursos e programa, faz o teste telnet 192.168.56.1 17777
	}

}

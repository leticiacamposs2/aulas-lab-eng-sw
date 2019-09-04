package servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MeuServlet") //toda que vez que for acionada essa URL o servlet sera executado
public class MeuServlet implements Servlet {
	private ServletConfig config;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {//retorna um texto com o nome do servlet
		return "Meu Servlet"; 
	}

	@Override
	public void init(ServletConfig s) throws ServletException { //executado na hora que o servlet é iniciaado
		config = s;
		System.out.println("Servlet iniciado");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Servlet sendo executado");
	}

}

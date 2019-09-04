package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MeuServlet") //toda que vez que for acionada essa URL o servlet sera executado
public class MeuServlet implements Servlet {
	private ServletConfig config;
	private int x;
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
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String n = req.getParameter("NOMEALUNO");
		System.out.println("Parametro recebido NOMEALUNO="+n);

		String numero = req.getParameter("TABUADA");
		System.out.println("Parametro recebido TABUADA="+numero);
		System.out.println("Servlet sendo executado");
			
		PrintWriter out = res.getWriter(); //Com essa inf o que passar aqui o nav mostra na tela
		out.write("<h1>Olá " + n + " como vai você?</h1>");
		out.flush();		
	}

}

package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import dao.ContatoDAOImplementation;
import entidades.Contato;

/**
 * Servlet implementation class ControllerContato
 */
@WebServlet("/ControllerContato")
public class ControllerContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Contato> Contatos;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerContato() {
		super();
	}
	
	@Override
	public void init() { 
		Contatos = (ArrayList<Contato>) this.getServletContext().getAttribute("LISTA_CONTATOS");
		if (Contatos == null ) { 
			Contatos = new ArrayList<Contato>();
			this.getServletContext().setAttribute("LISTA_CONTATOS", Contatos);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String id = request.getParameter("txtId");
		String nome = request.getParameter("txtNome");
		String usuario = request.getParameter("txtUsuario");
		ContatoDAO ContatoDao = new ContatoDAOImplementation();
		if ("Cadastrar".equalsIgnoreCase(cmd)) { 
			Contato ped = new Contato();
			ped.setId( Long.parseLong( id ) );
			ped.setNome ( nome );
			ped.setUsuario( usuario );
			}
		else if ("Pesquisar".equalsIgnoreCase(cmd)) {
			try {
				Contato Contato = ContatoDao.pesquisarPorId( Long.parseLong( id ) );
				request.setAttribute("CONTATO_ATUAL" , Contato );
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("./Contato.jsp");
		rd.forward(request, response);
	}
}

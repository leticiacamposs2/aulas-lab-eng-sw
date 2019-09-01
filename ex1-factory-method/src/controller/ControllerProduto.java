package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.ProdutoDAO;
import dao.ProdutoDAOImplementation;
import entidades.Produto;

/**
 * Servlet implementation class ControllerProduto
 */
@WebServlet("/ControllerProduto")
public class ControllerProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Produto> produtos;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerProduto() {
		super();
	}
	
	@Override
	public void init() { 
		produtos = (ArrayList<Produto>) this.getServletContext().getAttribute("LISTA_PRODUTOS");
		if (produtos == null ) { 
			produtos = new ArrayList<Produto>();
			this.getServletContext().setAttribute("LISTA_PRODUTOS", produtos);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String id = request.getParameter("txtId");
		String nome = request.getParameter("txtNome");
		String validade = request.getParameter("txtValidade");
		ProdutoDAO produtoDao = new ProdutoDAOImplementation();
		if ("Cadastrar".equalsIgnoreCase(cmd)) { 
			Produto prod = new Produto();
			prod.setId( Long.parseLong( id ) );
			prod.setNome ( nome );
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			try {
				prod.setValidade( df.parse( validade ) );
				produtoDao.inserir( prod );
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if ("Pesquisar".equalsIgnoreCase(cmd)) {
			try {
				Produto produto = produtoDao.pesquisarPorId( Long.parseLong( id ) );
				request.setAttribute("PRODUTO_ATUAL" , produto );
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("./produto.jsp");
		rd.forward(request, response);
	}
}

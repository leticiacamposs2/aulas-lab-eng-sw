package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.PedidoDAO;
import dao.PedidoDAOImplementation;
import entidades.Contato;
import entidades.Pedido;
import entidades.Produto;

/**
 * Servlet implementation class ControllerPedido
 */
@WebServlet("/ControllerPedido")
public class ControllerPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Pedido> pedidos;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerPedido() {
		super();
	}
	
	@Override
	public void init() { 
		pedidos = (ArrayList<Pedido>) this.getServletContext().getAttribute("LISTA_PEDIDOS");
		if (pedidos == null ) { 
			pedidos = new ArrayList<Pedido>();
			this.getServletContext().setAttribute("LISTA_PEDIDOS", pedidos);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String id = request.getParameter("txtId");
		Contato contato = request.getParameter("txtContato");
		Produto produto = request.getParameter("txtProduto");
		PedidoDAO pedidoDao = new PedidoDAOImplementation();
		if ("Cadastrar".equalsIgnoreCase(cmd)) { 
			Pedido ped = new Pedido();
			ped.setId( Long.parseLong( id ) );
			ped.setContato ( contato );
			ped.setProdutos( (List<Produto>) produto );
			}
		else if ("Pesquisar".equalsIgnoreCase(cmd)) {
			try {
				Pedido pedido = pedidoDao.pesquisarPorId( Long.parseLong( id ) );
				request.setAttribute("PEDIDO_ATUAL" , pedido );
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("./pedido.jsp");
		rd.forward(request, response);
	}
}

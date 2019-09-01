package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entidades.Contato;
import entidades.Pedido;
import entidades.Produto;

public class PedidoDAOImplementation implements PedidoDAO {

	@Override
	public void inserir(Pedido pedido) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:7702/exercicio1", 
				"root", "root");
		String sql = "INSERT INTO pedidos (id, contato, produtos) VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement( sql );
		pstmt.setLong(1,  pedido.getId() );
		pstmt.setObject(2, pedido.getContato());
		pstmt.setObject(3, pedido.getProdutos());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pedido pesquisarPorId(long id) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:7702/exercicio1", 
													"root", "root");
		String sql = "SELECT  id, contato, produtos FROM pedidos WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement( sql );
		pstmt.setLong(1,  id);
		ResultSet rs = pstmt.executeQuery();
		Pedido pedido = null;
		if (rs.next()) { 
			pedido = new Pedido();
			pedido.setId(  rs.getLong("id")  );
			pedido.setContato( (Contato) rs.getObject("contato"));
			pedido.setProdutos( (List<Produto>) rs.getObject("produtos"));
		}
		return pedido;
	}

}

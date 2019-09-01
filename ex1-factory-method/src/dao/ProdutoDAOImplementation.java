package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Produto;

public class ProdutoDAOImplementation implements ProdutoDAO {

	@Override
	public void inserir(Produto produto) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:7702/exercicio1", 
				"root", "root");
		String sql = "INSERT INTO produtos (id, nome, validade) VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement( sql );
		pstmt.setLong(1,  produto.getId() );
		pstmt.setString(2, produto.getNome());
		pstmt.setDate(3, new java.sql.Date( produto.getValidade().getTime() ));		
	}

	@Override
	public Produto pesquisarPorId(long id) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:7702/exercicio1", 
													"root", "root");
		String sql = "SELECT  id, nome, validade FROM produtos WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement( sql );
		pstmt.setLong(1,  id);
		ResultSet rs = pstmt.executeQuery();
		Produto produto = null;
		if (rs.next()) { 
			produto = new Produto();
			produto.setId(  rs.getLong("id")  );
			produto.setNome( rs.getString("nome") );
			if (rs.getDate("validade") != null ) { 
				produto.setValidade( new java.util.Date( rs.getDate("validade").getTime() ) );
			}
		}
		return produto;
	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Contato;

public class ContatoDAOImplementation implements ContatoDAO {

	@Override
	public void inserir(Contato contato) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:7702/exercicio1", 
				"root", "root");
		String sql = "INSERT INTO contatos (id, nome, usuario, senha) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement( sql );
		pstmt.setLong(1,  contato.getId() );
		pstmt.setString(2, contato.getNome());
		pstmt.setString(3, contato.getUsuario());
		pstmt.setString(4, contato.getSenha());
	}

	@Override
	public Contato pesquisarPorId(long id) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:7702/exercicio1", 
													"root", "root");
		String sql = "SELECT  id, nome, usuario FROM contatos WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement( sql );
		pstmt.setLong(1,  id);
		ResultSet rs = pstmt.executeQuery();
		Contato contato = null;
		if (rs.next()) { 
			contato = new Contato();
			contato.setId(  rs.getLong("id")  );
			contato.setNome( rs.getString("nome") );
			contato.setUsuario( rs.getString("usuario") );
		}
		return contato;
	}

}

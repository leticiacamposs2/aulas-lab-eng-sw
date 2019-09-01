package dao;

import java.sql.SQLException;

import entidades.Produto;

public interface ProdutoDAO {
	public void inserir( Produto produto ) throws SQLException;
	public Produto pesquisarPorId( long id ) throws SQLException;
}
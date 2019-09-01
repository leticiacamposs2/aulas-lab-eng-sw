package dao;

import java.sql.SQLException;

import entidades.Contato;

public interface ContatoDAO {
	public void inserir( Contato contato ) throws SQLException;
	public Contato pesquisarPorId( long id ) throws SQLException;

}

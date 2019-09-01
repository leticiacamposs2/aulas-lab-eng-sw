package dao;

import java.sql.SQLException;

import entidades.Pedido;

public interface PedidoDAO {
	public void inserir( Pedido pedido ) throws SQLException;
	public Pedido pesquisarPorId( long id ) throws SQLException;

}

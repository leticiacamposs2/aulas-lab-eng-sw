<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Pedido, entidades.Contato" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% 	Pedido pedido = (Pedido) request.getAttribute("PEDIDO_ATUAL");

  	if( pedido == null) { 
		pedido = new Pedido();
		pedido.setContato( new Contato() );
   	}
   
%>

<body>
	<h1>Gestão de Pedidos</h1>
	<form action="./ControllerPedido" method="POST">
		<table>
			<tr>
				<td>Id :</td>
				<td><input name="txtId" value="<%=pedido.getId()%>"></td>
			</tr>
			<tr>
				<td>Contato :</td>
				<td><input name="txtContato" value="<%=pedido.getContato()%>"></td>
			</tr>
				<td><input type="submit" name="cmd" value="Cadastrar"></td>
				<td><input type="submit" name="cmd" value="Pesquisar">
				</td>
			</tr>
		</table>
	</form>
	<% List<pedido> pedidos = (List<pedido>)request.getAttribute("PEDIDOS"); 
	   if (pedidos != null && pedidos.size() > 0) { 
	%>
	<h2>Lista de pedidos</h2>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Contato</td>
		</tr>
		<% for (pedido ped : pedidos) {  %>
			<tr>
				<td><%=ped.getId()%></td>
				<td><%=ped.getContato()%></td>
			</tr>
		<% } %>
		
	</table>
	
	<% } %>
</body>
</html>
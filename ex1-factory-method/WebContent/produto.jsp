<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Produto" %>
<%@ page import="java.text.DateFormat, java.text.SimpleDateFormat, java.util.Date, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% 	Produto produto = (Produto) request.getAttribute("PRODUTO_ATUAL");
	DateFormat df = new SimpleDateFormat("dd/MM/YYYY");

  	if( produto == null) { 
		produto = new Produto();
		produto.setValidade( new Date() );
   	}
   
%>

<body>
	<h1>Gestão do Produto</h1>
	<form action="./ControllerProduto" method="POST">
		<table>
			<tr>
				<td>Id :</td>
				<td><input name="txtId" value="<%=produto.getId()%>"></td>
			</tr>
			<tr>
				<td>Nome :</td>
				<td><input name="txtNome" value="<%=produto.getNome()%>"></td>
			</tr>
			<tr>
				<td>Garantia Expira em :</td>
				<td><input name="txtValidade" value="<%=df.format(produto.getValidade())%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="cmd" value="Cadastrar"></td>
				<td><input type="submit" name="cmd" value="Pesquisar">
				</td>
			</tr>
		</table>
	</form>
	<% List<Produto> produtos = (List<Produto>)request.getAttribute("PRODUTOS"); 
	   if (produtos != null && produtos.size() > 0) { 
	%>
	<h2>Lista de Produtos</h2>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Validade</td>
		</tr>
		<% for (Produto p : produtos) {  %>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getNome()%></td>
				<td><%=df.format(p.getValidade())%></td>
			</tr>
		<% } %>
		
	</table>
	
	<% } %>
</body>
</html>
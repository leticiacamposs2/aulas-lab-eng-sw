<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Contato" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% 	Contato contato = (Contato) request.getAttribute("CONTATO_ATUAL");

  	if( contato == null) { 
		contato = new Contato();
   	}
   
%>

<body>
	<h1>Gestão de contatos</h1>
	<form action="./ControllerContato" method="POST">
		<table>
			<tr>
				<td>Id :</td>
				<td><input name="txtId" value="<%=contato.getId()%>"></td>
			</tr>
			<tr>
				<td>Nome :</td>
				<td><input name="txtNome" value="<%=contato.getNome()%>"></td>
			</tr>
			<tr>
				<td>Usuario :</td>
				<td><input name="txtUsuario" value="<%=contato.getUsuario()%>"></td>
			</tr>
				<td><input type="submit" name="cmd" value="Cadastrar"></td>
				<td><input type="submit" name="cmd" value="Pesquisar">
				</td>
			</tr>
		</table>
	</form>
	<% List<Contato> contatos = (List<Contato>)request.getAttribute("CONTATOS"); 
	   if (contatos != null && contatos.size() > 0) { 
	%>
	<h2>Lista de contatos</h2>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Usuario</td>
		</tr>
		<% for (Contato cont : contatos) {  %>
			<tr>
				<td><%=cont.getId()%></td>
				<td><%=cont.getNome()%></td>
				<td><%=cont.getUsuario()%></td>
			</tr>
		<% } %>
		
	</table>
	
	<% } %>
</body>
</html>
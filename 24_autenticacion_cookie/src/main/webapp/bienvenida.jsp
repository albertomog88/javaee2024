<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Ficha"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<a href="Desconectar">Desconectar</a> (borrar la cookie usuario)
</center>
	<%--
		recuperamos el atributo de petición ficha, y mostramos sus datos
	 --%>
	<%Ficha ficha=(Ficha)request.getAttribute("ficha"); %>
	<h2>Usuario: <%=ficha.getUsuario()%></h2>
	<h2>Email: <%=ficha.getEmail()%></h2>
	<h2>Edad: <%=ficha.getEdad()%></h2>
	
	<a href="login.html">Volver</a>
</body>
</html>
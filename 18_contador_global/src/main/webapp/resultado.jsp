<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int contador=(Integer)session.getAttribute("contador");
	int global=(Integer)application.getAttribute("global");%>
	<center>
		<h1>Has entrado <%=contador%> veces</h1>
		<h2>Total de visitantes <%=global%> </h2>
		<br>
		<a href="entrada.html">Volver</a>
	</center>
</body>
</html>
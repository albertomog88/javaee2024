<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<center>
		<h1>Has entrado ${sessionScope.contador} veces</h1>
		<h2>Total de visitantes ${applicationScope.global} </h2>
		<br>
		<a href="entrada.html">Volver</a>
	</center>
</body>
</html>
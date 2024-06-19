<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Bienvenido a mi página <%=request.getParameter("username")%></h2>
	<a href="login.html">Volver</a>
</body>
</html>
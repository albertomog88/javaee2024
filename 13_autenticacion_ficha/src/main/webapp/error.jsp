<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>El usuario <%=request.getParameter("username")%></h2>
	<h2> con contraseña <%=request.getParameter("password") %>  no es válido</h2>
	<a href="login.html">Volver</a>
</body>
</html>
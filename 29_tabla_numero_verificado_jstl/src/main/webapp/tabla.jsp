<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		
		<h1>Tabla del ${param.numero}</h1>
		<table border="1">
			<c:forEach var="i" begin="1" end="10" step="1">
				<tr>
					<td>${param.numero}X${i}</td>
					<td>${param.numero*i}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="numero.html">Volver</a>
	</center>
</body>
</html>
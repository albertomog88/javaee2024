<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Curso,java.util.ArrayList"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Cursos cuyo precio máximo es ${param.precio}</h1>
		<br>
		<c:if test="${!empty requestScope.cursos}">
			<table border="1">
				<tr>
					<th>Nombre</th>
					<th>Duración</th>
					<th>Precio</th>
				</tr>
				<%--recuperamos el arraylist de cursos que está en un atributo de petición,
				lo recorremos y mostramos una fila por cada curso --%>
				<c:forEach var="c" items="${requestScope.cursos}">
					<tr>
						<td>${c.nombre}</td>
						<td>${c.duracion}</td>
						<td>${c.precio}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty requestScope.cursos}">
			<h1>No hay cursos con ese criterio</h1>
		</c:if>
		<br>
		<a href="FrontController?operation=toMenu">volver</a>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="FrontController?operation=doCerrar">Cerrar sesión</a>
	<center>
		<c:choose>
			<c:when test="${not empty sessionScope.carrito}">
				<table border="1">
				
					<tr><th>Nombre</th><th>Precio</th><th>Categoria</th><th></th></tr>
					<c:forEach var="pr" items="${sessionScope.carrito}">
						<tr>
							<td>${pr.nombre}</td>
							<td>${pr.precio}</td>
							<td>${pr.categoria}</td>
							<td><a href="FrontController?operation=doEliminar&nombre=${pr.nombre}">Eliminar</a></td>
						</tr>
					
					</c:forEach>
				
				</table>
				
			
			</c:when>
			<c:otherwise>
				<h1>El carrito está vacío</h1>
			</c:otherwise>
		</c:choose>
		<br><br>
		<a href="FrontController?operation=toMenu">volver</a>
	</center>
</body>
</html>
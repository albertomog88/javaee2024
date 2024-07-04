<!DOCTYPE html>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de productos por categoría</title>
<style type="text/css">
body {
	color: purple;
}

h1 {
	text-align: center;
}

div {
	width: 400px;
	margin: 50px auto;
	padding: 15px;
	background-color: smocke;
	border: 1px solid purple; input { display : block;
	margin-bottom: 15px;
}

input {
	color: purple;
	margin: 0 auto;
	display: block;
	margin-bottom: 15px;
	border: 1px solid purple;
	padding: 7px;
	display: block;
}}
</style>
</head>
<body bgcolor="green">
	<div>
		<h1>Buscar resultado</h1>
		<form action="FrontController?operation=doBuscarResultados" method="post">
			Tematica: <input type="text" name="tematica"><br>
			 <input type="submit" value="Buscar">
		</form>
		<br><br>
		<c:forEach var="r" items="${requestScope.resultados}">
			<h2><a href="${r.url}">${r.url}</a></h2>
			<h4>${r.descripcion}</h4>
			<hr>		
		</c:forEach>
		<br>
		<a href="FrontController?operation=toInicio">Volver</a>
	</div>
</body>
</html> 
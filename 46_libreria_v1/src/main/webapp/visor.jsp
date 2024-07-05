<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<center>
		Seleccione Tema:
		<select id="temaSel" >
			<option value="0">-Todos-</option>
			<c:forEach var="t" items="${requestScope.temas}">
				<option value="${t.idTema}">${t.tema}</option>
			</c:forEach>
		</select>
		<br><br>
		<div id="tbLibros">
		
		</div>
	</center>
	<script type="text/javascript">
		$("#temaSel").change(function(){
			var url="FrontController";
			var params={"operation":"doLibros","idTema":$("#temaSel").val()};
			gestionarPeticion(url,params);
		});
	
	function gestionarPeticion(url,params){
		$.get(url,params,function(data){
			var tabla="<table border='1'><tr><th>Titulo</th><th>Precio</th><th>Páginas</th></tr>";
			$.each(data,function(i,p){
				tabla+="<tr><td>"+p.titulo+"</td><td>"+p.precio+"</td><td>"+p.paginas+"</td></tr>";
			});
			tabla+="</table>";
			$("#tbLibros").html(tabla);
		});
	}
		
	
	</script>
</body>
</html>
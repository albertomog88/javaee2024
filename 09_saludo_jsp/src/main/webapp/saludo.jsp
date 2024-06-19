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
		<%for(int i=1;i<=6;i++){ %>
			<h<%=i%>>Primera JSP</h<%=i%>>
		
		<%}%>
	</center>
</body>
</html>
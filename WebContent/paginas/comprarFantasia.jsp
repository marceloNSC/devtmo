<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${empty lista}">
		<center>
			<p>N�o existe fantasia para exibir.</p>
		</center>
	</c:if>

	<c:forEach items="${lista}" var="lista">
		<span style="width: 80; height: 50;"> <img alt="" src=""
			width="60" height="120">
			<p>${lista.nomeFantasia}</p>
			<p>${lista.pesoFantasia }</p>
			<p>$ R: 523,00</p> <a href="fantasia/comprar/?p=${lista.idFantasia}">Detalhes</a>		
		</span>
	</c:forEach>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Divisiones</title>
</head>
<body>
	<h2>Divisiones</h2>
	<p>${rol}
	<c:forEach var="l" items="${listaDivision}">
		<p><a href="subdivision.do?division=${l.iddivision}">${l.division}</a>
		<c:if test="${rol == 'admin'}">
			<form method="post" action="eliminarDivision.do">
				<input type="submit" name="eliminar${l.iddivision}" value="Eliminar">
			</form>
		</c:if>
	</c:forEach>
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarDivision.do">
			<input type="text" name="nuevaDivision">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
</html>
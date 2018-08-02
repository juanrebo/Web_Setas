<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filos</title>
</head>
<body>
	<h2>Filos</h2>
	<p>${rol}
	Fungi >
	<c:forEach var="l" items="${listaFilo}">
		<p><a href="clase.do?filo=${l.filo}">${l.filo}</a>
		<c:if test="${rol == 'admin'}">
			<form method="post" action="modificarFilo.do">
				<input type="text" name="modificar${l.filo}">
				<input type="submit" value="modificar">
			</form>
			<form method="post" action="eliminarFilo.do">
				<input type="submit" name="eliminar${l.filo}" value="Eliminar">
			</form>
		</c:if>
		</p>
	</c:forEach>
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarFilo.do">
			<input type="text" name="nuevoFilo">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
</html>
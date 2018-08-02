<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Órdenes</title>
</head>
<body>
<h2>Clases</h2>
	<p>${rol}</p>
	<a href="filo.do">Fungi</a> > <a href="clase.do?filo=${filo.filo}">${filo.filo}</a> > ${clase.clase}
	<c:forEach var="l" items="${listaOrden}">
		<p><a href="familia.do?orden=${l.orden}">${l.orden}</a>
		<c:if test="${rol == 'admin'}">
			<form method="post" action="modificarOrden.do">
				<input type="text" name="modificar${l.orden}">
				<input type="submit" value="modificar">
			</form>
			<form method="post" action="eliminarOrden.do">
				<input type="submit" name="eliminar${l.orden}" value="Eliminar">
			</form>
		</c:if>
	</c:forEach>
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarOrden.do">
			<input type="text" name="nuevoOrden">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
</html>
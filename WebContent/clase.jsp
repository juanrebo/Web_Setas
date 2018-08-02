<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clases</title>
</head>
<body>
	<h2>Clases</h2>
	<p>${rol}</p>
	<a href="filo.do">Fungi</a> > ${filo.filo} >
	<c:forEach var="l" items="${listaClase}">
		<p><a href="orden.do?clase=${l.clase}">${l.clase}</a>
		<c:if test="${rol == 'admin'}">
			<form method="post" action="modificarClase.do">
				<input type="text" name="modificar${l.clase}">
				<input type="submit" value="modificar">
			</form>
			<form method="post" action="eliminarClase.do">
				<input type="submit" name="eliminar${l.clase}" value="Eliminar">
			</form>
		</c:if>
	</c:forEach>
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarClase.do">
			<input type="text" name="nuevaClase">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
</html>
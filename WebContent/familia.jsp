<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Familias</title>
</head>
<body>
<h2>Familias</h2>
	<p>${rol}</p>
	<a href="filo.do">Fungi</a> > <a href="clase.do?filo=${filo.filo}">${filo.filo}</a> > <a href="orden.do?clase=${clase.clase}">${clase.clase} > </a>${famlia.familia}
	<c:forEach var="l" items="${listaFamilia}">
		<p><a href="genero.do?familia=${l.familia}">${l.familia}</a>
		<c:if test="${rol == 'admin'}">
			<form method="post" action="modificarFamilia.do">
				<input type="text" name="modificar${l.familia}">
				<input type="submit" value="modificar">
			</form>
			<form method="post" action="eliminarFamilia.do">
				<input type="submit" name="eliminar${l.familia}" value="Eliminar">
			</form>
		</c:if>
	</c:forEach>
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarFamilia.do">
			<input type="text" name="nuevaFamilia">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
</html>
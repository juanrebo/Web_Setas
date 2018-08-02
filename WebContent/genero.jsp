<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Géneros</title>
</head>
<body>
	<h2>Géneros</h2>
	<a href="filo.do">Fungi</a> > 
	<a href="clase.do?filo=${filo.filo}">${filo.filo}</a> > 
	<a href="orden.do?clase=${clase.clase}">${clase.clase}</a> > 
	<a href="familia.do?orden=${orden.orden}">${orden.orden}</a> >
	${genero.genero}
	<c:forEach var="l" items="${listaGenero}">
		<p><a href="especie.do?genero=${l.genero}">${l.genero}</a>
		<c:if test="${rol == 'admin'}">
			<form method="post" action="modificarGenero.do">
				<input type="text" name="modificar${l.genero}">
				<input type="submit" value="modificar">
			</form>
			<form method="post" action="eliminarGenero.do">
				<input type="submit" name="eliminar${l.genero}" value="Eliminar">
			</form>
		</c:if>
		</p>
	</c:forEach>
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarGenero.do">
			<input type="text" name="nuevoGenero">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
</html>
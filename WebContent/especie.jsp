<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Especies</title>
</head>
<body>
	<h2>Especies</h2>
	<a href="filo.do">Fungi</a> > 
	<a href="clase.do?filo=${filo.filo}">${filo.filo}</a> > 
	<a href="orden.do?clase=${clase.clase}">${clase.clase}</a> > 
	<a href="familia.do?orden=${orden.orden}">${orden.orden}</a> >
	<a href="genero.do?familia=${familia.familia}">${familia.familia}</a> >
	${genero.genero}
	<c:forEach var="l" items="${listaSeta}">
		<p><a href="especie.do?genero=${genero}&especie=${l.especie}">${l.especie}</a>
		<c:if test="${rol == 'admin'}">
			<form method="post" action="modificarEspecie.do">
				<input type="text" name="modificar${l.especie}">
				<input type="submit" value="modificar">
			</form>
			<form method="post" action="eliminarEspecie.do">
				<input type="submit" name="eliminar${l.especie}" value="Eliminar">
			</form>
		</c:if>
		</p>
	</c:forEach>
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarEspecie.do">
			<input type="text" name="nuevaEspecie">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
</html>
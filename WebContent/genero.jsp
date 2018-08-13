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
	<p>${rol}</p>
	
	<div class="atajosClasificacion">
		<p><a href="filo.do" class="clasificacionAtajo">Fungi</a> > 
		<a href="clase.do?filo=${filo.filo}" class="clasificacionAtajo">${filo.filo}</a> > 
		<a href="orden.do?clase=${clase.clase}" class="clasificacionAtajo">${clase.clase}</a> > 
		<a href="familia.do?orden=${orden.orden}" class="clasificacionAtajo">${orden.orden}</a> >
		<span class="clasificacionAtajoActivo">${familia.familia}</span>
	</div>
	
	<c:forEach var="l" items="${listaGenero}">
		<div class="clasificacion">
			<a href="especie.do?genero=${l.genero}" class="enlaceClasificacion">${l.genero}</a>
			<c:if test="${rol == 'admin'}">
				<form method="post" action="modificarGenero.do">
					<input type="text" name="modificar${l.genero}">
					<input type="submit" value="modificar">
				</form>
				<form method="post" action="eliminarGenero.do">
					<input type="submit" name="eliminar${l.genero}" value="Eliminar">
				</form>
			</c:if>
		</div>
		<p>
	</c:forEach>
	
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarGenero.do">
			<input type="text" name="nuevoGenero">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
<link rel="stylesheet" href="css/Web_Setas.css">
</html>
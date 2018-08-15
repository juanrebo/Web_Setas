<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>�rdenes</title>
</head>
<body>
	<h2>�rdenes</h2>
	<p>${sessionScope.usuario.nombre}
	<p>${sessionScope.rol.rol}
	
	<div class="atajosClasificacion">
		<p><a href="filo.do" class="clasificacionAtajo">Fungi</a> > 
		<a href="clase.do?filo=${filo.filo}" class="clasificacionAtajo">${filo.filo}</a> > 
		<span class="clasificacionAtajoActivo">${clase.clase}</span>
	</div>
	
	<c:forEach var="l" items="${listaOrden}">
		<div class="clasificacion">
			<a href="familia.do?orden=${l.orden}" class="enlaceClasificacion">${l.orden}</a>
			<c:if test="${sessionScope.rol.rol == 'admin'}">
				<form method="post" action="modificarOrden.do">
					<input type="text" name="modificar${l.orden}">
					<input type="submit" value="modificar">
				</form>
				<form method="post" action="eliminarOrden.do">
					<input type="submit" name="eliminar${l.orden}" value="Eliminar">
				</form>
			</c:if>
		</div>
		<p>
	</c:forEach>
	
	<c:if test="${sessionScope.rol.rol == 'admin'}">
		<form method="post" action="insertarOrden.do">
			<input type="text" name="nuevoOrden">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
<link rel="stylesheet" href="css/Web_Setas.css">
</html>
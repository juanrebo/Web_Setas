<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas.css">
	<link rel="stylesheet" href="css/Clasificaciones.css">
	<title>Órdenes</title>
</head>
<body>
	<div class="encabezado">
		<div class="nombre">
			<a href="Inicio.jsp">micoPedia</a>
		</div>
		<div class="registro">
		<c:choose>
		<c:when test="${sessionScope.usuario eq null}">
		<div class="botonEncabezado">
			<a href="registro.html">REGISTRO</a>
		</div>	    
		<div class="botonEncabezado">
			<a href="login.html">INICIAR SESIÓN</a>
		</div>
		</c:when>
		<c:otherwise>
		<div class="sesionIniciada">
			<div class="botonEncabezado">
				<a href="cerrarSesion.do">CERRAR SESIÓN</a>
			</div>
			<div class="nombreUsuario">
				${sessionScope.usuario.nombre}
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
	
	<h1>Clasificación</h1>
	
	<div class="cuerpo">
		<h2>Órdenes</h2>
		
		<div class="atajosClasificacion">
			<p><a href="filo.do" class="clasificacionAtajo">Fungi</a> > 
			<a href="clase.do?filo=${filo.filo}" class="clasificacionAtajo">${filo.filo}</a> > 
			<span class="clasificacionAtajoActivo">${clase.clase}</span>
		</div>
		
		<div class="clasificaciones">
			<c:forEach var="l" items="${listaOrden}">
			<div class="clasificacion">
				<a href="familia.do?orden=${l.orden}" class="enlaceClasificacion">${l.orden}</a>
				<c:if test="${sessionScope.rol.rol == 'admin'}">
				<form method="post" action="modificarOrden.do">
					<input type="text" name="modificar${l.orden}">
					<input type="submit" value="MODIFICAR">
				</form>
				<form method="post" action="eliminarOrden.do">
					<input type="submit" name="eliminar${l.orden}" value="ELIMINAR">
				</form>
				</c:if>
			</div>
			<p>
			</c:forEach>
		
			<c:if test="${sessionScope.rol.rol == 'admin'}">
			<form method="post" action="insertarOrden.do">
				<input type="text" name="nuevoOrden">
				<input type="submit" value="AÑADIR">
			</form>
			</c:if>
		</div>
	</div>
</body>
</html>
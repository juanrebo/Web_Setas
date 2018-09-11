<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas.css">
	<link rel="stylesheet" href="css/Clasificaciones.css">
	<title>Géneros</title>
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
		<h2>Géneros</h2>
		
		<div class="atajosClasificacion">
			<p><a href="filo.do" class="clasificacionAtajo">Fungi</a> > 
			<a href="clase.do?filo=${filo.filo}" class="clasificacionAtajo">${filo.filo}</a> > 
			<a href="orden.do?clase=${clase.clase}" class="clasificacionAtajo">${clase.clase}</a> > 
			<a href="familia.do?orden=${orden.orden}" class="clasificacionAtajo">${orden.orden}</a> >
			<span class="clasificacionAtajoActivo">${familia.familia}</span>
		</div>
		
		<div class="clasificaciones">
			<c:forEach var="l" items="${listaGenero}">
			<div class="clasificacion">
				<a href="especie.do?genero=${l.genero}" class="enlaceClasificacion">${l.genero}</a>
				<c:if test="${sessionScope.rol.rol == 'admin'}">
				<form method="post" action="modificarGenero.do">
					<input type="hidden" name="actual" value="${l.genero}">
					<input type="text" name="nuevo">
					<input type="submit" value="MODIFICAR">
				</form>
				<form method="post" action="eliminarGenero.do">
					<input type="hidden" name="actual" value="${l.genero}">
					<input type="submit" value="ELIMINAR">
				</form>
				</c:if>
			</div>
			<p>
			</c:forEach>
		
			<c:if test="${sessionScope.rol.rol == 'admin'}">
			<form method="post" action="insertarGenero.do">
				<input type="text" name="nuevoGenero">
				<input type="submit" value="AÑADIR">
			</form>
			</c:if>
		</div>
	</div>
</body>
</html>
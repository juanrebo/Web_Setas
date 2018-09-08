<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas.css">
	<link rel="stylesheet" href="css/Clasificaciones.css">
	<title>Filos</title>
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
		<h2>Filos</h2>
		
		<div class="atajosClasificacion">
			<p><span class="clasificacionAtajoActivo">Fungi</span>
		</div>
		
		<div class="clasificaciones">
			<c:forEach var="l" items="${listaFilo}">
			<div class="clasificacion">
				<a href="clase.do?filo=${l.filo}" class="enlaceClasificacion">${l.filo}</a>
				<c:if test="${sessionScope.rol.rol == 'admin'}">
				<form method="post" action="modificarFilo.do">
					<input type="hidden" name="actual" value="${l.filo}">
					<input type="text" name="nuevo">
					<input type="submit" value="MODIFICAR">
				</form>
				<form method="post" action="eliminarFilo.do">
					<input type="hidden" name="actual" value="${l.filo}">
					<input type="submit" value="ELIMINAR">
				</form>
				</c:if>
			</div>
			<p>
			</c:forEach>
			
			<c:if test="${sessionScope.rol.rol == 'admin'}">
			<form method="post" action="insertarFilo.do">
				<input type="text" name="nuevoFilo">
				<input type="submit" value="AÑADIR">
			</form>
			</c:if>
		</div>
	</div>
</body>
</html>
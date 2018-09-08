<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Error.css">
	<title>Error</title>
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
	<h1>Error</h1>
	
	<div class="cuerpo">
	<c:choose>
		<c:when test="${error.toString().contains('Duplicate entry')}">
		<p>Entrada duplicada</p>
		</c:when>
		
		<c:otherwise>
		<p>${error}</p>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>
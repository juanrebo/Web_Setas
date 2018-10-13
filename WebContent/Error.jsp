<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas_Azul.css">
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
				<a href="registro.jsp">REGISTRO</a>
			</div>	    
			<div class="botonEncabezado">
				<a href="login.jsp">INICIAR SESIÓN</a>
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
			<c:if test="${error.toString().contains('nombre')}">
			<p>Nombre ya existente</p>
			<p>${error}</p>
			</c:if>
			<c:if test="${error.toString().contains('email')}">
			<p>Email ya empleado</p>
			<p>${error}</p>
			</c:if>
		</c:when>
		<c:when test="${error.toString().contains('Data too long')}">
			<p>La entrada supera la longitud permitida</p>
			<p>${error}</p>
		</c:when>
		<c:otherwise>
		<p>${error}</p>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>
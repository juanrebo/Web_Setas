<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas.css">
	<title>Inicio</title>
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
				<a href="cerrarSesion.do">Cerrar sesión</a>
			</div>
			<div class="nombreUsuario">
				${sessionScope.usuario.nombre}
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
	
	<div class="menu">
		<div class="botonMenu">
	    	<a href="verSetas.do">SETAS</a>
	    </div>
	    <div class="botonMenu">
	    	<a href="filo.do">CLASIFICACIONES</a>
	    </div>
	    
		<c:choose>
		<c:when test="${sessionScope.rol.rol eq 'user'}">
		<div class="botonMenu">
			<a>FAVORITOS</a>
		</div>
		<div class="botonMenu">
			<a>LOCALIZACIONES</a>
		</div>
		<div class="botonMenu">
			<a>MAPA</a>
		</div>
		</c:when>
		<c:when test="${sessionScope.rol.rol eq 'admin'}">
		<div class="botonMenu">
			<a href="insertarSeta.do">INSERTAR SETAS</a>
		</div>
		<div class="botonMenu">
			<a href="editarSeta.do">EDITAR SETAS</a>
		</div>
		</c:when>
		<c:otherwise>
		<div class="botonMenuDesactivado">
			<a>FAVORITOS</a>
		</div>
		<div class="botonMenuDesactivado">
			<a>LOCALIZACIONES</a>
		</div>
		<div class="botonMenuDesactivado">
			<a>MAPA</a>
		</div>
		</c:otherwise>
		</c:choose>		
    </div>
</body>
</html>
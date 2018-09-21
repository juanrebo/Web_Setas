<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas_Azul.css">
	<link rel="stylesheet" href="css/Clasificaciones.css">
	<c:if test="${rol.rol == 'admin'}">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="js/eliminarClas.js"></script>
	</c:if>
	<title>Clases</title>
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
			<a href="login.jsp">INICIAR SESI�N</a>
		</div>
		</c:when>
		<c:otherwise>
		<div class="sesionIniciada">
			<div class="nombreUsuario">
				Hola, ${sessionScope.usuario.nombre}
			</div>
			<div class="botonEncabezado">
				<a href="cerrarSesion.do">CERRAR SESI�N</a>
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
	
	<h1>Clasificaci�n</h1>
	
	<div class="cuerpo">
		<h2>Clases</h2>
		
		<div class="atajosClasificacion">
			<p><a href="filo.do" class="clasificacionAtajo">Fungi</a> > 
			<span class="clasificacionAtajoActivo">${filo.filo}</span>
		</div>
		
		<div class="clasificaciones">
			<c:set var="n" value="0"/>
			<c:forEach var="l" items="${listaClase}">
			<div class="clasificacion">
				<a href="orden.do?clase=${l.clase}" class="enlaceClasificacion">${l.clase}</a>
				<c:if test="${sessionScope.rol.rol == 'admin'}">
				<form method="post" action="modificarClase.do">
					<input type="hidden" name="actual" value="${l.clase}">
					<input type="text" name="nuevo">
					<input type="submit" value="MODIFICAR">
				</form>
				<form method="post" id="eliminar${n}" class="eliminar" action="eliminarClase.do">
					<input type="hidden" name="actual" value="${l.clase}">
				</form>
				<button class="borrar" onclick="eliminarClas(${n})">ELIMINAR</button>
				<c:set var="n" value="${n+1}"/>
				</c:if>
			</div>
			<p>
			</c:forEach>
		
			<c:if test="${sessionScope.rol.rol == 'admin'}">
			<form method="post" action="insertarClase.do">
				<input type="text" name="nuevaClase">
				<input type="submit" value="A�ADIR">
			</form>
			</c:if>
		</div>
	</div>
</body>
</html>
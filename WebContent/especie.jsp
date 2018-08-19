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
			<a href="login.html">INICIAR SESI�N</a>
		</div>
		</c:when>
		<c:otherwise>
		<div class="sesionIniciada">
			<div class="botonEncabezado">
				<a href="cerrarSesion.do">Cerrar sesi�n</a>
			</div>
			<div class="nombreUsuario">
				${sessionScope.usuario.nombre}
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
	
	<h2>Especies</h2>
	
	<div class="atajosClasificacion">
		<p><a href="filo.do" class="clasificacionAtajo">Fungi</a> > 
		<a href="clase.do?filo=${filo.filo}" class="clasificacionAtajo">${filo.filo}</a> > 
		<a href="orden.do?clase=${clase.clase}" class="clasificacionAtajo">${clase.clase}</a> > 
		<a href="familia.do?orden=${orden.orden}" class="clasificacionAtajo">${orden.orden}</a> >
		<a href="genero.do?familia=${familia.familia}" class="clasificacionAtajo">${familia.familia}</a> >
		<span class="clasificacionAtajoActivo">${genero.genero}</span>
	</div>
	
	<c:forEach var="l" items="${listaSeta}">
		<div class="clasificacion">
			<a href="seta.do?genero=${genero.genero}&especie=${l.especie}" class="enlaceClasificacion">${l.especie}</a>
			<c:if test="${sessionScope.rol.rol == 'admin'}">
				<form method="post" action="modificarEspecie.do">
					<input type="text" name="modificar${l.especie}">
					<input type="submit" value="modificar">
				</form>
				<form method="post" action="eliminarEspecie.do">
					<input type="submit" name="eliminar${l.especie}" value="Eliminar">
				</form>
			</c:if>
		</div>
		<p>
	</c:forEach>
	
	<c:if test="${sessionScope.rol.rol == 'admin'}">
		<form method="post" action="insertarEspecie.do">
			<input type="text" name="nuevaEspecie">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
<link rel="stylesheet" href="css/Web_Setas.css">
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mapa</title>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.3/dist/leaflet.css"
   integrity="sha512-Rksm5RenBEKSKFjgI3a41vrjkw4EVPlJ3+OiI65vTjIdo9brlAacEuKOiQ5OFh7cOI1bkDwLqdLw3Zg0cRJAAQ=="
   crossorigin=""/>
<script src="https://unpkg.com/leaflet@1.3.3/dist/leaflet.js"
   integrity="sha512-tAGcCfR4Sc5ZP5ZoVz0quoZDYX5aCtEm/eu1KhSLj2c9eFrylXZknQYmxUssFaVJKvvc0dJQixhGjG2yXWiV9Q=="
   crossorigin=""></script>
<script src="js/localizacion.js"></script>
	<link rel="stylesheet" href="css/Web_Setas.css">
	<link rel="stylesheet" href="css/Mapa.css">
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
	
	<div class="mapa">
 		<div id="mapid" style="height: 500px"></div>
	 	<br/>
	 	<form id="nuevoPunto" action="insertarLocalizacion.do">
	 		<select type="select" form="nuevoPunto">
	 			<c:forEach var="s" items="${sessionScope.todasSetas}">
	 			<option value="${s.idseta}">${s.genero.genero} ${s.especie}</option>
	 			</c:forEach>
	 		</select>
	 		<input type="hidden" id="coords">
	 		<input type="radio" id="coordsUsu" name="centroCoords" value="" checked="checked">Ubicación usuario
	 		<input type="radio" id="coordsMap" name="centroCoords" value="">Centro mapa
	 		<input type="submit" value="NUEVA UBICACION">
	 	</form>
 	</div>
 	
</body>
</html>
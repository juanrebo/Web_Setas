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
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="../js/localizacion.js"></script>
	<link rel="stylesheet" href="../css/Web_Setas.css">
	<link rel="stylesheet" href="../css/Mapa.css">
</head>

<body>
<div class="encabezado">
		<div class="nombre">
			<a href="../Inicio.jsp">micoPedia</a>
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
	
	<div class="mapa">
 		<div id="mapid" style="height: 500px"></div>
	 	<br/>
	 	<button id="centrarMapa" type="button" onclick="CentrarUsuario()">CENTRAR MAPA</button>
	 	<br/>
	 	<br/>
	 	<form id="nuevoPunto" method="post" action="insertarLocalizacion.do">
	 		<select name="setaLocalizacion" form="nuevoPunto">
	 			<c:forEach var="s" items="${applicationScope.todasSetas}">
	 			<option value="${s.idseta}">${s.genero.genero} ${s.especie}</option>
	 			</c:forEach>
	 		</select>
	 		<input type="hidden" id="latUbi" name="latUbi" value=""/>
	 		<input type="hidden" id="lonUbi" name="lonUbi" value=""/>
	 		<input type="radio" id="coordsUsu" name="centroCoords" value="usuario" checked="checked">Ubicaci�n usuario
	 		<input type="radio" id="coordsMap" name="centroCoords" value="mapa">Centro mapa
	 		<button type="button" onclick="InsertarLocalizacion()">NUEVA UBICACION</button>
	 	</form>
 	</div>
 	
 	<div class="popups">
 		<c:forEach var="l" items="${listaLocalizacion}">
 		<div class="popup" onclick="CentrarSeta(${l.latitud},${l.longitud})">
 			<c:set var="foto" scope="session" value="${l.seta.fotos.iterator()}"/>
 			<div class="popupContenido">
				<div class="popupFoto">
					<img src="${foto.next().ruta}"></img>
				</div>
				<div class="popupTexto">${l.seta.genero.genero} ${l.seta.especie}</div>
			</div>
			<div class="popupLat">${l.latitud}</div>
			<div class="popupLon">${l.longitud}</div>
 		</div>
		<div class="eliminarLocalizacion">
			<form id="eliminarLocalizacion" method="post" action="eliminarLocalizacion.do?idlocalizacion=${l.idlocalizacion}">
				<input type="submit" value="x"/>			
			</form>
		</div>
 		</c:forEach>
 	</div>
</body>
</html>
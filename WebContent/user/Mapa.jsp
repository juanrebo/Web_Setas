<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Mapa</title>
	<link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css"
   integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
   crossorigin=""/>
	<script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js"
   integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA=="
   crossorigin=""></script>
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="../js/localizacion.js"></script>
	<c:if test="${rol.rol == 'user'}">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="../js/eliminarClas.js"></script>
	</c:if>
	<link rel="stylesheet" href="../css/Web_Setas_Azul.css">
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
			<a href="registro.jsp">REGISTRO</a>
		</div>	    
		<div class="botonEncabezado">
			<a href="login.jsp">INICIAR SESIÓN</a>
		</div>
		</c:when>
		<c:otherwise>
		<div class="sesionIniciada">
			<div class="nombreUsuario">
				Hola, ${sessionScope.usuario.nombre}
			</div>
			<div class="botonEncabezado">
				<a href="cerrarSesion.do">CERRAR SESIÓN</a>
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
	
	<div class="mapa">
 		<div id="mapid"></div>
		<div class="controlesMapa">
			<button id="centrarMapa" type="button" onclick="CentrarUsuario()">MI POSICIÓN</button>
			<button type="button" id="botonOcultar" onclick="MostrarControles()">NUEVA UBICACIÓN</button>
			
		</div>
	 	<div class="controlesLocalizacion" style="display: none">		 	
		 	<form id="nuevoPunto" method="post" action="insertarLocalizacion.do"></form>
		 	<form id="nuevoLugar" method="post" action="insertarLugar.do"></form>
		 		<div class="controlLocalizacion">
					Especie: 
			 		<select name="setaLocalizacion" form="nuevoPunto">
			 			<c:forEach var="s" items="${applicationScope.todasSetas}">
			 			<option value="${s.genero.genero} ${s.especie}">${s.genero.genero} ${s.especie}</option>
			 			</c:forEach>
			 		</select>
		 		</div>
		 		<div class="controlLocalizacion">
			 		Lugar: 
			 		<select name="lugarLocalizacion" form="nuevoPunto">
			 			<c:forEach var="l" items="${sessionScope.listaLugar}">
			 			<option value="${l.idlugar}">${l.lugar}</option>
			 			</c:forEach>
			 		</select>
			 		<button type="button" id="botonOcultarLugar" onclick="MostrarControlesLugar()">NUEVO LUGAR</button>
			 		<div class="nuevoLugar" style="display: none">
				 		<input type="text" id="textoInsertarLugar" form="nuevoLugar" name="nuevoLugar">
				 		<input type="submit" id="botonInsertarLugar" onclick="InsertarLugar()" value="AÑADIR LUGAR">
				 		<div id="mensajeLugar"></div>
			 		</div>
			 		<input type="hidden" form="nuevoPunto" id="latUbi" name="latUbi" value="">
			 		<input type="hidden" form="nuevoPunto" id="lonUbi" name="lonUbi" value="">
		 		</div>
		 		<div class="controlLocalizacion">
			 		Centro: 
			 		<input type="radio" id="coordsUsu" form="nuevoPunto" name="centroCoords" value="usuario" checked="checked">Usuario
			 		<input type="radio" id="coordsMap" form="nuevoPunto" name="centroCoords" value="mapa">Mapa
			 		</div>
		 		<div class="controlLocalizacion">
		 			<button type="button" form="nuevoPunto" onclick="InsertarLocalizacion()">AÑADIR UBICACIÓN</button>
		 		</div>
		</div>
 	</div>
 	
 	<div class="popups">
 		<c:set var="n" value="0"/>
 		<c:forEach var="l" items="${listaLocalizacion}">
 		<c:if test="${param['localizacion'] eq l.lugar.idlugar.toString() or param['localizacion']==null}">
 		<div class="popup" onclick="CentrarSeta(${l.latitud},${l.longitud})">
 			<c:set var="foto" scope="session" value="${l.seta.fotos.iterator()}"/>
 			<div class="popupContenido">
				<div class="popupFoto">
					<img src="${foto.next().ruta}"></img>
				</div>
				<div class="popupTexto">
					<div class="popupNombre">${l.seta.genero.genero} ${l.seta.especie}</div>
					<div class="popupLugar">${l.lugar.lugar}</div>
					<div class="popupLat" latitud="${l.latitud}">Lat.: ${l.latitud.substring(0,10)}</div>
					<div class="popupLon" longitud="${l.longitud}">Lon.: ${l.longitud.substring(0,10)}</div>
				</div>
			</div>
			<div class="popupEliminar">
				<form id="eliminar${n}" method="post" action="eliminarLocalizacion.do?idlocalizacion=${l.idlocalizacion}&origen=mapa"></form>
				<button class="borrar" onclick="eliminarClas(${n})" >X</button>
				<c:set var="n" value="${n+1}"/>
			</div>
 		</div>
 		</c:if>
 		</c:forEach>
 	</div>
</body>
</html>
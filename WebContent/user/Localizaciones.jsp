<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../css/Web_Setas_Azul.css">
	<link rel="stylesheet" href="../css/Localizaciones.css">
	<title>Localizaciones</title>
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
			<a href="login.html">INICIAR SESIÓN</a>
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
	
	<h1>Localizaciones</h1>
	
		<c:forEach var="g" items="${sessionScope.listaLugar}">
		<div class="localizacion">
			<a href="Mapa.jsp?localizacion=${g.idlugar}"><h3>${g.lugar}</h3></a>
			<div class="popups">
				<c:forEach var="l" items="${sessionScope.listaLocalizacion}">
				<c:if test="${l.lugar.idlugar eq g.idlugar}">
				<div class="popup" onclick="CentrarSeta(${l.latitud},${l.longitud})">
					<c:set var="foto" scope="session" value="${l.seta.fotos.iterator()}"/>
		 			<div class="popupContenido">
						<div class="popupFoto">
							<img src="${foto.next().ruta}"></img>
						</div>
						<div class="popupTexto">
							<div class="popupNombre">${l.seta.genero.genero} ${l.seta.especie}</div>
							<div class="popupLat" latitud="${l.latitud}">Latitud: ${l.latitud.substring(0,10)}</div>
							<div class="popupLon" longitud="${l.longitud}">Longitud: ${l.longitud.substring(0,10)}</div>
						</div>
					</div>		
					<div class="popupEliminar">
						<form id="eliminarLocalizacion" method="post" action="eliminarLocalizacion.do?idlocalizacion=${l.idlocalizacion}">
							<input type="submit" value="X"/>			
						</form>
					</div>
	 			</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
		</c:forEach>
	
	
			
	 			
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../css/Web_Setas_Azul.css">
	<link rel="stylesheet" href="../css/Setas.css">
	<title>Favoritos</title>
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
	
	<h1>Favoritos</h1>
	
	<div class="todasSetas">
		<c:forEach var="ts" items="${sessionScope.listaFavorito}">
			<a href="../seta.do?genero=${ts.seta.genero.genero}+&especie=${ts.seta.especie}">
				<div class="fichaSeta">
					<div class="fichaSetaImagen">
					<c:if test="${not empty ts.seta.fotos}">
						<c:set var="foto" scope="session" value="${ts.seta.fotos.iterator()}"/>
						<img src="${foto.next().ruta}"></img>
					</c:if>
					</div>
					<div class="fichaSetaTexto">
						<p>${ts.seta.genero.genero} ${ts.seta.especie}</p>
					</div>
					<div class="fichaSetaNombre">
					<c:if test="${not empty ts.seta.nombres}">
						<c:set var="masNombres" scope="session" value="0"/>
						<c:forEach var="sn" items="${ts.seta.nombres}">
						<c:if test="${sn.idioma eq 'Es'}">
							<c:if test="${masNombres == 0}">
								<c:set var="ns" scope="session" value="${sn.nombre}"/>
							</c:if>
							<c:if test="${masNombres == 1}">
								<c:set var="ns" scope="session" value="${ns}, ${sn.nombre}"/>
							</c:if>
							<c:set var="masNombres" scope="session" value="1"/>
						</c:if>
						</c:forEach>
						${ns}.
					</c:if>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
	
</body>
</html>
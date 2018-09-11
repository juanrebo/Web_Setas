<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas_claro.css">
	<link rel="stylesheet" href="css/Ficha.css">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<title>Setas</title>
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
		
	<div class="todasSetas">
		<c:forEach var="ts" items="${applicationScope.todasSetas}">
			<a href="seta.do?genero=${ts.genero.genero}+&especie=${ts.id.especie}">
				<div class="fichaSeta">
					<c:set var="foto" scope="session" value="${ts.fotos.iterator()}"/>
					<div class="fichaSetaImagen">
					<c:if test="${not empty ts.fotos}">
						<img src="${foto.next().ruta}"></img>
					</c:if>
					</div>
					<div class="fichaSetaTexto">
						<p>${ts.genero.genero} ${ts.id.especie}</p>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</body>
<script src="js/relleno.js"></script>
</html>
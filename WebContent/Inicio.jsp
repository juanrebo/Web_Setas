<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas_Azul.css">
	<link rel="stylesheet" href="css/Menu.css">
	<link rel="stylesheet" href="css/Setas.css">
	<title>Inicio</title>
</head>
<body>
	<div class="encabezado">
		<div class="nombre">
			<a href="Inicio.jsp">micoPedia</a>
		</div>
		<div class="acciones">
			<div class="botonEncabezado">
				<a href="filo.do">CLASIFICACIONES</a>
			</div>
			<c:choose>
			<c:when test="${sessionScope.rol.rol eq 'user'}">
			<div class="botonEncabezado">
				<a href="user/Favoritos.jsp">FAVORITOS</a>
			</div>
			<div class="botonEncabezado">
				<a href="user/Mapa.jsp">MAPA</a>
			</div>
			</c:when>
			<c:when test="${sessionScope.rol.rol eq 'admin'}">
			<div class="botonEncabezado">
				<a href="admin/InsertarSeta.jsp">INSERTAR SETA</a>
			</div>
			</c:when>
			</c:choose>
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

	<div class="menu">
<!-- 		<div class="botonMenu"> -->
<!-- 	    	<a href="setas.jsp">SETAS</a> -->
<!-- 	    </div> -->
<!-- 	    <div class="botonMenu"> -->
<!-- 	    	<a href="filo.do">CLASIFICACIONES</a> -->
<!-- 	    </div> -->
	    
<%-- 		<c:choose> --%>
<%-- 		<c:when test="${sessionScope.rol.rol eq 'user'}"> --%>
<!-- 		<div class="botonMenu"> -->
<!-- 			<a href="user/Favoritos.jsp">FAVORITOS</a> -->
<!-- 		</div> -->
<!-- 		<div class="botonMenu"> -->
<!-- 			<a href="user/Localizaciones.jsp">LOCALIZACIONES</a> -->
<!-- 		</div> -->
<!-- 		<div class="botonMenu"> -->
<!-- 			<a href="user/Mapa.jsp">MAPA</a> -->
<!-- 		</div> -->
<%-- 		</c:when> --%>
<%-- 		<c:when test="${sessionScope.rol.rol eq 'admin'}"> --%>
<!-- 		<div class="botonMenu"> -->
<!-- 			<a href="admin/InsertarSeta.jsp">INSERTAR SETA</a> -->
<!-- 		</div> -->
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<!-- 		<div class="botonMenuDesactivado"> -->
<!-- 			<a>FAVORITOS</a> -->
<!-- 		</div> -->
<!-- 		<div class="botonMenuDesactivado"> -->
<!-- 			<a>LOCALIZACIONES</a> -->
<!-- 		</div> -->
<!-- 		<div class="botonMenuDesactivado"> -->
<!-- 			<a>MAPA</a> -->
<!-- 		</div> -->
<%-- 		</c:otherwise> --%>
<%-- 		</c:choose>		 --%>
<!--     </div> -->
	    <div class="todasSetas">
			<c:forEach var="ts" items="${applicationScope.todasSetas}">
				<a href="seta.do?genero=${ts.genero.genero}+&especie=${ts.especie}">
					<div class="fichaSeta">
						<div class="fichaSetaImagen">
						<c:if test="${not empty ts.fotos}">
							<c:set var="foto" scope="session" value="${ts.fotos.iterator()}"/>
							<img src="${foto.next().ruta}"></img>
						</c:if>
						</div>
						<div class="fichaSetaTexto">
							<p>${ts.genero.genero} ${ts.especie}</p>
						</div>
						<div class="fichaSetaNombre">
						<c:if test="${not empty ts.nombres}">
							<c:set var="masNombres" scope="session" value="0"/>
							<c:forEach var="sn" items="${ts.nombres}">
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
	</div>
</body>
</html>
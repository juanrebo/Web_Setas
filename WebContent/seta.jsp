<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas_Verde.css">
	<link rel="stylesheet" href="css/FichaSeta.css">
	<title>${seta.genero.genero} ${seta.id.especie}</title>
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
	
	<c:if test="${rol.rol == 'admin'}">
	<div class="admin">
		<form method="post" action="admin/editarSeta.do">
			<input type="submit" value="EDITAR SETA">
		</form>
		<form method="post" action="admin/eliminarSeta.do">
			<input type="submit" value="ELIMINAR SETA">
		</form>
	</div>
	</c:if>
	
	<c:if test="${rol.rol == 'user'}">
	<c:choose>
		<c:when test="${listaFavorito.isEmpty()}">
			<form method="post" action="anadirFavorito.do">
				<input type="submit" value="AÑADIR FAVORITO">
			</form>
		</c:when>
		
		<c:otherwise>
			<c:set var="existe" scope="session" value="noexiste"/>
			<c:forEach var="f" items="${sessionScope.listaFavorito}">
				<c:if test="${f.seta.id eq seta.id}">
					<c:set var="existe" scope="session" value="existe"/>
				</c:if>
			</c:forEach>
			<c:choose>
				<c:when test="${existe == 'existe'}">
					<form method="post" action="eliminarFavorito.do">
						<input type="submit" value="ELIMINAR FAVORITO">
					</form>
				</c:when>
				<c:otherwise>
				<form method="post" action="anadirFavorito.do">
					<input type="submit" value="AÑADIR FAVORITO">
				</form>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	</c:if>
	
	<div class="fichaSeta">
		<div class="fichaSetaEncabezado">
			<div class="fichaSetaFoto">
				<p><img src="${listaFotos.get(0).ruta}">
			</div>
			<div class="fichaSetaTexto">
				<h2>${seta.genero.genero} ${seta.id.especie}</h2>
				<h3><c:forEach var="n" items="${seta.nombres}">
				${n.idioma}: ${n.nombre}.
				</c:forEach></h3>
				<div class="fichaSetaClasif">
					<p><span>Reino: </span><a href="filo.do">Fungi</a></p>
					<p><span>Filo: </span><a href="clase.do?filo=${filo.filo}">${filo.filo}</a></p>
					<p><span>Clase: </span><a href="orden.do?clase=${clase.clase}">${clase.clase}</a></p>
					<p><span>Orden: </span><a href="familia.do?orden=${orden.orden}">${orden.orden}</a></p>
					<p><span>Familia: </span><a href="genero.do?familia=${familia.familia}">${familia.familia}</a>
					<p><span>Género: </span><a href="especie.do?genero=${genero.genero}">${genero.genero}</a>
				</div>
			</div>
		</div>
		
		<div class="fichaSetaDatos">
			<c:if test="${seta.cuerpoFructifero ne ''}" >
				<h3>Cuerpo fructífero</h3>
				<p>${seta.cuerpoFructifero}</p>
			</c:if>
			
			<c:if test="${seta.sombrero ne ''}" >
				<h3>Sombrero</h3>
				<p>${seta.sombrero}</p>
			</c:if>
			
			<c:if test="${seta.himenio ne ''}" >
				<h3>Himenio</h3>
				<p>${seta.himenio}</p>
			</c:if>
			
			<c:if test="${seta.gleba ne ''}" >
				<h3>Gleba</h3>
				<p>${seta.gleba}</p>
			</c:if>
			
			<c:if test="${seta.estroma ne ''}" >
				<h3>Estroma</h3>
				<p>${seta.estroma}</p>
			</c:if>
			
			<c:if test="${seta.carne ne ''}" >
				<h3>Carne</h3>
				<p>${seta.carne}</p>
			</c:if>
			
			<c:if test="${seta.laminas ne ''}" >
				<h3>Laminas</h3>
				<p>${seta.laminas}</p>
			</c:if>
			
			<c:if test="${seta.tubos ne ''}" >
				<h3>Tubos</h3>
				<p>${seta.tubos}</p>
			</c:if>
			
			<c:if test="${seta.pie ne ''}" >
				<h3>Pie</h3>
				<p>${seta.pie}</p>
			</c:if>
			
			<c:if test="${seta.carne ne ''}" >
				<h3>Carne</h3>
				<p>${seta.carne}</p>
			</c:if>
			
			<c:if test="${seta.esporas ne ''}" >
				<h3>Esporada</h3>
				<p>${seta.esporas}</p>
			</c:if>
			
			<c:if test="${seta.habitat ne ''}" >
				<h3>Hábitat</h3>
				<p>${seta.habitat}</p>
			</c:if>
			
			<c:if test="${seta.comestibilidad ne ''}" >
				<h3>Comestibilidad</h3>
				<p>${seta.comestibilidad}</p>
			</c:if>
		</div>
	</div>
	
	<div class="fichaSetaFotos">
		<c:forEach var="f" items="${listaFotos}">
		<div class="fichaSetaFoto">
			<a href="${f.ruta}">
				<img src="${f.ruta}">
			</a>
			<div class="derecho">${f.derecho}</div>
		</div>
		</c:forEach>
	</div>
	
</body>

</html>
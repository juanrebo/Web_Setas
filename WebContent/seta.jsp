<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas_Azul.css">
	<link rel="stylesheet" href="css/FichaSeta.css">
	<c:if test="${rol.rol == 'admin'}">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="js/eliminar.js"></script>
	</c:if>
	<title>${seta.genero.genero} ${seta.especie}</title>
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
			<a href="login.html">INICIAR SESIÓN</a>
		</div>
		</c:when>
		<c:otherwise>
		<div class="sesionIniciada">
			<div class="botonEncabezado">
				<a href="cerrarSesion.do">CERRAR SESIÓN</a>
			</div>
			<div class="nombreUsuario">
				Hola, ${sessionScope.usuario.nombre}
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
	
	<div class="fichaSeta">
		<div class="fichaSetaEncabezado">
			<div class="fichaSetaFoto">
				<p><img src="${listaFotos.get(0).ruta}">
			</div>
			<div class="fichaSetaTexto">
				<h2>${seta.genero.genero} ${seta.especie}</h2>
				<c:set var="esCont" value="0"/>
				<c:set var="gaCont" value="0"/>
				<c:set var="caCont" value="0"/>
				<c:set var="euCont" value="0"/>
				<h3><c:forEach var="n" items="${seta.nombres}">
				<c:if test="${n.idioma eq 'Es'}">
					<c:if test="${esCont == 0}">
					<c:set var="es" value="ES: ${n.nombre}"/>
					</c:if>
					<c:if test="${esCont == 1}">
					<c:set var="es" value="${es}, ${n.nombre}"/>
					</c:if>
					<c:set var="esCont" value="1"/>
				</c:if>
				<c:if test="${n.idioma eq 'Ga'}">
					<c:if test="${gaCont == 0}">
					<c:set var="ga" value="GA: ${n.nombre}"/>
					</c:if>
					<c:if test="${gaCont == 1}">
					<c:set var="ga" value="${ga}, ${n.nombre}"/>
					</c:if>
					<c:set var="gaCont" value="1"/>
				</c:if>
				<c:if test="${n.idioma eq 'Eu'}">
					<c:if test="${euCont == 0}">
					<c:set var="eu" value="EU: ${n.nombre}"/>
					</c:if>
					<c:if test="${euCont == 1}">
					<c:set var="eu" value="${eu}, ${n.nombre}"/>
					</c:if>
					<c:set var="euCont" value="1"/>
				</c:if>
				<c:if test="${n.idioma eq 'Ca'}">
					<c:if test="${caCont == 0}">
					<c:set var="ca" value="CA: ${n.nombre}"/>
					</c:if>
					<c:if test="${caCont == 1}">
					<c:set var="ca" value="${ca}, ${n.nombre}"/>
					</c:if>
					<c:set var="caCont" value="1"/>
				</c:if>
				</c:forEach>
				${es}<c:if test="${not empty es}">. </c:if>
				${ga}<c:if test="${not empty ga}">. </c:if>
				${eu}<c:if test="${not empty eu}">. </c:if>
				${ca}<c:if test="${not empty ca}">. </c:if>
				</h3>
				<div class="fichaSetaClasif">
					<p><span>Reino: </span><a href="filo.do">Fungi</a></p>
					<p><span>Filo: </span><a href="clase.do?filo=${filo.filo}">${filo.filo}</a></p>
					<p><span>Clase: </span><a href="orden.do?clase=${clase.clase}">${clase.clase}</a></p>
					<p><span>Orden: </span><a href="familia.do?orden=${orden.orden}">${orden.orden}</a></p>
					<p><span>Familia: </span><a href="genero.do?familia=${familia.familia}">${familia.familia}</a>
					<p><span>Género: </span><a href="especie.do?genero=${genero.genero}">${genero.genero}</a>
				</div>
			</div>
			<c:if test="${rol.rol == 'admin'}">
			<div class="fichaSetaBoton">
				<form method="post" action="admin/EditarSeta.jsp">
					<input type="submit" value="EDITAR SETA">
				</form>
				<form method="post" id="eliminar" action="admin/eliminarSeta.do">
				</form>
					<p><button class="borrar" onclick="eliminar()">ELIMINAR SETA</button></p>
			</div>
			</c:if>
			<c:if test="${rol.rol == 'user'}">
				<c:set var="existe" scope="session" value="noexiste"/>
				<c:forEach var="f" items="${sessionScope.listaFavorito}">
					<c:if test="${f.seta.idseta eq seta.idseta}">
						<c:set var="existe" scope="session" value="existe"/>
					</c:if>
				</c:forEach>
				<c:choose>
					<c:when test="${existe == 'existe'}">
						<div class="fichaSetaBoton">
						<form method="post" action="eliminarFavorito.do">
							<input type="submit" value="ELIMINAR FAVORITO">
						</form>
						</div>
						</c:when>
						<c:otherwise>
						<div class="fichaSetaBoton">
						<form method="post" action="anadirFavorito.do">
							<input type="submit" value="AÑADIR FAVORITO">
						</form>
						</div>
					</div>
					</c:otherwise>
				</c:choose>
			</c:if>
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
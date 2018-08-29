<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas.css">
	<link rel="stylesheet" href="css/EditarSeta.css">
	<title>Editar seta</title>
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
	
	<h1>Editar seta</h1>

	<h2>${seta.genero.genero} ${seta.especie}</h2>
	
	<form method="post" id="modificarSeta" action="modificarSeta.do">
		<p>Género: 
		<select name="generoNuevo" form="modificarSeta">
			<c:forEach var="g" items="${listaGenero}">
				<c:choose>
					<c:when test="${g.genero eq genero.genero}">
						<option value="${g.genero}" selected="selected">${g.genero}</option>
					</c:when>
					<c:otherwise>
						<option value="${g.genero}">${g.genero}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		 Especie: <input type="text" name="especie" value="${seta.especie}">
		<br/><br/>
		<p>Cuerpo fructífero:
		<p><textarea  rows="5" cols="50" maxlength="500" name="cuerpoFructifero" form="modificarSeta">${seta.cuerpoFructifero}</textarea>
		<br/><br/>
		<p>Sombrero:
		<p><textarea rows="5" cols="50" maxlength="500" name="sombrero" form="modificarSeta">${seta.sombrero}</textarea>
		<br/><br/>
		<p>Himenio:
		<p><textarea rows="5" cols="50" maxlength="500" name="himenio" form="modificarSeta">${seta.himenio}</textarea>
		<br/><br/>
		<p>Gleba:
		<p><textarea rows="5" cols="50" maxlength="500" name="gleba" form="modificarSeta">${seta.gleba}</textarea>
		<br/><br/>
		<p>Estroma:
		<p><textarea rows="5" cols="50" maxlength="500" name="estroma" form="modificarSeta">${seta.estroma}</textarea>
		<br/><br/>
		<p>Láminas:
		<p><textarea rows="5" cols="50" maxlength="500" name="laminas" form="modificarSeta">${seta.laminas}</textarea>
		<br/><br/>
		<p>Tubos:
		<p><textarea rows="5" cols="50" maxlength="500" name="tubos" form="modificarSeta">${seta.tubos}</textarea>
		<br/><br/>
		<p>Pie:
		<p><textarea rows="5" cols="50" maxlength="500" name="pie" form="modificarSeta">${seta.pie}</textarea>
		<br/><br/>
		<p>Carne
		<p><textarea rows="5" cols="50" maxlength="500" name="carne" form="modificarSeta">${seta.carne}</textarea>
		<br/><br/>
		<p>Esporada:
		<p><textarea rows="5" cols="50" maxlength="500" name="esporas" form="modificarSeta">${seta.esporas}</textarea>
		<br/><br/>
		<p>Hábitat
		<p><textarea rows="5" cols="50" maxlength="500" name="habitat" form="modificarSeta">${seta.habitat}</textarea>
		<br/><br/>
		<p>Comestibilidad:
		<p><textarea rows="5" cols="50" maxlength="500" name="comestibilidad" form="modificarSeta">${seta.comestibilidad}</textarea>
		<br/><br/>
		<p>Foto: <input type="text" name="ruta">
		<br/><br/>
		<p>Derecho: <input type="text" name="derecho">
		<br/><br/>
		<p><input type="submit" value="Editar seta">
	</form>
</body>
</html>
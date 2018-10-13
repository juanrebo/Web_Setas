<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insertar seta</title>
	<link rel="stylesheet" href="../css/Web_Setas_Azul.css">
	<link rel="stylesheet" href="../css/EditarSeta.css">
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
	
	<h1>Insertar seta</h1>
	
	<div class="cuerpo">
		<form method="post" id="insertarSeta" action="insertarSeta.do"></form>
			<p>Género:
			<select name="genero" form="insertarSeta">
				<c:forEach var="g" items="${todoGenero}">
					<option value="${g.genero}">${g.genero}</option>
				</c:forEach>
			</select>
			<button onclick="window.location.href='../filo.do'">NUEVO GÉNERO</button>
			<br/>
			<br/>
			 Especie: <input type="text" form="insertarSeta" name="especie">
			 
			<div class="entradas">
			<p>Cuerpo fructífero: 
			<p><textarea rows="5" cols="50" maxlength="500" name="cuerpoFructifero" form="insertarSeta"></textarea>
			<p>Sombrero: 
			<p><textarea rows="5" cols="50" maxlength="500" name="sombrero" form="insertarSeta"></textarea>
			<p>Himenio: 
			<p><textarea rows="5" cols="50" maxlength="500" name="himenio" form="insertarSeta"></textarea>
			<p>Gleba: 
			<p><textarea rows="5" cols="50" maxlength="500" name="gleba" form="insertarSeta"></textarea>
			<p>Estroma: 
			<p><textarea rows="5" cols="50" maxlength="500" name="estroma" form="insertarSeta"></textarea>
			<p>Láminas: 
			<p><textarea rows="5" cols="50" maxlength="500" name="laminas" form="insertarSeta"></textarea>
			<p>Tubos: 
			<p><textarea rows="5" cols="50" maxlength="500" name="tubos" form="insertarSeta"></textarea>
			<p>Pie: 
			<p><textarea rows="5" cols="50" maxlength="500" name="pie" form="insertarSeta"></textarea>
			<p>Carne: 
			<p><textarea rows="5" cols="50" maxlength="500" name="carne" form="insertarSeta"></textarea>
			<p>Esporada: 
			<p><textarea rows="5" cols="50" maxlength="500" name="esporada" form="insertarSeta"></textarea>
			<p>Hábitat: 
			<p><textarea rows="5" cols="50" maxlength="500" name="habitat" form="insertarSeta"></textarea>
			<p>Comestibilidad: 
			<p><textarea rows="5" cols="50" maxlength="500" name="comestibilidad" form="insertarSeta"></textarea>
			</div>
			<p>Foto: <input type="text" form="insertarSeta" name="ruta">
			<p>
			<p>Derecho: <input type="text" form="insertarSeta" name="derecho">
			<p>
			<p>Idioma: 
			<select type="select" form="insertarSeta" name="idioma">
				<option value="Es" selected="selected">Castellano</option>
				<option value="Ga">Galego</option>
				<option value="Eu">Euskera</option>
				<option value="Ca">Catalán</option>
			</select>  
			 Nombre:<input type="text" form="insertarSeta" name="nombre">
			<p><input type="submit" form="insertarSeta" value="INSERTAR SETA">
	</div>
</body>
</html>
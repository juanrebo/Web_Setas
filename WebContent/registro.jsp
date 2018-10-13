<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="js/registro.js"></script>
	<link rel="stylesheet" href="css/Web_Setas_Azul.css">
	<link rel="stylesheet" href="css/Login.css">
	<title>Registro</title>
</head>
<body>
	<div class="encabezado">
		<div class="nombre">
			<a href="Inicio.jsp">micoPedia</a>
		</div>
		<div class="registro">
			<div class="botonEncabezado">
				<a href="login.jsp">INICIAR SESIÓN</a>
			</div>
		</div>
	</div>
	
	<div class="login">
		<h2>Registro</h2>
		<form method="post" id="registro" action="insertarUsuario.do">
			<p><span>Nombre: </span><input type="text" name="nombre" maxlength="20"></p>
			<p><span>Correo electrónico: </span><input type="text" name="correo" maxlength="45"></p>
			<p><span>Contraseña: </span><input type="password" name="contrasena" maxlength="20"></p>
			<p><span>Repetir contraseña: </span><input type="password" name="contrasena2" maxlength="20"></p>
		</form>
		<div class="error">
		<c:choose>
			<c:when test="${error.toString().contains('Duplicate entry')}">
				<c:if test="${error.toString().contains('nombre')}">
				<p class="pError">Nombre ya existente</p>
				</c:if>
				<c:if test="${error.toString().contains('email')}">
				<p class="pError">Email ya empleado</p>
				</c:if>
			</c:when>
			<c:otherwise>
			<p>${error}</p>
			</c:otherwise>
		</c:choose>
		</div>
		<p><button onclick="registro()">REGISTRARSE</button></p>
	</div>
</body>
</html>
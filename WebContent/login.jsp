<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/Web_Setas_Azul.css">
	<link rel="stylesheet" href="css/Login.css">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="js/registro.js"></script>
	<title>Iniciar sesión</title>
</head>
<body>
	<div class="encabezado">
		<div class="nombre">
			<a href="Inicio.jsp">micoPedia</a>
		</div>
		<div class="registro">
			<div class="botonEncabezado">
				<a href="registro.jsp">REGISTRO</a>
			</div>
		</div>
	</div>
	
	<div class="login">
		<h2>Iniciar sesión</h2>
		<form method="post" id="login" action="iniciarSesion.do">
			<p><span>Usuario: </span><input type="text" name="nombre"></p>
			<p><span>Contraseña: </span><input type="password" name="contrasena"></p>
		</form>
		<div class="error">
			<c:if test="${errorLogin eq 'error'}">
			<p class="pError">Nombre de usuario o contraseña incorrecto</p>
			</c:if>
		</div>
		<p><button onclick="login()">INICIAR SESIÓN</button></p>
	</div>
</body>
</html>
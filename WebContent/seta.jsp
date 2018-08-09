<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${seta.genero.genero} ${seta.especie}</title>
</head>
<body>
	<a href="Inicio.html">Inicio</a>
	<h2>${seta.genero.genero} ${seta.especie}</h2>
	<c:if test="${rol == 'admin'}">
		<a href="editarSeta.do">Editar seta</a>
		<!--a href="admin/EditarSeta.jsp?genero=${genero.genero}&especie=${seta.especie}">Editar</a-->
	</c:if>
	<div>
	<p><img src="${listaFotos.get(0).ruta}" width="25%" display="inline">
	</div>
	<div display="inline">
	<p>Reino: <a href="filo.do">Fungi</a>
	<p>Filo: <a href="clase.do?filo=${filo.filo}">${filo.filo}</a></p>
	<p>Clase: <a href="orden.do?clase=${clase.clase}">${clase.clase}</a></p>
	<p>Orden: <a href="familia.do?orden=${orden.orden}">${orden.orden}</a></p>
	<p>Familia: <a href="genero.do?familia=${familia.familia}">${familia.familia}</a></p>
	<p>Género: <a href="especie.do?genero=${genero.genero}">${genero.genero}</a></p>
	</div>
	
	<c:if test="${seta.cuerpoFructifero ne ''}" >
		<h3>Cuerpo fructífero</h3>
		<p>${seta.cuerpoFructifero.replaceAll('\\n','<br/>')}</p>
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
	
	<c:forEach var="f" items="${listaFotos}">
		<img src="${f.ruta}">
	</c:forEach>
</body>
</html>
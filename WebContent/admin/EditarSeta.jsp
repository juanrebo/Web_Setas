<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar seta</title>
</head>
<body>
	<h2>${seta.genero.genero} ${seta.especie}</h2>
	<form method="post" id="modificarSeta" action="modificarSeta.do">
		<p><select name="generoNuevo" form="modificarSeta">
			<c:forEach var="g" items="${listaGenero}">
				<c:choose>
					<c:when test="${g.genero eq genero.genero}">
						<option value="${g.genero}" selected>${g.genero}</option>
					</c:when>
					<c:otherwise>
						<option value="${g.genero}">${g.genero}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		 Especie: <input type="text" name="especie" value="${seta.especie}">
		<p>Cuerpo fructífero:
		<p><textarea rows="5" maxlength="500" name="cuerpoFructifero" form="modificarSeta">${seta.cuerpoFructifero}</textarea>
		<p>Sombrero:
		<p><textarea rows="5" maxlength="500" name="sombrero" form="modificarSeta">${seta.sombrero}</textarea>
		<p>Himenio:
		<p><textarea rows="5" maxlength="500" name="himenio" form="modificarSeta">${seta.himenio}</textarea>
		<p>Gleba:
		<p><textarea rows="5" maxlength="500" name="gleba" form="modificarSeta">${seta.gleba}</textarea>
		<p>Estroma:
		<p><textarea rows="5" maxlength="500" name="estroma" form="modificarSeta">${seta.estroma}</textarea>
		<p>Láminas:
		<p><textarea rows="5" maxlength="500" name="laminas" form="modificarSeta">${seta.laminas}</textarea>
		<p>Tubos:
		<p><textarea rows="5" maxlength="500" name="tubos" form="modificarSeta">${seta.tubos}</textarea>
		<p>Pie:
		<p><textarea rows="5" maxlength="500" name="pie" form="modificarSeta">${seta.pie}</textarea>
		<p>Carne
		<p><textarea rows="5" maxlength="500" name="carne" form="modificarSeta">${seta.carne}</textarea>
		<p>Esporada:
		<p><textarea rows="5" maxlength="500" name="esporas" form="modificarSeta">${seta.esporas}</textarea>
		<p>Hábitat
		<p><textarea rows="5" maxlength="500" name="habitat" form="modificarSeta">${seta.habitat}</textarea>
		<p>Comestibilidad:
		<p><textarea rows="5" maxlength="500" name="comestibilidad" form="modificarSeta">${seta.comestibilidad}</textarea>
		<p>Foto: <input type="text" name="ruta">
		<p><input type="submit" value="Editar seta">
	</form>
</body>
</html>
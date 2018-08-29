<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar seta</title>
</head>
<body>
	<form method="post" id="insertarSeta" action="insertarSeta.do">
		<p>Genero:
		<select name="genero" form="insertarSeta">
			<c:forEach var="g" items="${todoGenero}">
				<option value="${g.genero}">${g.genero}</option>
			</c:forEach>
		</select>
		<p>Especie: <input type="text" name="especie">
		<p>Cuerpo fructífero: <textarea rows="5" maxlength="500" name="cuerpoFructifero" form="insertarSeta"/>
		<p>Sombrero: <textarea rows="5" maxlength="500" name="sombrero" form="insertarSeta"/>
		<p>Himenio: <textarea rows="5" maxlength="500" name="himenio" form="insertarSeta"/>
		<p>Gleba: <textarea rows="5" maxlength="500" name="gleba" form="insertarSeta"/>
		<p>Estroma: <textarea rows="5" maxlength="500" name="estroma" form="insertarSeta"/>
		<p>Carne: <textarea rows="5" maxlength="500" name="carne" form="insertarSeta"/>
		<p>Láminas: <textarea rows="5" maxlength="500" name="laminas" form="insertarSeta"/>
		<p>Tubos: <textarea rows="5" maxlength="500" name="tubos" form="insertarSeta"/>
		<p>Pie: <textarea rows="5" maxlength="500" name="pie" form="insertarSeta"/>
		<p>Carne: <textarea rows="5" maxlength="500" name="carne" form="insertarSeta"/>
		<p>Esporada: <textarea rows="5" maxlength="500" name="esporada" form="insertarSeta"/>
		<p>Hábitat: <textarea rows="5" maxlength="500" name="habitat" form="insertarSeta"/>
		<p>Comestibilidad: <textarea rows="5" maxlength="500" name="comestibilidad" form="insertarSeta"/>
		<p>Foto: <input type="text" name="ruta">
		<p><input type="submit" value="Insertar seta">
	</form>
</body>
</html>
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
		<p>Cuerpo fructífero: <textarea rows="5" maxlength="500" name="cuerpoFructifero" form="insertarSeta"></textarea>
		<p>Sombrero: <textarea rows="5" maxlength="500" name="sombrero" form="insertarSeta"></textarea>
		<p>Himenio: <textarea rows="5" maxlength="500" name="himenio" form="insertarSeta"></textarea>
		<p>Gleba: <textarea rows="5" maxlength="500" name="gleba" form="insertarSeta"></textarea>
		<p>Estroma: <textarea rows="5" maxlength="500" name="estroma" form="insertarSeta"></textarea>
		<p>Carne: <textarea rows="5" maxlength="500" name="carne" form="insertarSeta"></textarea>
		<p>Láminas: <textarea rows="5" maxlength="500" name="laminas" form="insertarSeta"></textarea>
		<p>Tubos: <textarea rows="5" maxlength="500" name="tubos" form="insertarSeta"></textarea>
		<p>Pie: <textarea rows="5" maxlength="500" name="pie" form="insertarSeta"></textarea>
		<p>Carne: <textarea rows="5" maxlength="500" name="carne" form="insertarSeta"></textarea>
		<p>Esporada: <textarea rows="5" maxlength="500" name="esporada" form="insertarSeta"></textarea>
		<p>Hábitat: <textarea rows="5" maxlength="500" name="habitat" form="insertarSeta"></textarea>
		<p>Comestibilidad: <textarea rows="5" maxlength="500" name="comestibilidad" form="insertarSeta"></textarea>
		<p>Foto: <input type="text" name="ruta">
		<p><input type="submit" value="Insertar seta">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subdivisiones</title>
</head>
<body>
	<h2>Subdivisiones</h2>
	<p>${rol}
	<p>${division.division}
	<c:forEach var="l" items="${listaSubdivision}">
		<p><a href="clase.do?subdivision=${l.idsubdivision}">${l.subdivision}</a>
		<c:if test="${rol == 'admin'}">
			<form method="post" action="eliminarSubdivision.do">
				<input type="submit" name="eliminar${l.idsubdivision}" value="Eliminar">
			</form>
		</c:if>
	</c:forEach>
	<c:if test="${rol == 'admin'}">
		<form method="post" action="insertarSubdivision.do">
			<input type="text" name="nuevaSubdivision">
			<input type="submit" value="+">
		</form>
	</c:if>
</body>
</html>
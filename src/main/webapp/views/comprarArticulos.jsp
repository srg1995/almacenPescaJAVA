<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
		<style type="">
			div{
				width:20%;
				float:left;
			}
			div a{
				text-decoration:none;
			}
		</style>
	</head>
	<body>
		<h1>Aumentar Stock Articulo</h1>
		<form:form action="aumentar-stock" method="POST" modelAttribute="modificarExistencias" path="modificarExistencias">
			<form:label path="nombre">nombre</form:label>
			<form:input id="nombre" path="nombre" />
			<form:label path="talla">talla</form:label>
			<form:input id="talla" path="talla" />
			<form:label path="unidades">Existecias</form:label>
			<form:input type="number" id="unidades" path="unidades" />
			<form:button value="enviar" >enviar</form:button>
		</form:form>
	
	<c:if test="${errores != null}">
		${errores}
	</c:if>		
	</body>
</html>
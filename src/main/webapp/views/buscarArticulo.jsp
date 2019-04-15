<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h1>Buscar Articulo</h1>
		<form:form action="buscar-articulo" method="POST" modelAttribute="buscarExistencias" path="buscarExistencias">
			<form:label path="nombre">nombre</form:label>
			<form:input id="nombre" path="nombre" />
			<form:label path="talla">talla</form:label>
			<form:input id="talla" path="talla" />
			<form:button value="enviar" >enviar</form:button>
		</form:form>
	
		<c:if test="${errores != null}">
			${errores}
		</c:if>
	
		<c:if test="${articulo != null}">
			nombre: ${articulo.nombre} ---
			talla: ${articulo.talla} ---
			existencias: ${articulo.unidades} ---
			<c:choose>
			  <c:when test="${articulo.segundaMano == 's' }">
			    articulo de segunda mano
			  </c:when>
			  <c:when test="${articulo.segundaMano == 'n' }">
			    articulo nuevo
			  </c:when>
			  <c:otherwise>
			    no es indicado
			  </c:otherwise>
			</c:choose>
		</c:if>	 
	</body>
</html>
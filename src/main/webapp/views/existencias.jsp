<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<title>Insert title here</title>
<style type="">
	table{
		
	}
	th,td{
	border: solid 1px black;
	}
</style>
</head>
<body>
<h1>DATOS DE LOS ARTICULOS DEL ALMACEN </h1>
	<table>
  		<tr>
			<th>nombre</th>	
			<th>talla</th>
			<th>unidades</th>
			<th>segunda mano</th>
		</tr>
	<c:forEach items="${existencias}" var="listado">
  		<tr>
			<td>${listado.nombre}</td>
			<td>${listado.talla}</td>
			<td>${listado.unidades}</td>
			<td>${listado.segundaMano}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
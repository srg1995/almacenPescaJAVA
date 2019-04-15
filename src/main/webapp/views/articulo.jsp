<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<h1>DATOS DEL ARTICULO ${articulo.nombre}</h1>
<table>
	<tr>
		<th>nombre</th>	
		<th>talla</th>
		<th>unidades</th>
		<th>segunda mano</th>
	</tr>
	<tr>
		<td>${articulo.nombre}</td>
		<td>${articulo.talla}</td>
		<td>${articulo.unidades}</td>
		<td>${articulo.segundaMano}</td>
	</tr>
</table>





<br>
<a href="">comprar unidades<a/>
<input type="number" name="quantity" min="1" max="5">
<br>
<a href="">vender unidades<a/>
<input type="number" name="quantity" min="1" max="5">
</body>
</html>


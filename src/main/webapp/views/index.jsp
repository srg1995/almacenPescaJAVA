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
	
	<h1>que quieres hacer</h1>
	
	<div><a href="/almacen/ver-stock">Ver Stock</a></div>
	<div><a href="/almacen/carga-existencias?accion=busca">Buscar Articulo</a></div>
	<div><a href="/almacen/carga-existencias?accion=compra">Comprar Existencias</a></div>
	<div><a href="/almacen/carga-existencias?accion=venta">Vender Existencias</a></div>
	<div><a href="/almacen/carga-existencias?accion=insertar">Añadir Articulo</a></div>
	
	
</body>
</html>
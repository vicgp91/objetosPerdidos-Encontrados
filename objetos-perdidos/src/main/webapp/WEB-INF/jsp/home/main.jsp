
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Objetos Perdidos y Encontrados</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
<script src="resources/js/jquery-3.0.0.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>

<body>


<div class="row">

<tiles:insertAttribute name="menu" />
</div>

<div class="row">
	<tiles:insertAttribute name="body" />

</div>

<div class="row">

<tiles:insertAttribute name="footer" />
</div>






	


</body>

</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Objetos Perdidos y Encontrados</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- <link rel="stylesheet" href="resources/css/bootstrap.min.css" /> -->
<!-- <script src="resources/js/jquery-3.0.0.min.js"></script> -->
<!-- <script src="resources/js/bootstrap.min.js"></script> -->


<link rel="stylesheet" href="http://localhost:8081/objetos-perdidos/resources/css/bootstrap.min.css" />
<script src="http://localhost:8081/objetos-perdidos/resources/js/jquery-3.0.0.min.js"></script>
<script src="http://localhost:8081/objetos-perdidos/resources/js/bootstrap.min.js"></script>



</head>

<body>


<div class="">

<tiles:insertAttribute name="menu" />
</div>

<div class="col-lg-12 container">
	<tiles:insertAttribute name="body" />

</div>

<div class="row col-lg-12 container">

<tiles:insertAttribute name="footer" />
</div>






	


</body>

</html>

<%@ include file="/WEB-INF/jsp/includes/resource.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Objetos Perdidos y Encontrados</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<c:url var="css" value="/resources/css/bootstrap.min.css" />
<c:url var="js" value="/resources/js/jquery-3.0.0.min.js" />
<c:url var="bootJs" value="/resources/js/bootstrap.min.jsresources/js/bootstrap.min.js" />
<link rel="stylesheet" href="${css}"/>
<script src="${js}"></script>
<script src="${bootJs}"></script>
<!-- <link rel="stylesheet" href="http://localhost:8080/objetos-perdidos/resources/css/bootstrap.min.css" />
<script src="http://localhost:8080/objetos-perdidos/resources/js/jquery-3.0.0.min.js"></script>
<script src="http://localhost:8080/objetos-perdidos/resources/js/bootstrap.min.js"></script> -->
</head>

<body>


<div class="row">


</div>

<div class="col-lg-12 container">
	<tiles:insertAttribute name="body" />

</div>

<div class="row col-lg-12 container">

<tiles:insertAttribute name="footer" />
</div>






	


</body>

</html>

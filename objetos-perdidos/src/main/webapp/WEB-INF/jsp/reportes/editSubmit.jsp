
<%@ include file="/WEB-INF/jsp/includes/resource.jsp"%>


<script type="text/javascript">
	$('#usuarioForm').on('submit', (function(e) {
		e.preventDefault()
		$.ajax({
			type : 'POST',
			url : $(this).attr('action'),
			data : $(this).serialize(),
			cache : false
		});
	}));
</script>

<div class="col-lg-12 container">
	<c:url var="rutaImg" value="http://localhost:8080/imagenes/" />
	<c:url var="url" value="/reportes/editReportSubmit" />
	<form:form method="POST" action="${url}" modelAttribute="repVO"
		id="usuarioForm" enctype="multipart/form-data" class="form-horizontal"
		role="form">

		<form:hidden path="reporteid" />

		<div class="page-header col-lg-12" id="areaTituloPantalla">
			<h3 align="center">Entregar Objeto</h3>
		</div>

		<div class="row form-group">
			<div class="col-lg-6">
				<form:input readonly="true" type="text" path="reportetittle"
					placeholder="Titúlo" class="form-control" />

			</div>
			<div class="col-lg-6">
				<form:select path="estado" class="form-control">
					<form:option label="--Marcar como--" value="0"></form:option>
					<form:option label="Entregado" value="2"></form:option>
				</form:select>

			</div>



		</div>

		<div class="row form-group">
		
		<div class="col-lg-6">
				<form:input  type="text" path="cedulaAquienEntrega"
					placeholder="Cedula a quien se entrega" class="form-control" />

			</div>
			
			<div class="col-lg-6">
				<form:textarea readonly="true" type="text" path="descripcion"
					placeholder="descripción" class="form-control" />

			</div>
		</div>

		<div align="middle" class=" row form-group">
			<img height="600" width="600" src="${rutaImg}${repVO.foto}"
				class="img-responsive" alt="Cinque Terre">

		</div>


		<div class=" row form-group">
			<div class="col-lg-12" id="botonesAccionFormulario">
				<!-- Boton submit -->
				<input type="submit" path="*" class="btn btn-primary"
					id="submitEditar" value="Guardar" />
				<!-- Boton cancelar -->
				<c:url var="backRep" value="/reportes/listReportes" />
				<a type="button" href="${backRep}" id="Cancelar" class="btn btn-default"
					data-dismiss="modal">Cancelar</a>

			</div>
		</div>



	</form:form>
</div>
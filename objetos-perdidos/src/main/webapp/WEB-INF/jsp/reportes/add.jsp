
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

	<c:url var="url" value="/reportes/addReportSubmit" />
	<form:form method="POST" action="${url}" modelAttribute="reportevo"
		id="usuarioForm" enctype="multipart/form-data" class="form-horizontal"
		role="form">

		<div class="page-header col-lg-12" id="areaTituloPantalla">
			<h3 align="center">Agregar nuevo Reporte</h3>
		</div>

		<div class="row form-group">
			<div class="col-lg-6">
				<form:input type="text" path="reportetittle" placeholder="Titúlo"
					class="form-control" />

			</div>
			<div class="col-lg-6">
				<form:textarea type="text" path="descripcion"
					placeholder="descripción" class="form-control" />

			</div>
		</div>


		<div class=" row form-group">
			<div class="col-lg-6">

				<input type="file" name="img" class="form-control" />
			</div>
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
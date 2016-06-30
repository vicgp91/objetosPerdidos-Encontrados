
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
			<h3 align="center">Agregar un Reporte de un Objeto</h3>
		</div>

		<div class="row form-group">
			<div class="col-lg-9">
				<form:input type="text" path="reportetittle" placeholder="Titúlo"
					class="form-control" />

			</div>
		</div>

		<div class=" row form-group">
			<div class="col-lg-9">
				<form:textarea type="text" path="descripcion"
					placeholder="descripción" class="form-control" />

			</div>
		</div>

		<div class=" row form-group">
			<div class="col-lg-9">

				<input type="file" name="img" class="form-control" />
			</div>
		</div>
		
		



		<div class=" row form-group">
			<div class="col-lg-12" id="botonesAccionFormulario">
				<!-- Boton submit -->
				<input type="submit" path="*" class="btn btn-primary"
					id="submitEditar" value="Guardar" />
				<!-- Boton cancelar -->
				<button type="button" id="Cancelar" class="btn btn-default"
					data-dismiss="modal">Cancelar</button>

			</div>
		</div>



	</form:form>
</div>
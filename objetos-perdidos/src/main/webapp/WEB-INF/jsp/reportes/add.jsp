
<%@ include file="/WEB-INF/jsp/includes/resource.jsp"%>


<div class="col-lg-12 container">

<c:url var="url" value="/reportes/addReportSubmit" />
<form:form method="POST" action="${url}" modelAttribute="reportevo"
			id="usuarioForm" class="form-horizontal" role="form">

	<div class="page-header col-lg-12" id="areaTituloPantalla">
		<h3 align="center">
			Agregar un Reporte de un Objeto

		</h3>
	</div>

		<div class="row form-group">
			<div class="col-lg-9">
				<form:input  type="text" path="reportetittle" placeholder="Tit�lo" class="form-control" />
				
			</div>
		</div>
		
		<div class=" row form-group">
			<div class="col-lg-9">
				<form:textarea type="text" path="descripcion" placeholder="descripci�n" class="form-control" />
				
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
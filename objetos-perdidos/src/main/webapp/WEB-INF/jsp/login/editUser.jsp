
<%@ include file="/WEB-INF/jsp/includes/resource.jsp"%>

<div id="area-trabajo" class="col-lg-12">

	<div class="col-lg-12 area-trabajo">
		<c:url var="url" value="/loginUsers/editUsuarioPost" />
		<form:form method="POST" action="${url}" modelAttribute="loginVO"
			id="usuarioForm" class="form-horizontal" role="form">

			<div class="page-header col-lg-12 " id="areaTituloPantalla">
				<h3>Agregar Usuarios</h3>
			</div>


			<div class="form-group">
				<label class="col-lg-2 control-label">&nbsp;User Name: </label>
				<div class="col-lg-3">
					<form:input readonly="true" path="userName" class="form-control"
						required="required" />

				</div>


				<label class="col-lg-2 control-label">&nbsp;Password: </label>
				<div class="col-lg-3">
					<form:password path="password" class="form-control"
						required="required" />
				</div>



			</div>

			<div class="form-group">
				<label class="col-lg-2 control-label">&nbsp;Nombre Completo:
				</label>
				<div class="col-lg-3">
					<form:input path="nombreCompleto" class="form-control"
						required="required" />
				</div>

				<label class="col-lg-2 control-label">&nbsp;Cédula: </label>
				<div class="col-lg-3">
					<form:input path="cedula" class="form-control" required="required" />
				</div>
			</div>



			<div class="form-group">
				<label class="col-lg-2 control-label">&nbsp;Celular: </label>
				<div class="col-lg-3">
					<form:input path="celular" class="form-control" required="required" />
				</div>

				<label class="col-lg-2 control-label">Perfil: </label>
				<!-- Control HTML -->
				<div class="col-lg-3">
					<form:select path="perfil" title="Seleccione un perfil de usuario"
						class="form-control col-lg-5">
						<form:option value="" label="--- Seleccionar ---" />
						<form:option value="1" label="1" />
						<form:option value="2" label="2" />
						<form:option value="3" label="3" />
						<form:option value="4" label="4" />

					</form:select>
				</div>


			</div>

			<div class="form-group">


				<label class="col-lg-2 control-label">&nbsp;Email: </label>
				<div class="col-lg-3">
					<form:input path="correoElectronico" class="form-control"
						required="required" />

				</div>
				<label class="col-lg-2 control-label">&nbsp;Imagen Perfil: </label>
				<!--  <div class="col-lg-3">
					<input id="doc" type="file" name="img" accept="application/jpg"
						value="Adjuntar" class="form-control" />

				</div>-->

			</div>

			<div class="form-group">
				<div class="col-lg-12" id="botonesAccionFormulario">

					<form:input type="submit" path="*" class="btn btn-primary"
						id="submitEditar" value="Editar" />
						
						
					<c:url var="backUsers" value="/loginUsers/admUsuarios" />
					<a type="button" href="${backUsers}" id="Cancelar"
						class="btn btn-default" data-dismiss="modal">Cancelar</a>
				</div>
			</div>



		</form:form>
	</div>
</div>
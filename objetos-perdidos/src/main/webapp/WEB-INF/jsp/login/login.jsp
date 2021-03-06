<%@ include file="/WEB-INF/jsp/includes/resource.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {

	});
</script>


<div class="container">
	<div id="area-Pantalla" class="row">

		<div class="container">

			<!-- HEADER -->
			<header> </header>
			<!-- END HEADER -->

			<div id="loginbox" style="margin-top: 50px;"
				class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="panel-title">Acceso de Usuario</div>
					</div>

					<div style="padding-top: 30px" class="panel-body">



						<c:url var="url" value="/loginUsers/validaSubmit" />
						<form:form action="${url}" method="POST" id="loginform"
							class="form-horizontal" modelAttribute="loginVO">

							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-user"></span>
								</span> <input id="login-username" type="text" class="form-control"
									name="userName" value="" placeholder="Usuario"
									required="required" />
							</div>

							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-lock"></i>
								</span> <input id="login-password" type="password" class="form-control"
									name="password" placeholder="Contrase�a" required="required" />
							</div>

							<div class="form-group" style="margin-top: 10px">
								<div class="col-sm-12 controls">
									<input type="submit" id="btn-login" value="Acceder"
										class="btn btn-primary" />
								</div>
							</div>


							<div id="mensajeLogin" class="alert alert-danger col-sm-12"
								role="alert">
								<p>${mensajeLogin}</p>
							</div>

							<div class="form-group">
								<div class="col-md-12 control">
									<div
										style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
										No tiene una cuenta? <a href="#"
											onClick="$('#loginbox').hide(); $('#rememberbox').show()">Registrate</a>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

			<div id="rememberbox" style="display: none; margin-top: 50px"
				class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">Crear cuenta</div>
						<div
							style="float: right; font-size: 85%; position: relative; top: -10px">
							<a id="signinlink" href="#"
								onclick="$('#rememberbox').hide(); $('#loginbox').show()">Volver</a>
						</div>
					</div>

					<div style="padding-top: 30px" class="panel-body">

						<div class="col-lg-12 area-trabajo">
							<c:url var="url" value="/loginUsers/addUsuarioPost" />
							<form:form method="POST" action="${url}" modelAttribute="loginVO"
								id="usuarioForm" class="form-horizontal" role="form">

								<div class="page-header col-lg-12 " id="areaTituloPantalla">
									<h3>Completa los siguientes datos</h3>
								</div>


								<div class="form-group">
									<div class="col-lg-12">
										<form:input path="userName" placeholder="User Name"
											class="form-control" required="required" />

									</div>
								</div>
								<div class="form-group">


									<div class="col-lg-12">
										<form:password placeholder="Password" path="password"
											class="form-control" required="required" />
									</div>



								</div>

								<div class="form-group">

									<div class="col-lg-12">
										<form:input placeholder="Nombre
										Completo"
											path="nombreCompleto" class="form-control"
											required="required" />
									</div>
								</div>
								<div class="form-group">

									<div class="col-lg-12">
										<form:input placeholder="C�dula" path="cedula"
											class="form-control" required="required" />
									</div>
								</div>



								<div class="form-group">
									
									<div class="col-lg-12">
										<form:input placeholder="Celular" path="celular" class="form-control"
											required="required" />
									</div>


								</div>

								<div class="form-group">


									<div class="col-lg-12">
										<form:input placeholder="Email" path="correoElectronico" class="form-control"
											required="required" />

									</div>


								</div>

								<div class="form-group">
									<div class="col-lg-12" id="botonesAccionFormulario">

										<form:input type="submit" path="*" class="btn btn-primary"
											id="submitEditar" value="Guardar" />
									</div>
								</div>



							</form:form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>



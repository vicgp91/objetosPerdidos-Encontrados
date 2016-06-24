	<div class="container">
		<div id="area-Pantalla" class="row">

			<div class="container">

				<!-- HEADER -->
				<header>
				<div class="row">
					<div class="col-lg-3 col-m-2 col-xs-3">
						<a href="/cyoe-idp/"
							title="Tribunal Electoral de Panam&aacute;"> <img
							src="/cyoe-idp/resources/images/logoTE.png" class="img-header" />
						</a>
					</div>
					<div class="col-lg-3 col-m-4 col-xs-3"></div>
					<div class="col-lg-6 col-m-6 col-xs-6" style="float: right">
						<img src="/cyoe-idp/resources/images/huella.png" class="img-header"
							align="right" />
					</div>
				</div>
				</header>
				<!-- END HEADER -->

				<div id="loginbox" style="margin-top: 50px;"
					class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">
								Acceso a Tribunal Electoral
							</div>
						</div>

						<div style="padding-top: 30px" class="panel-body">

							
							

							<form action="j_security_check" method="post" id="loginform"
								class="form-horizontal"
								enctype="application/x-www-form-urlencoded">

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-user"></i>
									</span> <input id="login-username" type="text" class="form-control"
										name="j_username" value=""
										placeholder="Usuario"
										required="required" />
								</div>

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-lock"></i>
									</span> <input id="login-password" type="password"
										class="form-control" name="j_password"
										placeholder="Contraseña"
										required="required" />
								</div>

								<div class="form-group" style="margin-top: 10px">
									<div class="col-sm-12 controls">
										<input type="submit" id="btn-login"
											value="Acceder"
											class="btn btn-primary" />
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-12 control">
										<div
											style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
											Ha olvidado su clave de acceso? 
											<a href="#"
												onClick="$('#loginbox').hide(); $('#rememberbox').show()">Recordar contrase&ntilde;a</a>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

				<div id="rememberbox" style="display: none; margin-top: 50px"
					class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">
								Recordar contrase&ntilde;a
							</div>
							<div
								style="float: right; font-size: 85%; position: relative; top: -10px">
								<a id="signinlink" href="#"
									onclick="$('#rememberbox').hide(); $('#loginbox').show()">Volver</a>
							</div>
						</div>

						<div style="padding-top: 30px" class="panel-body">

							<form action="/cyoe-idp/rememberPassword"
								id="signupform" class="form-horizontal">

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-envelope"></i>
									</span> <input type="text" class="form-control" name="email"
										placeholder="Correo Electronico"
										required="required">
								</div>

								<div class="form-group" style="margin-top: 10px">
									<!-- Button -->
									<div class="col-sm-12 controls">
										<input type="submit" id="btn-signup"
											value="Enviar"
											class="btn btn-success" />
									</div>
								</div>

							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>



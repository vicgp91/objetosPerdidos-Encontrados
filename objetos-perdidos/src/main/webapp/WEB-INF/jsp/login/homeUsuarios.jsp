<%@ include file="/WEB-INF/jsp/includes/resource.jsp"%>
<script type="text/javascript">
	$(document).ready(
			function() {

			
			});
</script>

<!-- Area de trabajo -->
<div id="area-trabajo" class="col-lg-12">

	<div class="page-header col-lg-12" id="areaTituloPantalla">
		<h3>
			Administración de Usuarios

				<button type="button" class="btn btn-default btn-info pull-right"
					data-toggle="modal" data-target="#divSearch" data-original-title
					title="Búsqueda" id="botonBuscar">
					<i class="glyphicon glyphicon-search"></i> Buscar
				</button>
			

			<c:url var="adduserUrl" value="/loginUsers/addUsuario" />
				<a href="${adduserUrl}" type="button" class="btn btn-default btn-success pull-right "
					id="agregarBtn"> <i class="glyphicon glyphicon-plus"></i>
					Agregar usuario
				</a>
			
		</h3>
	</div>

	<div id="areaListado" class="col-lg-12">
<table id="documentosList" class="table table-condensed table-hover">
					<thead>
		                <tr>
		                  <th>UserName</th>
		                  <th>Nombre Completo</th>
		                  <th>Perfil</th>
		                  <th>Celular</th>
		                  <th>Email</th>
		                  <th style="text-align:center;">Opciones</th>
		                </tr>
		            </thead>
		            <tbody>
		            	<c:forEach var="itemUsuario" items="${userList}">
		                	<tr>
								<td class="col-lg-2">${itemUsuario.userName}</td>
								<td class="col-lg-2">${itemUsuario.nombreCompleto}</td>
								<td class="col-lg-2">${itemUsuario.perfil}</td>
								<td class="col-lg-2">${itemUsuario.celular}</td>
								<td class="col-lg-2">${itemUsuario.correoElectronico}</td>
								<td class="col-lg-2" style="vertical-align: middle;text-align:center;">
							
							
							<c:url var="varEdit" value="/loginUsers/editUser/${itemUsuario.userName}"/>
										<a id="editarUsuario"
											href="${varEdit}"
											type="button" class="btn btn-success btn-sm dpdf"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Editar</a>
								
							
								        <c:url var="varDelete" value="/loginUsers/eliminar/${itemUsuario.userName}"/>
										<a id="deleteDoc" href="${varDelete}"
										type="button" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Eliminar</a>
									
								</td>
							</tr>
	                	</c:forEach>
					</tbody>
				</table>


	</div>
</div>


<div class="modal fade" id="divSearch" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="panel panel-primary" id="ventanaBusqueda">
			<div class="panel-heading">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4 class="panel-title" id="contactLabel">Búsqueda </h4>
			</div>

		</div>
	</div>
</div>

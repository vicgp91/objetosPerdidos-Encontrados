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
			Listado de Reportes
		</h3>
	</div>


<c:url var="rutaImg" value="http://localhost:8081/imagenes/" />
	<div id="areaListado" class="col-lg-12">
<table id="documentosList" class="table table-condensed table-hover">
					<thead>
		                <tr>
		                  <th>Registrado por:</th>
		                  <th>Titulo</th>
		                  <th>Descripción</th>
		                  <th>Email</th>
		                  <th>Estado</th>
		                  <th>Imagen</th>
		                  <th style="text-align:center;">Opciones</th>
		                </tr>
		            </thead>
		            <tbody>
		            	<c:forEach var="itemReportes" items="${reporteVO}">
		                	<tr>
								<td class="col-lg-2">${itemReportes.username}</td>
								<td class="col-lg-2">${itemReportes.reportetittle}</td>
								<td class="col-lg-2">${itemReportes.descripcion}</td>
								<td class="col-lg-2">${itemReportes.correo}</td>
								<td class="col-lg-1">${itemReportes.estado}</td>
								
								
								
								
								<td class="col-lg-2">
								
								<img height="300" width="300" src="${rutaImg}${itemReportes.foto}" class="img-responsive" alt="Cinque Terre">
								</td>
								
								
								<td class="col-lg-1" style="vertical-align: middle;text-align:center;">
							
							
							<c:url var="varEdit" value="/reportes/editReporte/${itemReportes.reporteid}"/>
							
							<c:if test="${itemReportes.estado != 'Entregado'}">
							
							<c:if test="${loginSesion.perfil != '1'}">
										<a id="EditarRep"
											href="${varEdit}"
											type="button" class="btn btn-success btn-sm dpdf"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Entregar</a>
								</c:if>
							</c:if>
								  
									
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

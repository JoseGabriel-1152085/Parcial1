<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Pacientes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
		
		<ul class="navbar-nav">
			<li><a class="nav-link" href="<%= request.getContextPath()%>/list">Pacientes</a></li>l
		</ul>
	</nav>
	<br>
	
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${paciente != null }">
					<form action="update" method="post">
				</c:if>
				<c:if test="${paciente == null }">
					<form action="insert" method="post">
				</c:if>
				
				<caption>
					<h2>
						<c:if test="${paciente != null }">
							Editar paciente
						</c:if>
						
					</h2>
				</caption>
				
				
				<c:if test="${paciente != null }">
					<input type="hidden" name="id" value="<c:out value='${paciente.id }' />" />
				</c:if>
				
				
				<fieldset class="form-group">
					<label>Documento de paciente</label> <input type="text" value='<c:out value="${paciente.documento}"   />'  class="form-control" name="documento" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Nombre de paciente</label> <input type="text" value="<c:out value='${paciente.nombre }' /> " class="form-control" name="nombre" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Apellido de paciente</label> <input type="text" value="<c:out value='${paciente.apellido }' /> " class="form-control" name="apellido" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email de paciente</label> <input type="text" value="<c:out value='${paciente.email }' /> " class="form-control" name="email" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Genero de paciente</label> <input type="text" value="<c:out value='${paciente.genero }' /> " class="form-control" name="genero" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Fecha de paciente</label> <input type="text" value="<c:out value='${paciente.fecha }' /> " class="form-control" name="fecha" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Telefono de paciente</label> <input type="text" value="<c:out value='${paciente.telefono }' /> " class="form-control" name="telefono" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Direccion de paciente</label> <input type="text" value="<c:out value='${paciente.direccion }' /> " class="form-control" name="direccion" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Peso de paciente</label> <input type="text" value="<c:out value='${paciente.peso }' /> " class="form-control" name="peso" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Estatura de paciente</label> <input type="text" value="<c:out value='${paciente.estatura }' /> " class="form-control" name="estatura" required="required">
				</fieldset>|
				<br>
				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		
		</div>
	</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"></script>
</html>
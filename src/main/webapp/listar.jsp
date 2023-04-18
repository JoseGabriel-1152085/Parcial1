<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Pacientes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<header>
	<nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
		
		<ul class="navbar-nav">
			<li><a class="nav-link" href="<%= request.getContextPath()%>/list">Paciente</a></li>l
		</ul>
	</nav>
</header>


<div class="container">
		<h3 class="text-center">Lista de Pacientes</h3>
		<br>
		
		<div class="container text-left">
			<a href="<%= request.getContextPath()%>/new" class="btn btn-success">Agregar nuevo Paciente</a>
		</div>
		
		<br>
		
		<table class="table table-bordered">
			<thead>
				
				<tr>
					<td>ID</td>
					<td>Documento</td>
					<td>Nombre</td>
					<td>Apellido</td>
					<td>Email</td>
					<td>Genero</td>
					<td>Fecha</td>
					<td>Telefono</td>
					<td>Direccion</td>
					<td>Peso</td>
					<td>Estatura</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="paciente" items="${listPacientes}">
				<%
					if(request.getAttribute("listPacientes") == null){
					    out.println("La lista de pacientes no se ha recibido correctamente.");
					}
				%>
				
				
					<tr>
						<td>
							<c:out value="${paciente.id}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.documento}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.nombre}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.apellido}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.email}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.genero}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.fecha}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.telefono}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.direccion}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.peso}"></c:out>
						</td>
						<td>
							<c:out value="${paciente.estatura}"></c:out>
						</td>
						<td><a href="edit?id=<c:out value='${paciente.id}' />">Actualizar Paciente</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${paciente.id}' />">Eliminar</a></td>
					</tr>
				
				</c:forEach>
			
			</tbody>
		
		</table>
	</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</html>
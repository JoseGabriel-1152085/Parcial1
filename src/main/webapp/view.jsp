<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ver Paciente</title>
</head>
<body>
	<h1>Información del Paciente</h1>
	<table>
		<tr>
			<td><strong>ID:</strong></td>
			<td>${paciente.id}</td>
		</tr>
		<tr>
			<td>Documento:</td>
			<td><c:out value="${paciente.documento}" /></td>
		</tr>
		<tr>
			<td>Nombre:</td>
			<td><c:out value="${paciente.nombre}" /></td>
		</tr>
		<tr>
			<td>Apellido:</td>
			<td><c:out value="${paciente.apellido}" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><c:out value="${paciente.email}" /></td>
		</tr>
		<tr>
			<td>Género:</td>
			<td><c:out value="${paciente.genero}" /></td>
		</tr>
		<tr>
			<td>Fecha de nacimiento:</td>
			<td><c:out value="${paciente.fechaNacimiento}" /></td>
		</tr>
		<tr>
			<td>Teléfono:</td>
			<td><c:out value="${paciente.telefono}" /></td>
		</tr>
		<tr>
			<td>Dirección:</td>
			<td><c:out value="${paciente.direccion}" /></td>
		</tr>
		<tr>
			<td>Peso:</td>
			<td><c:out value="${paciente.peso}" /></td>
		</tr>
		<tr>
			<td>Estatura:</td>
			<td><c:out value="${paciente.estatura}" /></td>
		</tr>
		<tr>
			<td>IMC:</td>
			<td><c:out value="${paciente.imc}" /></td>
		</tr>
		<tr>
			<td>Estado:</td>
			<td><c:out value="${paciente.estado}" /></td>
		</tr>
	</table>
	<br>
	<a href="listar">Volver al listado de estudiantes</a>
</body>
</html>

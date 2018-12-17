<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Eventos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container">
	<h1>Lista de eventos</h1>
	<table class="table table-hover">
		<tr>
			<th>DESCRIÇÃO</th>
			<th>DATA</th>
			<th>RESPONSAVEL</th>
			<th></th>
		</tr>
		<c:forEach var="e" items="${eventos}">
		<tr>
			<td>${e.descricao}</td>
			<td>${e.data}</td>
			<td>${e.responsavel}</td>
			<td><a href=<c:url value="/convidados/lista?idEvento=${e.id}" />>Ver convidados</a></td>
		</tr>		
		</c:forEach>
	</table>
	</div>
</body>
</html>
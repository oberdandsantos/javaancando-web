<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busca Convidados</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ include file="cabecalho.jsp"%>
	<div class="container" style="margin-top: 50px;">
		<div class="row">
			<div class="col-sm-8">
				<h3>Lista de Convidados</h3>

				<div class="form-horizontal">
					<form method="get" action="busca">

						<div class="form-group">
							<label class="control-label col-sm-3">Eventos:</label>
							<div class="col-sm-9">
							
								<select name="id" class="form-control">
									<c:forEach var="ev" items="${lista_eventos}">
										<c:choose>
											<c:when test="${ev.id eq id_selected}"> 
											<option selected="selected" value="${ev.id}">${ev.descricao}</option>
											</c:when>

										<c:otherwise>
											<option value="${ev.id}">${ev.descricao}</option>
										</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
								
							</div>
						</div>
						<!-- Botão enviar -->
						<div class="form-group">
							<input type="submit" value="Buscar convidados"
								class="btn btn-info" />
						</div>
					</form>
				</div>
			</div>

			<div class="col-sm-6">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>CPF</td>
							<td>NOME</td>
							<td>TELEFONE</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ev" items="${lista_convidados}">
							<tr>
								<td>${ev.cpf}</td>
								<td>${ev.nome}</td>
								<td>${ev.telefone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>

	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
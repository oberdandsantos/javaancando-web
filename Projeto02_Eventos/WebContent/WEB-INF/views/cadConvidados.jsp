<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Convidados</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>



	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ include file="cabecalho.jsp"%>

	<div class="container" style="margin-top: 50px;">
		<div class="row">
			<div class="col-sm-6">
				<h3>Dados do Convidado</h3>

				<div class="form-horizontal">
					<form method="post" action="convidados">


						<div class="form-group">
							<label class="control-label col-sm-3">Eventos:</label>
							<div class="col-sm-9">
								<select name="evento" class="form-control">
									<c:forEach var="ev" items="${lista_eventos}">
										<option value="${ev.id}">${ev.descricao}</option>
									</c:forEach>
								</select>

							</div>
						</div>

						<!-- CPF DO CONVIDADO -->
						<div class="form-group">
							<label class="control-label col-sm-3">Cpf do Convidado:</label>
							<div class="col-sm-9">
								<input type="text" name="cpf" class="form-control" />
							</div>
						</div>

						<!-- NOME CONVIDADO -->
						<div class="form-group">
							<label class="control-label col-sm-3">Nome do Convidado:</label>
							<div class="col-sm-9">
								<input type="text" name="nome" class="form-control" />
							</div>
						</div>

						<!-- TELEFONE DO CONVIDADO -->
						<div class="form-group">
							<label class="control-label col-sm-3">Telefone do
								convidado:</label>
							<div class="col-sm-5">
								<input type="text" name="telefone" class="form-control" />
							</div>
						</div>

						<!-- E-mail do convidado -->
						<div class="form-group">
							<label class="control-label col-sm-3"> E-mail do
								convidado:</label>
							<div class="col-sm-9">
								<input type="text" name="email" class="form-control" />
							</div>
						</div>

						<!-- Botão enviar -->
						<div class="form-group">
							<input type="submit" value="Incluir convidado"
								class="btn btn-info" />
						</div>
					</form>

				</div>
			</div>

			<div class="col-sm-6">
				<h3>Lista de convidados</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Cpf</td>
							<td>Nome</td>
							<td>Telefone</td>
							<td>Email</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ev" items="${lista_convidados}">
							<tr>
								<td>${ev.cpf}</td>
								<td>${ev.nome}</td>
								<td>${ev.telefone}</td>
								<td>${ev.email}</td>
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
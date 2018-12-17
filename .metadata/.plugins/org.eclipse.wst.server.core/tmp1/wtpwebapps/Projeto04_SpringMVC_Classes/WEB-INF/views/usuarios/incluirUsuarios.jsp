<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuários</title>
</head>
<body>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<h1>Cadastro de Usuarios</h1>

	<div>${mensagem}</div>

	<form action=<c:url value="/usuarios/cadusuario"/> method="post">
	
		<label>Nome:</label><br /> 
		<input type="text" name="nome"><br />
		<form:errors path="usuario.nome" />

		<label>Senha:</label><br /> 
		<input type="password" name="senha"><br />
		<form:errors path="usuario.senha" />

		<label>Nível:</label><br/>
		<select name="nivel">
			<option value="1">Administrador</option>
			<option value="2">Convidado</option>			
		</select>

		<input type="submit" name="Incluir Usuario"><br />

	</form>
</body>
</html>
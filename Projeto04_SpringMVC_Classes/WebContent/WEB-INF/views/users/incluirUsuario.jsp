<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usu�rios</title>
</head>
<body>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Cadastro de Usu�rios</h1>
	
	<div>${mensagem}</div>
	
		<form action=<c:url value="/users/cadusuario" /> method="post">
		
		<label>Nome:</label>
		<input type="text" name="login"><br/>

		<label>Senha:</label>
		<input type="password" name="password"><br/>

		<input type="submit" value="Incluir usuario"/>
				
		</form>
		
</body>
</html>
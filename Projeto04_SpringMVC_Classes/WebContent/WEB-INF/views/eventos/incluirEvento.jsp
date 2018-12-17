<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Eventos</title>
</head>
<body>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h1>Cadastro de Eventos</h1>
	
	<div>${mensagem}
	</div>
	
	<form action=<c:url value="/eventos/cadevento"/> method="post">
	<label>Descrição:</label><br/>
	<input type="text" name="descricao"><br/>
	
	<label>Responsável:</label><br/>
	<input type="text" name="responsavel"><br/>

	<label>Data:</label><br/>
	<input type="date" name="dataString"><br/>

	<label>Preço:</label><br/>
	<input type="text" name="preco"><br/>

	<input type="submit" name="Incluir Evento"><br/>

	</form>
</body>
</html>
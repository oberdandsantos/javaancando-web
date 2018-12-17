<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu de Op��es</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h1>Menu de Op��es</h1>
	<ul>
		<li><a href=<c:url value="/eventos/cadastro"/>>Cadastro de Eventos</a></li>
		<li><a href=<c:url value="/eventos/lista"/>>Cadastro de Eventos</a></li>		
		<li><a href=<c:url value="/convidados/cadastro"/>>Cadastro de Convidados</a></li>
		<li><a href=<c:url value="/convidados/lista"/>>Cadastro de Convidados</a></li>
		<li><a href=<c:url value="/convidados/listaAjax"/>>Cadastro de Convidados (Ajax)</a></li>
		<li><a href=<c:url value="/usuarios/cadastro"/>>Cadastro de Usu�rios</a></li>
		<li><a href=<c:url value="/users/cadastro"/>>Cadastro de Users</a></li>		
	</ul>
</body>
</html>
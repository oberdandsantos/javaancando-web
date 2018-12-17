<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exemplos Javascript</title>
</head>
<body>

	<h1>Simulando cadastro de pessoas</h1>

	<label>Nome:</label>
	<br />
	<input type="text" id="nome" />
	<br />

	<label>Idade:</label>
	<br />
	<input type="number" id="idade" />
	<br />

	<input type="button" value="Mostrar " id="btnMostrar" />
	<br>
	<div id="resposta"></div>

	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btnMostrar").click();
			
			var nomePessoa = $("#nome").val();
			var idadePessoa = $("#idade").val();

			var mensagem = 'Nome: ' + nomePessoa + '\nIdade: ' + idadePessoa;

			$("#resposta").html(mensagem);

		});
	
		function mostrarDados() {
			//obtendo os valores dos campos de entrada
// 			var nomePessoa = document.getElementById("nome").value;
// 			var idadePessoa = document.getElementById("idade").value;

			var nomePessoa = $("#nome").val();
			var idadePessoa = $("#idade").val();
						
			//criando a resposta
			var mensagem = 'Nome: ' + nomePessoa + '\nIdade: ' + idadePessoa;

			//exibindo a resposta
			//alert(mensagem);
			$("#resposta").html(mensagem);
		}

// 		var botao = document.getElementById("btnMostrar");
// 		botao.addEventListener('click', mostrarDados);//callback
	</script>

</body>
</html>
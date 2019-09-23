<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="utf-8">
<title>Nac Valet</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<section class="container">
		<h1 class="title">Avenger´s Park</h1>
		<c:choose>
		<c:when test="${not empty usuario}">
		<div class="form-valet">
			<form action="registrar_valet" method="post">
				<label>Placa: <input class="big" type="text" name="placa"
					placeholder="Informe a placa do veículo" required />
				</label> <label>Marca: <input class="big" type="text" name="marca"
					placeholder="Informe a marca do veículo" required />
				</label> <label>Modelo: <input class="big" type="text" name="modelo"
					placeholder="Informe o modelo do veículo" required />
				</label>
				<button>Registrar</button>
			</form>
		</div>
		<hr />
		<div class="tabela-valet">
			<h1 class="subtitle">Veículos Estacionados</h1>
			<table>
				<thead>
					<tr>
						<th>Placa</th>
						<th>Marca</th>
						<th>Modelo</th>
						<th>Entrada</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="valet" items="${valets}">
						<tr>
							<td>${valet.veiculo.placa}</td>
							<td>${valet.veiculo.marca}</td>
							<td>${valet.veiculo.modelo}</td>
							<td>${valet.entradaEmTexto}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</c:when>
		<c:otherwise>
			<p class="subtitle">Você precisa autenticar-se.</p>
			<a href="index.jsp">Voltar para tela de autenticação</a>
		</c:otherwise>
		</c:choose>
	</section>
</body>
</html>
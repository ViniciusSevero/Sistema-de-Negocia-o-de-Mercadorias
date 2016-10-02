<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Negociações</title>
	<%@ include file="includes.jsp" %>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div class="container">
		
		<div class="alert ${classe}">
			${msg}	
		</div>
		
		<h1>Lista de Negociações</h1>
		
		<table class="table">
				<tr>
					<th>Cod. Mercadoria</th>
					<th>Tipo Mercadoria</th>
					<th>Nome</th>
					<th>Qtde.</th>
					<th>Preço</th>
					<th>Tipo do Negócio</th>
					<th>Operações</th>
				</tr>
				<c:forEach items="${lista}" var="negociacao">
						<tr class="${negociacao.codMercadoria}">
							<td>${negociacao.codMercadoria}</td>
							<td>${negociacao.tipoMercadoria}</td>
							<td>${negociacao.nomeMercadoria}</td>
							<td>${negociacao.qtde}</td>
							<td><fmt:formatNumber value="${negociacao.preco}" type="currency" currencySymbol="R$"/></td>
							<td>${negociacao.tipoNegocio}</td>
							<td>
								<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalExcluir" onclick="codMercadoria2.value = ${negociacao.codMercadoria}">
								  Excluir
								</button>
								<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#modalEditar" onclick="prepararEdicao(${negociacao.codMercadoria})">
								  Editar
								</button>
							</td>
						</tr>
				</c:forEach>
			</table>
	</div>
	
	<%@ include file="WEB-INF/modals/modalExcluir.jsp" %>
	<%@ include file="WEB-INF/modals/modalEditar.jsp" %>
</body>
</html>
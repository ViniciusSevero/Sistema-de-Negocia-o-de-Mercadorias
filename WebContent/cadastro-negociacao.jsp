<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Negociações</title>
	<%@ include file="includes.jsp" %>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div class="container">
		
		<div class="alert ${classe}" id="erros">
			${msg}	
		</div>
		
		<h1>Cadastrar Negociação</h1>
		
		<form method="post" action="Negociacao" onsubmit="return validarCadastro()">
			<input type="hidden" name="acao" value="cadastrar"> 
			
			<div class="form-group">
				<label for="codMercadoria">Código da Mercadoria</label>
				<input type="text" class="form-control" id="codMercadoria" name="codMercadoria">
			</div>
			<div class="form-group">
				<label for="tipoMercadoria">Tipo da Mercadoria</label>
				<input type="text" class="form-control" id="tipoMercadoria" name="tipoMercadoria">
			</div>
			<div class="form-group">
				<label for="nomeMercadoria">Nome da Mercadoria</label>
				<input type="text" class="form-control" id="nomeMercadoria" name="nomeMercadoria">
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="qtde">Quantidade</label>
						<input type="text" class="form-control" id="qtde" name="qtde">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="preco">Preço</label>
						<input type="text" class="form-control" id="preco" name="preco">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="tipoNegocio">Tipo do Negócio</label>
				<select id="tipoNegocio" name="tipoNegocio" class="form-control">
					<option>Compra</option>
					<option>Venda</option>
				</select>
			</div>
			<div class="form-group">
				<input type="submit" value="Cadastrar" class="btn btn-primary">
			</div>
		</form>
	</div>
</body>
</html>
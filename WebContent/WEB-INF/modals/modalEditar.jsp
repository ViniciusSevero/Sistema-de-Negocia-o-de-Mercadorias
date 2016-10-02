<!-- Modal Editar -->
	<div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Editar Negociação<img class="loading" src="img/loading.gif" width="50"/></h4>
	      </div>
	      <div class="modal-body">
		    <div class="alert alert-danger" id="erros">
		    	
			</div>
	       	<form method="post" action="Negociacao" onsubmit="return validarCadastro()">
				<input type="hidden" name="acao" value="editar"> 
					
				<input type="hidden" class="form-control" id="codMercadoria" name="codMercadoria">
				
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
					<input type="submit" value="Salvar" class="btn btn-primary">
				</div>
			</form>
	      </div>
	    </div>
	  </div>
	</div>
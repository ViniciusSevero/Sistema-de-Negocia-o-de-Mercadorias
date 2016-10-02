	<!-- Modal Excluir -->
	<div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Confirmação</h4>
	      </div>
	      <div class="modal-body">
	        <p>Deseja excluir a negociação selecionada?</p>
	      </div>
	      
	      <div class="modal-footer">
	        <form onsubmit="return excluir()">
	      		<input type="hidden" name="codMercadoria" id="codMercadoria2">
	      		<img class="loading" src="img/loading.gif" width="50""/>
		        <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
		        <input type="submit" class="btn btn-danger" value="Sim"/>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
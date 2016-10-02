function validarCadastro(){
	var erros = [];
	limpar();
	var codMercadoria = $("#codMercadoria");
	var tipoMercadoria = $("#tipoMercadoria");
	var nomeMercadoria = $("#nomeMercadoria");
	var qtde = $("#qtde");
	var preco = $("#preco");
	var alert = $("#erros");
	
	
	if(!$.isNumeric($(codMercadoria).val()) || parseInt($(codMercadoria).val())<=0 || $(codMercadoria).val().indexOf(".") != -1){
		erros.push("Digite apenas números inteiros positivos para o código da mercadoria");
		$(codMercadoria).parent().addClass("has-error");
	}
	
	if(!$.isNumeric($(qtde).val()) || parseInt($(qtde).val())<=0 || $(qtde).val().indexOf(".") != -1){
		erros.push("Digite apenas números inteiros positivos para a quantidade");
		$(qtde).parent().addClass("has-error");
	}
	
	if(!$.isNumeric($(preco).val()) || parseInt($(preco).val())<=0){
		erros.push("Digite apenas números positivos para o preço");
		$(preco).parent().addClass("has-error");
	}
	
	if($(tipoMercadoria).val() == ""){
		erros.push("Preencha o campo Tipo da Mercadoria");
		$(tipoMercadoria).parent().addClass("has-error");
	}
	
	if($(nomeMercadoria).val() == ""){
		erros.push("Preencha o campo Nome da Mercadoria");
		$(nomeMercadoria).parent().addClass("has-error");
	}
	
	if(erros.length > 0){
		$(alert).css("display","block");
		$(alert).addClass("alert-danger");
		for(var i = 0;i<erros.length;i++){
			$(alert).html($(alert).html() + " - "+erros[i]+"<br/>");  
		}
		
		return false;
	}
	return true;
	
}
function limpar(){
	var alert = $("#erros");
	$(alert).html("");
	$(alert).css("display","none");
	$(alert).removeClass("alert-danger");
	$("input").parent().removeClass("has-error");
}

function excluir(){
	var codMercadoria = $("#codMercadoria2").val();
	
	$(".loading").show();
	$(".modal-footer form input, .modal-footer form button").prop("disabled", true);
	
	$.ajax({
	  url: 'Negociacao',
	  type: 'POST',
	  data: {'acao': "excluir", 'codMercadoria' : codMercadoria} ,
	  success: function () {
		$("tr."+codMercadoria).fadeOut("slow", function() {
		    $(this).remove();
		});
	  },
	  error: function (errorThrown) {
	    alert("Erro, tente novamente mais tarde");
	  },   
	  complete: function(){
		$(".modal-footer form input, .modal-footer form button").prop("disabled", false);
		$(".loading").hide();
		
		$("#modalExcluir").modal('toggle');
	  }
	});
	
	return false;
}

function prepararEdicao(codMercadoria){
	$("#codMercadoria").val(codMercadoria); //setar para o input hidden do form alterar
	
	$(".loading").show();
	$(".modal-body form input, .modal-body form select").prop("disabled", true);
	
	//buscar Negociação com esse codMercadoria
	$.ajax({
	  url: 'Negociacao',
	  type: 'GET',
	  data: {'acao': "buscar", 'codMercadoria' : codMercadoria} ,
	  success: function (json) {
		$("#tipoMercadoria").val(json.tipoMercadoria);
		$("#nomeMercadoria").val(json.nomeMercadoria);
		$("#preco").val(json.preco);
		$("#qtde").val(json.qtde);
		$('#tipoNegocio option').attr('selected', false); //deixa todos os options deselecionados para ficar só um selecioando
		$('#tipoNegocio option').each(function() {
	      // se localizar a frase, define o atributo selected
	      if($(this).text() == json.tipoNegocio) {
	        $(this).attr('selected', true);
	      }
	    });
	  },
	  error: function () {
	    alert("Erro, tente novamente mais tarde");
	  },   
	  complete: function(){
		$(".modal-body form input, .modal-body form select").prop("disabled", false);
		$(".loading").hide();
		
	  }
	});
		
	
	
}
package br.com.snm.beans;

public class Negociacao {
	private int codMercadoria;
	private String tipoMercadoria;
	private String nomeMercadoria;
	private int qtde;
	private double preco;
	private String tipoNegocio;
	
	public Negociacao() {
		// TODO Auto-generated constructor stub
	}
	
	public Negociacao(int codMercadoria, String tipoMercadoria, String nomeMercadoria, int qtde, double preco,
			String tipoNegocio) {
		super();
		this.codMercadoria = codMercadoria;
		this.tipoMercadoria = tipoMercadoria;
		this.nomeMercadoria = nomeMercadoria;
		this.qtde = qtde;
		this.preco = preco;
		this.tipoNegocio = tipoNegocio;
	}

	public int getCodMercadoria() {
		return codMercadoria;
	}

	public void setCodMercadoria(int codMercadoria) {
		this.codMercadoria = codMercadoria;
	}

	public String getTipoMercadoria() {
		return tipoMercadoria;
	}

	public void setTipoMercadoria(String tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}

	public String getNomeMercadoria() {
		return nomeMercadoria;
	}

	public void setNomeMercadoria(String nomeMercadoria) {
		this.nomeMercadoria = nomeMercadoria;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	
	
	
	
}

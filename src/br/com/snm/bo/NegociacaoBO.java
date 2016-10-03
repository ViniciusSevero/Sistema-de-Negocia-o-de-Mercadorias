package br.com.snm.bo;

import java.sql.Connection;
import java.util.List;

import br.com.snm.beans.Negociacao;
import br.com.snm.dao.NegociacaoDAO;

public class NegociacaoBO {
	private NegociacaoDAO dao;
	
	public NegociacaoBO(Connection con) throws Exception {
		this.dao = new NegociacaoDAO(con);
	}
	
	public void add(Negociacao n) throws Exception{
		validarNegociacao(n);
		dao.add(n);
	}
	
	public List<Negociacao> getAll() throws Exception{
		return dao.getAll();
	}
	
	public void delete(int codMercadoria) throws Exception{
		dao.delete(codMercadoria);
	}
	
	public void edit(Negociacao n) throws Exception{
		validarNegociacao(n);
		dao.edit(n);
	}
	
	public void validarNegociacao(Negociacao n) throws Exception{
		if(n.getCodMercadoria() <= 0){
			throw new Exception("C�digo da mercadoria deve ser um n�emro inteiro positivo");
		}else if(n.getQtde() <= 0){
			throw new Exception("Quantidade deve ser um n�emro inteiro positivo");
		}else if(n.getPreco() <= 0){
			throw new Exception("Pre�o deve ser um n�mero positivo");
		}else if(n.getTipoMercadoria() == null || n.getTipoMercadoria().trim().equals("")){
			throw new Exception("Tipo da Mercadoria n�o pode ser nulo ou vazio");
		}else if(n.getNomeMercadoria() == null || n.getNomeMercadoria().trim().equals("")){
			throw new Exception("Nome da Mercadoria n�o pode ser nulo ou vazio");
		}
	}
	public Negociacao find(int codMercadoria) throws Exception{
		return dao.find(codMercadoria);
	}
}

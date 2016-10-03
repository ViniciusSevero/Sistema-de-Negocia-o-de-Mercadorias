package br.com.snm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import br.com.snm.beans.Negociacao;
import br.com.snm.connection.ConexaoFactory;

public class NegociacaoDAO {
	private Connection con;
	
	public NegociacaoDAO(Connection con) throws Exception {
		this.con = con;
	}
	
	public void add(Negociacao n) throws Exception{
		PreparedStatement ps = con.prepareStatement("INSERT INTO `t_snm_negociacao`(`cd_mercadoria`, `ds_tipo_mercadoria`, `nm_mercadoria`, `qt_mercadoria`, `vl_preco`, `ds_tipo_negocio`) VALUES (?,?,?,?,?,?)");
		ps.setInt(1, n.getCodMercadoria());
		ps.setString(2, n.getTipoMercadoria());
		ps.setString(3, n.getNomeMercadoria());
		ps.setInt(4, n.getQtde());
		ps.setDouble(5, n.getPreco());
		ps.setString(6, n.getTipoNegocio());
		ps.execute();
		ps.close();
	}
	
	public List<Negociacao> getAll() throws Exception{
		List<Negociacao> negociacoes = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM `t_snm_negociacao`");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			negociacoes.add(new Negociacao(
				rs.getInt("cd_mercadoria"),
				rs.getString("ds_tipo_mercadoria"),
				rs.getString("nm_mercadoria"),
				rs.getInt("qt_mercadoria"),
				rs.getDouble("vl_preco"),
				rs.getString("ds_tipo_negocio")
			));
		}
		rs.close();
		ps.close();
		
		return negociacoes;
	}
	
	public void delete(int codMercadoria) throws Exception{
		PreparedStatement ps = con.prepareStatement("DELETE FROM `t_snm_negociacao` WHERE cd_mercadoria = ?");
		ps.setInt(1, codMercadoria);
		ps.execute();
		ps.close();
	}
	
	public void edit(Negociacao n) throws Exception{
		PreparedStatement ps = con.prepareStatement("UPDATE `t_snm_negociacao` SET `ds_tipo_mercadoria`=?,`nm_mercadoria`=?,`qt_mercadoria`=?,`vl_preco`=?,`ds_tipo_negocio`=? WHERE `cd_mercadoria`=?");
		ps.setString(1, n.getTipoMercadoria());
		ps.setString(2, n.getNomeMercadoria());
		ps.setInt(3, n.getQtde());
		ps.setDouble(4, n.getPreco());
		ps.setString(5, n.getTipoNegocio());
		ps.setInt(6, n.getCodMercadoria());
		ps.execute();
		ps.close();
	}
	
	public Negociacao find(int codMercadoria) throws Exception{
		PreparedStatement ps = con.prepareStatement("SELECT * FROM `t_snm_negociacao` where cd_mercadoria = ?");
		ps.setInt(1, codMercadoria);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Negociacao n =  new Negociacao(
							rs.getInt("cd_mercadoria"),
							rs.getString("ds_tipo_mercadoria"),
							rs.getString("nm_mercadoria"),
							rs.getInt("qt_mercadoria"),
							rs.getDouble("vl_preco"),
							rs.getString("ds_tipo_negocio")	
						);
		rs.close();
		ps.close();
		return n;
	}
}

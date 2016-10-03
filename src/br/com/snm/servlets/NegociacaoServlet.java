package br.com.snm.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.snm.beans.Negociacao;
import br.com.snm.bo.NegociacaoBO;

@WebServlet("/Negociacao")
public class NegociacaoServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		
		NegociacaoBO bo = null;
		try {
			bo = new NegociacaoBO(getCon(req));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		switch (acao) {
		case "cadastrar":
			try {
				bo.add(getNegociacao(req));
				redirecionar("Negociação cadastrada com sucesso","alert-success","cadastro-negociacao.jsp", req, resp);
			} catch (Exception e) {
				redirecionar(e.getMessage(), "alert-danger" ,"cadastro-negociacao.jsp", req, resp);
			}
			break;
		case "excluir":
			int codMercadoria = Integer.parseInt(req.getParameter("codMercadoria"));
			try {
				bo.delete(codMercadoria);
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
			
			break;
		case "editar":
			try {
				bo.edit(getNegociacao(req));
				resp.sendRedirect("Negociacao");
			} catch (Exception e) {
				//caso o cliente desabilite o javascript durante a edição
				try {
					req.setAttribute("lista", bo.getAll());
					req.setAttribute("msg", e.getMessage());
					req.setAttribute("classe", "alert-danger");
					req.getRequestDispatcher("lista-negociacoes.jsp").forward(req, resp);
				} catch (Exception ex) {
					e.printStackTrace();
				}
			}
			break;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NegociacaoBO bo = null;
		try {
			bo = new NegociacaoBO(getCon(req));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
				
		if(req.getParameter("acao") != null && req.getParameter("acao").equals("buscar")){
			int codMercadoria = Integer.parseInt(req.getParameter("codMercadoria"));
			try {
				Negociacao n = bo.find(codMercadoria);
				String json = new Gson().toJson(n);
				resp.setContentType("application/json");
				resp.getWriter().write(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				req.setAttribute("lista", bo.getAll());
				req.getRequestDispatcher("lista-negociacoes.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void redirecionar(String msg, String classeAlerta, String caminho, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setAttribute("msg", msg);
		req.setAttribute("classe", classeAlerta);
		req.getRequestDispatcher(caminho).forward(req, resp);
	}
	
	public Negociacao getNegociacao(HttpServletRequest req) throws Exception{
		return new Negociacao(
			Integer.parseInt(req.getParameter("codMercadoria")),
			req.getParameter("tipoMercadoria"),
			req.getParameter("nomeMercadoria"),
			Integer.parseInt(req.getParameter("qtde")),
			Double.parseDouble(req.getParameter("preco")),
			req.getParameter("tipoNegocio")
		);
	}
	public Connection getCon(HttpServletRequest request){
		return (Connection) request.getAttribute("conexao");
	}
	

}

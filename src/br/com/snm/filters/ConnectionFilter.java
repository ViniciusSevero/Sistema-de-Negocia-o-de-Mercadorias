package br.com.snm.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.snm.connection.ConexaoFactory;

@WebFilter("/*")
public class ConnectionFilter implements Filter {

	private Connection con;
		
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setAttribute("conexao", this.con);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		try {
			this.con = new ConexaoFactory().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

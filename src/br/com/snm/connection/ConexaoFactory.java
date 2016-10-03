package br.com.snm.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
	public static Connection getConnection() throws Exception{
		String url = "jdbc:mysql://mysql107866-viniciussevero.jelasticlw.com.br/Principal";
		//String url = "jdbc:mysql://localhost:3306/Principal";
		String usuario = "root";
		String senha = "BXLnpa56139";
		//String senha = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection(url,usuario,senha);
	}
}

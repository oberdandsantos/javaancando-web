package br.com.allianz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Dao<T, K> {

	// ELEMENTOS DE ACESSO DA DADOS
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;

	// STRING DE CONEXAO - JDBC MYSQL
	private String conexao = "jdbc:mysql://localhost:3306/db_eventos";

	// MÉTODO PARA ABRIR A CONEXÃO COM O BANCO DE DADOS
	protected void abrirConexao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(conexao, "root", "p@ssword");
	}

	protected void fecharConexao() throws Exception {
		if (cn != null && !cn.isClosed()) {
			cn.close();
		}
	}
	
	public abstract void incluir(T Elemento) throws Exception;
	public abstract T Buscar(K chave) throws Exception;

}

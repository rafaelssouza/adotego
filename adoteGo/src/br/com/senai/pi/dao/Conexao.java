package br.com.senai.pi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	String dbURL = "jdbc:mysql://localhost:3306/sampledb";
	String username = "root";
	String password = "secret";

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

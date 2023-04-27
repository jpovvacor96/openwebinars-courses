package com.openwebinars.jdbc.crud;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MyDataSource {
	
	private static HikariConfig config=new HikariConfig();
	
	private static HikariDataSource dataSource;
	
	static {
		config.setJdbcUrl("jdbc:mysql://localhost/instituto");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty("maximumPoolSize", 1);
		//Configuraciones recomendadas para MySQL
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		dataSource=new HikariDataSource(config);
	}
	
	private MyDataSource() {
		
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

}

package com.openwebinars.jdbc.crud;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		
		try(Connection conexion=MyDataSource.getConnection()){
			DatabaseMetaData metaData=conexion.getMetaData();
			//Obtenemos las tablas registradas en la base de datos
			String[] types= {"TABLE"};
			ResultSet tables=metaData.getTables(null, null, null, types);
			while(tables.next()) {
				System.out.println(tables.getString("TABLE_NAME"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace(); 
		}
		
	}
}

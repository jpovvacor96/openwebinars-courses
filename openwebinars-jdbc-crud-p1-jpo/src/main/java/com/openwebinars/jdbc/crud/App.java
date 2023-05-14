package com.openwebinars.jdbc.crud;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import dao.EmpleadoDaoImpl;
import pool.MyDataSource;

import java.sql.DatabaseMetaData;
import model.Empleado;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		System.out.println("Hola \n Final");
		new Menu().init();
		
	}
	
	public static void testDao() {
		EmpleadoDaoImpl dao=EmpleadoDaoImpl.getInstance();
		Empleado emp=new Empleado("Luis Miguel", "López Magaña", LocalDate.of(1982, 9, 18),
				"Profesor", "luismi@openwebinars.net");
		try {
			int n=dao.add(emp);
			System.out.println("Número de registros insertados: "+n);
			List<Empleado> empleados=dao.getAll();
			if (empleados.isEmpty()) {
				System.err.println("No hay empleados registrados");
			}
			else {
				for (Empleado empleado:empleados) {
					System.out.println(empleado);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void testPool() {
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

package openwebinarsjdbc1jpo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 * En esta clase se realizan varias pruebas para estudiar el funcionamiento de
 * JDBC conectándonos a una base de datos MySQL creada de forma local
 * 
 * @author José Palomino Ochoa
 *
 */
public class App {
	/**
	 * Método main en el que se ejecutan los comandos
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Parámetros para establecer la conexión
		String url = "jdbc:mysql://localhost:3306/open_webinars";
		String user = "root";
		String password = "";
		// Creación de objetos Connection, Statement y ResultSet, inicialmente todos a
		// null
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			// Creamos una conexión con la base de datos
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión a la base de datos creada correctamente");
			// Creamos un objeto sentencia SQL
			stm = conn.createStatement();
			// Senetencia de inserción de datos
			String sql = "INSERT INTO ALUMNO(nombre, apellidos, edad, email)"
					+ "VALUES ('Sergio', 'Martínez del Campo', 25, 'serginho@gmail.com');";
			int n = stm.executeUpdate(sql);
			if (n > 0) {
				System.out.println("Se ha insertado un registro en la base de datos");
			}
			// Consulta de registros de la tabla
			String sql2 = "select * from alumno;";
			rs = stm.executeQuery(sql2);
			while (rs.next()) {
				System.out.println(String.format("%d. %s %s %d %s", rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
			System.err.println("SQLState: " + e.getSQLState());
			System.err.println("ErrorCode: " + e.getErrorCode());

		} finally {
			// Cierre del objeto ResultSet
			if (rs != null) {
				try {
					rs.close();
					System.out.println("Objeto ResultSet cerrado correctamente");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// Cierre del objeto Statement
			if (stm != null) {
				try {
					stm.close();
					System.out.println("Objeto Statement cerrado correctamente");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// Cierre del objeto Connection
			if (conn != null) {
				try {
					conn.close();
					System.out.println("Conexión con la base de datos cerrada correctamente");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

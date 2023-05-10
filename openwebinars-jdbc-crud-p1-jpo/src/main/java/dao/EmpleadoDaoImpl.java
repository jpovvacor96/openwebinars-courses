package dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Empleado;
import pool.MyDataSource;

public class EmpleadoDaoImpl implements EmpleadoDAO{
	
	//##################
	//LISTA DE ATRIBUTOS
	//##################
	
	private static EmpleadoDaoImpl instance;
	
	//#########################
	//MÉTODOS GETTERS Y SETTERS
	//#########################
	
	public static EmpleadoDaoImpl getInstance() {
		return EmpleadoDaoImpl.instance;
	}
	
	//#############
	//CONSTRUCTORES
	//#############
	
	private EmpleadoDaoImpl(){
		
	}
	
	//###################
	//MÉTODOS FUNCIONALES
	//###################
	
	static {
		instance=new EmpleadoDaoImpl();
	}
	
	@Override
	public int add(Empleado emp) throws SQLException {
		String sql="INSERT INTO empleado (nombre, apellidos, fecha_nacimiento, puesto, email)"
				+ "VALUES (?, ?, ?, ?, ?)";
		int result;
		try (Connection conn=MyDataSource.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql)){
			pstm.setString(1, emp.getNombre());
			pstm.setString(2, emp.getApellidos());
			pstm.setDate(3, Date.valueOf(emp.getFechaNacimiento()));
			pstm.setString(4, emp.getPuesto());
			pstm.setString(5, emp.getEmail());
			result=pstm.executeUpdate();
		}
		return result;
	}

	@Override
	public Empleado getById(int id) throws SQLException {
		
				
		return null;
	}

	@Override
	public List<Empleado> getAll() throws SQLException {
		String sql="SELECT * FROM empleado";
		List<Empleado> result=new ArrayList<>();
		try(Connection conn=MyDataSource.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql);
				ResultSet rs=pstm.executeQuery()) {
			Empleado emp;
			while(rs.next()) {
				emp=new Empleado();
				emp.setId_empleado(rs.getInt("id_empleado"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellidos(rs.getString("apellidos"));
				emp.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
				emp.setPuesto(rs.getString("puesto"));
				emp.setEmail(rs.getString("email"));
				result.add(emp);
			}
		}
		return result;
	}

	@Override
	public int update(Empleado emp) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}

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
	
	public EmpleadoDaoImpl(){
		
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
		
		Empleado result=null;
		
		String sql="SELECT * FROM empleado WHERE id_empleado=?";
		
		try(Connection conn=MyDataSource.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql)){
			pstm.setInt(1, id);
			try(ResultSet rs=pstm.executeQuery()){
				while(rs.next()) {
					result=new Empleado();
					result.setId_empleado(rs.getInt("id_empleado"));
					result.setNombre(rs.getString("nombre"));
					result.setApellidos(rs.getString("apellidos"));
					result.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
					result.setPuesto(rs.getString("puesto"));
					result.setEmail(rs.getString("email"));
				}
			}
		}
		return result;
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
		String sql="UPDATE empleado SET nombre=?, apellidos=?, fecha_nacimiento=?,"
				+ "puesto=?, email=? WHERE id_empleado=?";
		int result=0;
		try(Connection conn=MyDataSource.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql)){
			pstm.setString(1, emp.getNombre());
			pstm.setString(2, emp.getApellidos());
			pstm.setDate(3, Date.valueOf(emp.getFechaNacimiento()));
			pstm.setString(4, emp.getPuesto());
			pstm.setString(5, emp.getEmail());
			pstm.setInt(6, emp.getId_empleado());
			result=pstm.executeUpdate();
		}
		return result;
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql="DELETE FROM empleado WHERE id_empleado=?";
		try(Connection conn=MyDataSource.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql)){
			pstm.setInt(1, id);
			pstm.executeUpdate();
		}
	}

}

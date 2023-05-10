package dao;

import java.sql.SQLException;
import java.util.List;

import model.Empleado;

public interface EmpleadoDAO {
	
	int add(Empleado emp) throws SQLException;
	
	Empleado getById(int id) throws SQLException;
	
	List<Empleado> getAll() throws SQLException;
	
	int update(Empleado emp) throws SQLException;
	
	void delete(int id) throws SQLException;

}

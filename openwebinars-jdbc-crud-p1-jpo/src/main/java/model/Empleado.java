package model;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado {
	
	//##################
	//LISTA DE ATRIBUTOS
	//##################
	
	private int id_empleado;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String puesto;
	private String email;
	
	//#########################
	//MÉTODOS GETTERS Y SETTERS
	//#########################
	
	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//#############
	//CONSTRUCTORES
	//#############
	
	public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento, String puesto, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.puesto = puesto;
		this.email = email;
	}

	public Empleado(int id_empleado, String nombre, String apellidos, LocalDate fechaNacimiento, String puesto,
			String email) {
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.puesto = puesto;
		this.email = email;
	}
	
	public Empleado() {
			
		}
	
	//###################
	//MÉTODOS FUNCIONALES
	//###################
	
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, email, fechaNacimiento, id_empleado, nombre, puesto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(email, other.email)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && id_empleado == other.id_empleado
				&& Objects.equals(nombre, other.nombre) && Objects.equals(puesto, other.puesto);
	}

	@Override
	public String toString() {
		return "Empleado [getId_empleado()=" + getId_empleado() + ", getNombre()=" + getNombre() + ", getApellidos()="
				+ getApellidos() + ", getFechaNacimiento()=" + getFechaNacimiento() + ", getPuesto()=" + getPuesto()
				+ ", getEmail()=" + getEmail() + "]";
	}
	
	
	
	


}

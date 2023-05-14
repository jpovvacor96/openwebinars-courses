package com.openwebinars.jdbc.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.StringTokenizer;

import dao.EmpleadoDaoImpl;
import model.Empleado;

public class Menu {
	
	//##################
	//LISTA DE ATRIBUTOS
	//##################
	
	private KeyboardReader reader;
	
	private EmpleadoDaoImpl dao;
	
	//#############
	//CONSTRUCTORES
	//#############
	
	public Menu() {
		reader=new KeyboardReader();
		dao=new EmpleadoDaoImpl();
	}
	
	//###################
	//MÉTODOS FUNCIONALES
	//###################
	
	public void init() {
		int opcion;
		do {
			menu();
			opcion=reader.nextInt();
			switch(opcion) {
			case 1:
				this.listAll();
				break;
			case 2:
				this.listById();
				break;
			case 3:
				this.insert();
				break;
			case 4: 
				this.update();
				break;
			case 5: 
				this.delete();
				break;
			case 0:
				System.out.println("Saliendo del programa");
				break;
			default:
				System.err.println("No existe esa opción");
			}
		}while(opcion!=0);
		
	}
	
	public void menu() {
		System.out.println("###############################");
		System.out.println("SISTEMA DE GESTIÓN DE EMPLEADOS");
		System.out.println("###############################");
		System.out.println("0. Salir");
		System.out.println("1. Listar todos los empleados");
		System.out.println("2. Listar un empleado por su ID"); 
		System.out.println("3. Insertar nuevo empleado");
		System.out.println("4. Actualizar los datos de un empleado");
		System.out.println("5. Eliminar un empleado");
		System.out.print("\n Opción:");
	}
	
	public void insert() {
		System.out.println("INSERCIÓN DE UN NUEVO EMPLEADO");
		System.out.println("Introduzca el nombre del empleado:");
		String nombre=reader.nextLine();
		System.out.println("Introduzca los apellidos del empleado:");
		String apellidos=reader.nextLine();
		System.out.println("Introduzca la fecha de nacimiento:");
		LocalDate fechaNacimiento=reader.nextLocalDate();
		System.out.println("Introduzca el puesto que ocupa:");
		String puesto=reader.nextLine();
		System.out.println("Introduzca el email del nuevo empleado:");
		String email=reader.nextLine();
		try {
			dao.add(new Empleado(nombre, apellidos, fechaNacimiento, puesto, email));
			System.out.println("Nuevo empleado registrado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listAll() {
		System.out.println("LISTADO DE TODOS LOS ALUMNOS");
		
		try {
			List<Empleado> result=dao.getAll();
			if (result.isEmpty()) {
				System.err.println("No hay empleados registrados");
			}
			else {
				this.printCabeceraTablaEmpleado();
				for (Empleado empleado:result) {
					this.printEmpleado(empleado);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void printCabeceraTablaEmpleado() {
		System.out.printf("%2s %30s %9s %10s %25s \n", "ID", "NOMBRE", "NACIMIENTO", "PUESTO", "EMAIL");
	}
	
	private void printEmpleado(Empleado emp) {
		System.out.printf("%2s %30s %9s %10s %25s \n", emp.getId_empleado(), emp.getNombre(),
				emp.getApellidos(), emp.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				emp.getPuesto(), emp.getEmail());
	}
	
	public void listById() {
		System.out.println("BÚSQUEDA DE EMPLEADOS POR ID");
		try {
			System.out.println("Introduzca el ID del empleado a buscar:");
			int id=reader.nextInt();
			Empleado empleado=dao.getById(id);
			if (empleado==null) {
				System.err.println("No hay empleados registrados con ese ID");
			}
			else {
				this.printCabeceraTablaEmpleado();
				this.printEmpleado(empleado);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		System.out.println("ACTUALIZACIÓN DE DATOS DE UN EMPLEADO");
		try{
			System.out.println("Introduzca el ID del empleado cuyos datos quiere modificar:");
			int id=reader.nextInt();
			Empleado empleado=dao.getById(id);
			if (empleado==null) {
				System.err.println("No hay empleados registrados con ese ID");
			}
			else {
				this.printCabeceraTablaEmpleado();
				this.printEmpleado(empleado);
				System.out.printf("Introduzca el nombre del empleado (%s): ", empleado.getNombre());
				String nombre=reader.nextLine();
				if (nombre.isBlank()) {
					nombre=empleado.getNombre();
				}
				System.out.printf("Introduzca los apellidos del empleado (%s): ", empleado.getApellidos());
				String apellidos=reader.nextLine();
				if (apellidos.isBlank()) {
					apellidos=empleado.getApellidos();
				}
				System.out.printf("Introduzca la fecha de nacimiento (%s): ", 
						empleado.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				String fechaNacimiento=reader.nextLine();
				LocalDate nacimiento;
				if (fechaNacimiento.isBlank()) {
					nacimiento=empleado.getFechaNacimiento();
				}
				else {
					nacimiento=LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				}
				System.out.printf("Introduzca el puesto del empleado (%s): ", empleado.getPuesto());
				String puesto=reader.nextLine();
				if (puesto.isBlank()) {
					puesto=empleado.getPuesto();
				}
				System.out.printf("Introduzca el email del empleado (%s): ", empleado.getEmail());
				String email=reader.nextLine();
				if (email.isBlank()) {
					email=empleado.getEmail();
				}
				empleado.setNombre(nombre);
				empleado.setApellidos(apellidos);
				empleado.setFechaNacimiento(nacimiento);
				empleado.setPuesto(puesto);
				empleado.setEmail(email);
				
				dao.update(empleado);
				System.out.printf("Empleado con ID %s actualizado correctamente", empleado.getId_empleado());
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		System.out.println("ELIMINACIÓN DE EMPLEADOS");
		try{
			System.out.println("Introduzca el ID del empleado que desea eliminar:");
			int id=reader.nextInt();
			System.out.println("¿Está usted seguro?");
			String borrar=reader.nextLine();
			if (borrar.equalsIgnoreCase("s")) {
				dao.delete(id);
				System.out.println("Usuario eliminado");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	static class KeyboardReader{
		BufferedReader br;
		StringTokenizer st;
		
		public KeyboardReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st==null || !st.hasMoreElements()) {
				try {
					st=new StringTokenizer(br.readLine());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		LocalDate nextLocalDate() {
			return LocalDate.parse(next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		
		String nextLine() {
			String str="";
			try {
				if(st.hasMoreElements()) {
					str=st.nextToken("\n");
				}
				else {
					str=br.readLine();
				}
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}

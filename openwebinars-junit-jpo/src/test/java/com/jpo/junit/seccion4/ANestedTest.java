package com.jpo.junit.seccion4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para servicio SmartPhone")
public class ANestedTest {

	@Test
	@DisplayName("Test número 1")
	void test1() {
		System.out.println("Activado el test número 1");
		assertTrue(true);
	}
	
	@Nested
	@DisplayName("Tests de operaciones para recuperar datos")
	class Grupo1{
		@Test
		@DisplayName("Test findAll()")
		void test1() {
			System.out.println("Activado el test número 1");
			assertTrue(true);
		}
		
		@Test
		@DisplayName("Test findOne()")
		void test2() {
			System.out.println("Activado el test número 1");
			assertTrue(true);
		}
		
		@Test
		@DisplayName("Test findByCPU()")
		void test3() {
			System.out.println("Activado el test número 1");
			assertTrue(true);
		}
	}
	
	@Nested
	@DisplayName("Tests de operaciones para insertar datos")
	class Grupo2{
		
		@Test
		@DisplayName("insertOne()")
		void test1() {
			System.out.println("Activado el test número 1");
			assertTrue(true);
		}
		
		@Test
		@DisplayName("Insert in batch")
		void test2() {
			System.out.println("Activado el test número 1");
			assertTrue(true);
		}
	}

}

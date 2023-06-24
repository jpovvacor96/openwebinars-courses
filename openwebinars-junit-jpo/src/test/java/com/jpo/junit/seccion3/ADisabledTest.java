package com.jpo.junit.seccion3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas con la deshabilitación de los diferentes tests")
public class ADisabledTest {

	/**
	 * Test 1 de prueba
	 */
	@Test
	@Disabled("Deshabilitación controlada del test 1")
	@DisplayName("Test de prueba número 1")
	void test1() {
		System.out.println("Realizado el test 1");
		assertTrue(true);
	}
	
	/**
	 * Test 2 de prueba
	 */
	@Test
	@DisplayName("Test de prueba número 2")
	void test2() {
		System.out.println("Realizado el test 2");
		assertTrue(true);
	}

}

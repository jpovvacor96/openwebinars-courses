package com.jpo.junit.seccion2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Manipular el orden de los tests
public class CClassTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}
	
	/**
	 * Test 1 de prueba
	 */
	@Order(2)
	@Test
	void test1() {
		System.out.println("Realizado el test 1");
		assertTrue(true);
	}
	
	/**
	 * Test 2 de prueba
	 */
	@Order(1)
	@Test
	void test2() {
		System.out.println("Realizado el test 2");
		assertTrue(true);
	}

}

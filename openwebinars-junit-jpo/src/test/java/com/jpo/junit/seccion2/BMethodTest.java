package com.jpo.junit.seccion2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jpo.junit.service.SmartPhoneServiceImpl;

public class BMethodTest {
	
	SmartPhoneServiceImpl service;

	/**
	 * Prepara los datos antes de la realización de cada test
	 */
	@BeforeEach
	void setUp() {
		service=new SmartPhoneServiceImpl();
		System.out.println("setUp se está ejecutando");
	}
	
	/**
	 * Limpia datos temporales o libera la memoria después de cada test
	 */
	@AfterEach
	void tearDown(){
		System.out.println("tearDown se está ejecutando");
	}
	
	/**
	 * Test 1 de prueba
	 */
	@Test
	void test1() {
		System.out.println("Realizado el test 1");
		assertTrue(true);
	}
	
	/**
	 * Test 2 de prueba
	 */
	@Test
	void test2() {
		System.out.println("Realizado el test 2");
		assertTrue(true);
	}

}

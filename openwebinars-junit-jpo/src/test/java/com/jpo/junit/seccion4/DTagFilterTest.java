package com.jpo.junit.seccion4;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("persistence")
public class DTagFilterTest {

	@Test
	void test1() {
		System.out.println("Iniciado el test 1");
	}
	
	@Test
	void test2() {
		System.out.println("Iniciado el test 2");
	}
	
	@Test
	void test3() {
		System.out.println("Iniciado el test 3");
	}

}

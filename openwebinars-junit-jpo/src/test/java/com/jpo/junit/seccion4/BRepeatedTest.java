package com.jpo.junit.seccion4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class BRepeatedTest {

	@Test
	void test1() {
		System.out.println("Prueba concepto test1");
	}
	
	@RepeatedTest(value=3, name=RepeatedTest.SHORT_DISPLAY_NAME)
	@DisplayName("Prueba del test repetido 2")
	void test2() {
		System.out.println("Prueba concepto test repetido 2");
	}
	
	@RepeatedTest(value=3, name=RepeatedTest.LONG_DISPLAY_NAME)
	@DisplayName("Prueba del test repetido 3")
	void test3() {
		System.out.println("Prueba concepto test repetido 3");
	}
	
	@RepeatedTest(value=3, name="{displayName} - {currentRepetition}")
	@DisplayName("Prueba del test repetido 4")
	void test4() {
		System.out.println("Prueba concepto test repetido 4");
	}

}

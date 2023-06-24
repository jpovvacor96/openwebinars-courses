package com.jpo.junit.seccion3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class BConditionalTest {

	@EnabledOnJre(JRE.JAVA_17)
	@Test
	void test1() {
		System.out.println("Ejecutando desde Java 17");
	}
	
	@EnabledOnJre(JRE.JAVA_19)
	@Test
	void test2() {
		System.out.println("Ejecutando desde Java 19");
	}
	
	@EnabledForJreRange(min=JRE.JAVA_10, max=JRE.JAVA_20)
	@Test
	void test3() {
		System.out.println("Ejecutando desde Java 10 hasta Java 20");
	}
	
	@EnabledOnOs(OS.LINUX)
	@Test
	void test4() {
		System.out.println("Ejecutando desde Linux");
	}
	
	@Test
	void printEnvironment() {
		System.getenv().forEach((key, value)->System.out.println(key+" - "+value));
		System.out.println("-----------------------------------------------");
		System.getProperties().forEach((key, value)->System.out.println(key+" - "+value));
	}

}

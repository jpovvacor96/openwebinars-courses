package com.jpo.junit.seccion3;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CAssumptionsTest {

	@BeforeAll
	static void printEnvironment() {
		System.getenv().forEach((key, value)->System.out.println(key+" - "+value));
		System.out.println("-----------------------------------------------");
		System.getProperties().forEach((key, value)->System.out.println(key+" - "+value));
		System.out.println("-----------------------------------------------");
		System.out.println(System.getenv("JAVA_HOME"));
	}
	
	@Test
	void test1() {
		System.out.println("Iniciando el test de versión de Java");
		String jdk=System.getenv("JAVA_HOME");
		assumeTrue(jdk.contains("jdk-17"));
		System.out.println("Continúa el test");
	}
	
	@Test
	void test2() {
		String jdk=System.getenv("JAVA_HOME");
		assumingThat(jdk.contains("jdk-17"), 
				()->{
					
				});
	}

}

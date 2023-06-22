package com.jpo.junit.seccion1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jpo.junit.service.SmartPhoneServiceImpl;

public class AAssertionsTest {
	
	@Test
	void count() {
		SmartPhoneServiceImpl service=new SmartPhoneServiceImpl();
		Integer count=service.count();
		//Aquí hacemos las comprobaciones o aserciones
		
		//Comprobamos que un dato no sea nulo 
		assertNotNull(count);
		
		//Comprobamos que la cuenta sea mayor que cero
		assertTrue(count>0);
		
		//Comprobamos que la cuenta tenga un valor determinado
		assertEquals(3, count);
		
		assertEquals(3, count+1, "El número de elementos esperado es 3");
		
	}
	
}

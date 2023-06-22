package com.jpo.junit.seccion1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jpo.junit.domain.SmartPhone;
import com.jpo.junit.service.SmartPhoneServiceImpl;

@DisplayName("SmartPhoneService: CRUD tests")
public class DDisplayNameTest {

	@Test
	@DisplayName("findOne: Lanzamiento de la excepción IllegalArgumentException")
	void test1() {
		//Controlamos que se lanzan excepciones
		SmartPhoneServiceImpl service=new SmartPhoneServiceImpl();
		assertThrows(IllegalArgumentException.class, ()-> service.findOne(null));
		//assertThrows(NullPointerException.class, ()-> service.findOne(null));
	}
	
	@Test
	@DisplayName("findOne: Comprobación de resultados no nulos")
	void test2() {
		//Controlamos que se lanzan excepciones
		SmartPhoneServiceImpl service=new SmartPhoneServiceImpl();
		SmartPhone result=service.findOne(1L);
		assertNotNull(result);
		assertEquals(1L, result.getId());
	}

}

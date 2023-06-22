package com.jpo.junit.seccion1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.jpo.junit.service.SmartPhoneServiceImpl;

public class CAssertAllTest {

	@Test
	void assertAllTest() {
		
		//Class Under Test
		//System Under Test (SUT)
		SmartPhoneServiceImpl service=new SmartPhoneServiceImpl();
		Integer count=service.count();
		//Aserciones
		assertAll("Comprobaciones",
				()->assertNotNull(count),
				()->assertTrue(count>0),
				()->assertEquals(3, count));
	}

}

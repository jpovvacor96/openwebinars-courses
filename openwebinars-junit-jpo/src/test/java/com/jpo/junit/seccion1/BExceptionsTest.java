package com.jpo.junit.seccion1;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.jpo.junit.service.SmartPhoneServiceImpl;

public class BExceptionsTest {

	@Test
	void findOneIllegalArgumentExceptionText() {
		//Controlamos que se lanzan excepciones
		SmartPhoneServiceImpl service=new SmartPhoneServiceImpl();
		assertThrows(IllegalArgumentException.class, ()-> service.findOne(null));
		assertThrows(NullPointerException.class, ()-> service.findOne(null));
	}

}

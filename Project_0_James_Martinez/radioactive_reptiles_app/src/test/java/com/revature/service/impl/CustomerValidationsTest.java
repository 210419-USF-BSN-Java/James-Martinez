package com.revature.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerValidationsTest {

	@Test
	void testIsValidEmail() {
		assertEquals(true, CustomerValidations.isValidEmail("james@gmail.com"));
	}
	
	@Test
	void testIsNotValidEmail() {
		assertEquals(false, CustomerValidations.isValidEmail("jamesgmailcom"));
	}
	
	@Test
	void testIsValidPassword() {
		assertEquals(true, CustomerValidations.isValidCustPassword("Password1"));
	}
	
	@Test
	void testIsNotValidPasswordNoNumber() {
		assertEquals(false, CustomerValidations.isValidCustPassword("Password"));
	}
	
	@Test
	void testIsNotValidPasswordNoUpper() {
		assertEquals(false, CustomerValidations.isValidCustPassword("password1"));
	}
	
	@Test
	void testIsNotValidPasswordAllLower() {
		assertEquals(false, CustomerValidations.isValidCustPassword("password"));
	}
	
	@Test
	void testIsValidCustId() {
		assertEquals(true, CustomerValidations.isValidCustId(1010));
	}
	
	@Test
	void testIsNotValidCustId() {
		assertEquals(false, CustomerValidations.isValidCustId(900));
	}
	
	@Test
	void testIsNotValidCustIdModulus() {
		assertEquals(false, CustomerValidations.isValidCustId(1009));
	}
	
	


}

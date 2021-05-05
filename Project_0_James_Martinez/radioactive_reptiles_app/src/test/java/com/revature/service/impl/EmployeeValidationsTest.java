package com.revature.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeValidationsTest {
	
	@Test
	void testIsValidEmail() {
		assertEquals(true, EmployeeValidations.isValidEmail("manager@gmail.com"));
	}
	
	@Test
	void testIsNotValidEmail() {
		assertEquals(false, EmployeeValidations.isValidEmail("managergmailcom"));
	}
	
	@Test
	void testIsValidPassword() {
		assertEquals(true, EmployeeValidations.isValidPassword("Employee1"));
	}
	
	@Test
	void testIsNotValidPasswordNoNumber() {
		assertEquals(false, EmployeeValidations.isValidPassword("Employee"));
	}
	
	@Test
	void testIsNotValidPasswordNoUpper() {
		assertEquals(false, EmployeeValidations.isValidPassword("employee1"));
	}
	
	@Test
	void testIsNotValidPasswordAllLower() {
		assertEquals(false, EmployeeValidations.isValidPassword("employee"));
	}
	
	@Test
	void testIsValidCustId() {
		assertEquals(true, EmployeeValidations.isValidEmpId(105));
	}
	
	@Test
	void testIsNotValidCustId() {
		assertEquals(false, EmployeeValidations.isValidEmpId(70));
	}
	
	@Test
	void testIsNotValidCustIdModulus() {
		assertEquals(false, EmployeeValidations.isValidEmpId(102));
	}

}

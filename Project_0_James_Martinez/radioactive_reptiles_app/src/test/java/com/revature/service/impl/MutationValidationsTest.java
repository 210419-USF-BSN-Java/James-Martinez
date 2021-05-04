package com.revature.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutationValidationsTest {

	@Test
	void testIsNotValidMutationId() {
		assertEquals(false, MutationValidations.isValidMutationId("ZOO14"));;
	}
	
	@Test
	void testIsValidReptileMutationId() {
		assertEquals(true, MutationValidations.isValidMutationId("MR01"));;
	}
	
	@Test
	void testIsValidAquaticMutationId() {
		assertEquals(true, MutationValidations.isValidMutationId("MA09"));;
	}
	
	@Test
	void testIsValidAmphibianMutationId() {
		assertEquals(true, MutationValidations.isValidMutationId("MB05"));;
	}
	
	@Test
	void testIsValidPlantMutationId() {
		assertEquals(true, MutationValidations.isValidMutationId("MP03"));;
	}
	

}

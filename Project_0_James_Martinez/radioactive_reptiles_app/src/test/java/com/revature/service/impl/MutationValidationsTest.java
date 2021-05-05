package com.revature.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutationValidationsTest {

	@Test
	void testIsNotValidMutationId() {
		assertEquals(false, MutationValidations.isValidMutationId("ZOO14"));
	}
	
	@Test
	void testIsValidReptileMutationId() {
		assertEquals(true, MutationValidations.isValidMutationId("MR01"));
	}
	
	@Test
	void testIsValidAquaticMutationId() {
		assertEquals(true, MutationValidations.isValidMutationId("MA09"));
	}
	
	@Test
	void testIsValidAmphibianMutationId() {
		assertEquals(true, MutationValidations.isValidMutationId("MB05"));
	}
	
	@Test
	void testIsValidPlantMutationId() {
		assertEquals(true, MutationValidations.isValidMutationId("MP03"));
	}
	
	@Test
	void testIsValidPrice() {
		assertEquals(true, MutationValidations.isValidMutationPrice(5000));
	}
	
	@Test
	void testIsNotValidPriceZero() {
		assertEquals(false, MutationValidations.isValidMutationPrice(0));
	}
	
	@Test
	void testIsNotValidPriceNegative() {
		assertEquals(false, MutationValidations.isValidMutationPrice(-5000));
	}

}

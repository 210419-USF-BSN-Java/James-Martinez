package com.revature.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseAndBidValidationsTest {

	@Test
	void testIsValidAmount() {
		assertEquals(true, PurchaseAndBidValidations.isValidAmount(5000));
	}
	
	@Test
	void testIsNotValidAmountZero() {
		assertEquals(false, PurchaseAndBidValidations.isValidAmount(0));
	}
	
	@Test
	void testIsNotValidAmountNeg() {
		assertEquals(false, PurchaseAndBidValidations.isValidAmount(-500));
	}
	
	@Test
	void testIsValidCustId() {
		assertEquals(true, PurchaseAndBidValidations.isValidCustomerId(1010));
	}
	
	@Test
	void testIsNotValidCustId() {
		assertEquals(false, PurchaseAndBidValidations.isValidCustomerId(900));
	}
	
	@Test
	void testIsNotValidCustIdModulus() {
		assertEquals(false, PurchaseAndBidValidations.isValidCustomerId(1009));
	}
	
	@Test
	void testIsValidOfferId() {
		assertEquals(true, PurchaseAndBidValidations.isValidOfferId(5));
	}
	
	@Test
	void testIsNotValidOfferId() {
		assertEquals(false, PurchaseAndBidValidations.isValidOfferId(0));
	}
	
	@Test
	void testIsValidPurchaseId() {
		assertEquals(true, PurchaseAndBidValidations.isValidPurchaseId(10000));
	}
	
	@Test
	void testIsNotValidPurchaseId() {
		assertEquals(false, PurchaseAndBidValidations.isValidPurchaseId(5000));
	}
	
	


}

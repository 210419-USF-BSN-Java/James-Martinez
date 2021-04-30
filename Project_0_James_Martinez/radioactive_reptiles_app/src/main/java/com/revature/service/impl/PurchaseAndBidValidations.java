package com.revature.service.impl;

public class PurchaseAndBidValidations {
	
	public static boolean isValidAmount(float amount) {
		if (amount > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isValidCustomerId(int customerId) {
		if (customerId >= 1000 && customerId % 10 == 0) {
			return true;
		} else {
			return false;
		}

	}
	

}

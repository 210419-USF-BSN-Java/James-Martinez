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
	
	public static boolean isValidOfferId(int offerId) {
		if (offerId >= 1) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isValidPurchaseId(int purchaseId) {
		if (purchaseId >= 10000) {
			return true;
		} else {
			return false;
		}

	}
	

}

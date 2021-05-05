package com.revature.service.impl;

public class MutationValidations {
	
	public static boolean isValidMutationName(String name) {
		if (name != null && name.matches("[A-Za-z ]{3,30}")) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public static boolean isValidMutationPrice(float askPrice) {
		if (askPrice > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isValidMutationHeight(String height) {
		if (height != null && height.matches("[A-Za-z0-9: ]{5,15}")) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isValidMutationWeight(String weight) {
		if (weight != null && weight.matches("[A-Za-z0-9: ]{5,15}")) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public static boolean isValidMutationId(String mutationId) {
		if (mutationId != null && mutationId.matches("[M]{1}[RBAP]{1}[0-9]{2}")) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isValidMutationDescription(String description) {
		if (description != null && description.matches("[A-Za-z0-9, ]{10,200}")) {
			return true;
		} else {
			return false;
		}

	}

}

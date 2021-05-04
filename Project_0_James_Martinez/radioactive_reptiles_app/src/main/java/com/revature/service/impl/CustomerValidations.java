package com.revature.service.impl;

public class CustomerValidations {
	
	public static boolean isValidEmail(String email) {
		if (email != null && email.contains("@")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isValidCustPassword(String password) {
		if (password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")){ //  && password.length() >= 8) { 
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isValidCustName(String name) {
		if (name != null && name.matches("[A-Za-z ]{3,25}")) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isValidCustId(int custId) {
		if (custId >= 1000 && custId % 10 == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	public static boolean isValidCustLocation(String location) {
		if (location != null && location.matches("[A-Za-z0-9 ]{3,25}")) {
			return true;
		} else {
			return false;
		}
		
	}
}
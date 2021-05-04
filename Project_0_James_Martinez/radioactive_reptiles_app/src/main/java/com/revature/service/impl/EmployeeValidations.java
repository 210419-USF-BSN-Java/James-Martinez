package com.revature.service.impl;

public class EmployeeValidations {
	
	public static boolean isValidEmail(String email) {
		if (email != null && email.contains("@")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isValidPassword(String password) {
		if (password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")){ //  && password.length() >= 8) { 
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isValidName(String name) {
		if (name != null && name.matches("[A-Za-z ]{3,25}")) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isValidEmpId(int empId) {
		if (empId >= 100 && empId % 5 == 0) {
			return true;
		} else {
			return false;
		}

	}

}

package com.revature.service.impl;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.impl.EmployeeDAOImpl;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDAO empDAO = new EmployeeDAOImpl();

	@Override
	public int createNewEmployee(Employee employee) throws RegistrationException {
		if(!EmployeeValidations.isValidName(employee.getName())) {
			throw new RegistrationException("Invalid Name format must be between 5-30 characters and spaces only");
		}
		if(!EmployeeValidations.isValidEmail(employee.getEmail())) {
			throw new RegistrationException("The format of the entered Email is invalid");
		}
		if(!EmployeeValidations.isValidPassword(employee.getPassword())) {
			throw new RegistrationException("Invalid Password format must be at least 8 characters containing at least one lowercase, uppercase, and number");
		}
		return empDAO.createNewEmployee(employee);
	}

	@Override
	public int deleteEmployeeById(int empId) throws EntryNotFoundException {
		if(!EmployeeValidations.isValidEmpId(empId)) {
			throw new EntryNotFoundException("Invalid Employee ID format please try again");
		}
		return empDAO.deleteEmployeeById(empId);
	}

	@Override
	public Employee getEmployeeById(int empId) throws EntryNotFoundException {
		if(!EmployeeValidations.isValidEmpId(empId)) {
			throw new EntryNotFoundException("Invalid Employee ID format please try again");
		}
		return empDAO.getEmployeeById(empId);
	}


}

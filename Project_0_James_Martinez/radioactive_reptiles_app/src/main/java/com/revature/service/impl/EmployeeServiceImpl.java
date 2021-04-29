package com.revature.service.impl;

import java.util.List;

import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public int createNewEmployee(Employee employee) throws RegistrationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployeeById(int empId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}

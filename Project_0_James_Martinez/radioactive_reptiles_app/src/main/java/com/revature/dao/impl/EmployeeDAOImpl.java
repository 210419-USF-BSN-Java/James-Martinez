package com.revature.dao.impl;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

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
	public List<Employee> listAllEmployeeAccounts() throws EmptyDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean empLogin(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

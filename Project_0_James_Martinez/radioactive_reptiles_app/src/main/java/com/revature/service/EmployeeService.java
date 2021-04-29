package com.revature.service;

import java.util.List;

import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Employee;

public interface EmployeeService {
	
    public int createNewEmployee(Employee employee) throws RegistrationException;
    public int deleteEmployeeById(int empId) throws EntryNotFoundException;
	
	public Employee getEmployeeById(int empId) throws EntryNotFoundException;
	

}

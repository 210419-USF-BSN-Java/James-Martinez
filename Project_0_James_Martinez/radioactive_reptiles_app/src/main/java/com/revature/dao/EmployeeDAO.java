package com.revature.dao;

import java.util.List;

import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Employee;

public interface EmployeeDAO {
	
	public int createNewEmployee(Employee employee) throws RegistrationException;
    public int deleteEmployeeById(int empId) throws EntryNotFoundException;
	
	public List<Employee> listAllEmployeeAccounts() throws EmptyDatabaseException;
	public Employee getEmployeeById(int empId) throws EntryNotFoundException;
	
	public boolean empLogin(String email, String password);
	
	

}

package com.revature.dao;

import java.util.List;

import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Employee;

public interface EmployeeDAO {
	
	public int createNewEmployee(Employee employee) throws RegistrationException; //COMPLETED
    public int deleteEmployeeById(int empId) throws EntryNotFoundException; //COMPLETED
	
	public List<Employee> listAllEmployeeAccounts() throws EmptyDatabaseException; //COMPLETED
	public Employee getEmployeeById(int empId) throws EntryNotFoundException; //COMPLETED
	
	public boolean empLogin(String email, String password); //COMPLETED
	
	public String getManagerByEmailPassword(String email, String Password); //COMPLETED
	
	

}

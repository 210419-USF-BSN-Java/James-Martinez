package com.revature.dao;

import java.util.List;

import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Customer;

public interface CustomerDAO {
	
public int createNewCustomer(Customer customer) throws RegistrationException; //COMPLETED
	
	public List<Customer> listAllCustomerAccounts() throws EmptyDatabaseException; //COMPLETED
	public Customer getCustomerById(int custId) throws EntryNotFoundException;  //MIGHT NOT NEED
	
	public boolean custLogin(String email, String password); //COMPLETED
	
	public int getIdByEmailPassword(String email, String password); //COMPLETED
	

}

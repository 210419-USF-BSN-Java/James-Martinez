package com.revature.dao;

import java.util.List;

import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Customer;

public interface CustomerDAO {
	
public int createNewCustomer(Customer customer) throws RegistrationException;
	
	public List<Customer> listAllCustomerAccounts() throws EmptyDatabaseException;
	public Customer getCustomerById(int custId) throws EntryNotFoundException;
	
	public boolean custLogin(String email, String password);

}

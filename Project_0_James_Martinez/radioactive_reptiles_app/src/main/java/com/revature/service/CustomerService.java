package com.revature.service;

import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Customer;

public interface CustomerService{
	
	public int createNewCustomer(Customer customer) throws RegistrationException;
	
	public Customer getCustomerById(int custId) throws EntryNotFoundException;
	

}

package com.revature.dao.impl;

import java.util.List;

import com.revature.dao.CustomerDAO;
import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public int createNewCustomer(Customer customer) throws RegistrationException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> listAllCustomerAccounts() throws EmptyDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean custLogin(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

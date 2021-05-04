package com.revature.service.impl;

import com.revature.dao.CustomerDAO;
import com.revature.dao.impl.CustomerDAOImpl;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Customer;
import com.revature.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDAO custDAO = new CustomerDAOImpl();

	@Override
	public int createNewCustomer(Customer customer) throws RegistrationException {
		if(!CustomerValidations.isValidCustName(customer.getName())) {
			throw new RegistrationException("Invalid Name format must be between 5-30 characters and spaces only");
		}
		if(!CustomerValidations.isValidEmail(customer.getEmail())) {
			throw new RegistrationException("The format of the entered Email is invalid");
		}
		if(!CustomerValidations.isValidCustPassword(customer.getPassword())) {
			throw new RegistrationException("Invalid Password format must be at least 8 characters containing at least one lowercase, uppercase, and number");
		}
		if(!CustomerValidations.isValidCustLocation(customer.getLocation())) {
			throw new RegistrationException("Location cannot be blank and must be bewteen 5-25 characters");
		}
		return custDAO.createNewCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int custId) throws EntryNotFoundException {
		if(!CustomerValidations.isValidCustId(custId)) {
			throw new EntryNotFoundException("Invalid Customer ID please try again");
		}
		return null;
	}


}

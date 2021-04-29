package com.revature.dao.impl;

import java.util.List;

import com.revature.dao.PurchaseAndBidDAO;
import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.PaymentException;
import com.revature.models.Payment;
import com.revature.models.Purchase;

public class PurchaseAndBidDAOImpl implements PurchaseAndBidDAO{

	@Override
	public int makePayment(Payment payment) throws PaymentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Payment> viewAllPayments() throws EmptyDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> viewPurchaseHistory() throws EmptyDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int approveBid() {
		// TODO Auto-generated method stub
		return 0;
	}

}

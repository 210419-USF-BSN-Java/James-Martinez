package com.revature.dao;

import java.util.List;

import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.PaymentException;
import com.revature.models.Payment;
import com.revature.models.Purchase;

public interface PurchaseAndBidDAO {
	
public int makePayment(Payment payment) throws PaymentException;
	
	public List<Payment> viewAllPayments() throws EmptyDatabaseException;
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException;
	
	public List<Purchase> viewPurchaseHistory() throws EmptyDatabaseException;
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException;
	
	public int approveBid();

}

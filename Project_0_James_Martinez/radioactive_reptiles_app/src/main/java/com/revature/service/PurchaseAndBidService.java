package com.revature.service;

import java.util.List;

import com.revature.exception.EntryNotFoundException;
import com.revature.exception.OfferException;
import com.revature.exception.PaymentException;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Purchase;

public interface PurchaseAndBidService {
	
	public int makePayment(Payment payment) throws PaymentException; ///// figure this out not in doa layer, use regex
	public int makeOffer(Offer offer) throws OfferException;
	public int makePurchase(Purchase purchase) throws PaymentException;
	
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException;
	
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException;
	
	
}

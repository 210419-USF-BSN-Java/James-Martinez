package com.revature.service.impl;

import java.util.List;

import com.revature.exception.EntryNotFoundException;
import com.revature.exception.OfferException;
import com.revature.exception.PaymentException;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Purchase;
import com.revature.service.PurchaseAndBidService;

public class PurchaseAndBidImpl implements PurchaseAndBidService{

	@Override
	public int makePayment(Payment payment) throws PaymentException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int makeOffer(Offer offer) throws OfferException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int makePurchase(Purchase purchase) throws PaymentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}




}

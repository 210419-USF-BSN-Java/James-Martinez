package com.revature.dao.impl;

import java.util.List;

import com.revature.dao.PurchaseAndBidDAO;
import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.OfferException;
import com.revature.exception.PaymentException;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Purchase;

public class PurchaseAndBidDAOImpl implements PurchaseAndBidDAO{

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
	public List<Offer> viewAllOffers() throws EmptyDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> viewAllPurchases() throws EmptyDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int approveOffer() {
		// TODO Auto-generated method stub
		return 0;
	}




}

package com.revature.service.impl;

import java.util.List;

import com.revature.dao.PurchaseAndBidDAO;
import com.revature.dao.impl.PurchaseAndBidDAOImpl;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.OfferException;
import com.revature.exception.PaymentException;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Purchase;
import com.revature.service.PurchaseAndBidService;

public class PurchaseAndBidImpl implements PurchaseAndBidService{
	
	private PurchaseAndBidDAO purDAO = new PurchaseAndBidDAOImpl();

	@Override
	public int makePayment(Payment payment) throws PaymentException {
		if(!PurchaseAndBidValidations.isValidAmount(payment.getAmount())) {
			throw new PaymentException("Payment amount cannot be 0 or negative");
		}
		return 0;
	}
	
	@Override
	public int makeOffer(Offer offer) throws OfferException {
		if(!PurchaseAndBidValidations.isValidAmount(offer.getAmount())) {
			throw new OfferException("Offer amount cannot be 0 or negative");
		}
		return 0;
	}

	@Override
	public int makePurchase(Purchase purchase) throws PaymentException {
		return 0;
	}

	@Override
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException {
		if(!PurchaseAndBidValidations.isValidCustomerId(custId)) {
			throw new EntryNotFoundException("Invalid Customer ID please try again");
		}
		return null;
	}

	@Override
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException {
		if(!PurchaseAndBidValidations.isValidCustomerId(custId)) {
			throw new EntryNotFoundException("Invalid Customer ID please try again");
		}
		return null;
	}




}

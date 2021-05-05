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
	public int makePayment(Payment payment, int purchaseId) throws PaymentException {
		if(!PurchaseAndBidValidations.isValidAmount(payment.getAmount())) {
			throw new PaymentException("Payment amount cannot be 0 or negative");
		}
		if(!PurchaseAndBidValidations.isValidPurchaseId(purchaseId)) {
			throw new PaymentException("Invalid purchase ID");
		}
		return purDAO.makePayment(payment, purchaseId);
	}
	
	@Override
	public int makeOffer(Offer offer) throws OfferException {
		if(!PurchaseAndBidValidations.isValidAmount(offer.getAmount())) {
			throw new OfferException("Offer amount cannot be 0 or negative");
		}
		return purDAO.makeOffer(offer);
	}

	@Override
	public int makePurchase(Purchase purchase, String availability) throws PaymentException {
		
		return purDAO.makePurchase(purchase, availability);
	}
	
	@Override
	public List<Offer> viewOfferByCustomer(int custId) throws EntryNotFoundException {
		if(!PurchaseAndBidValidations.isValidCustomerId(custId)) {
			throw new EntryNotFoundException("Invalid Customer ID");
		}
		return purDAO.viewOfferByCustomer(custId);
	}

	@Override
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException {
		if(!PurchaseAndBidValidations.isValidCustomerId(custId)) {
			throw new EntryNotFoundException("Invalid Customer ID");
		}
		return purDAO.viewPaymentByCustomer(custId);
	}

	@Override
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException {
		if(!PurchaseAndBidValidations.isValidCustomerId(custId)) {
			throw new EntryNotFoundException("Invalid Customer ID");
		}
		return purDAO.viewPurchaseByCustomer(custId);
	}

	@Override
	public Offer getOfferById(int offerId) throws EntryNotFoundException {
		if(!PurchaseAndBidValidations.isValidOfferId(offerId)) {
			throw new EntryNotFoundException("Invalid Offer ID");
		}
		return purDAO.getOfferById(offerId);
	}

	@Override
	public Purchase getPurchaseById(int purchaseId) throws EntryNotFoundException {
		if(!PurchaseAndBidValidations.isValidPurchaseId(purchaseId)) {
			throw new EntryNotFoundException("Invalid purchase ID");
		}
		return purDAO.getPurchaseById(purchaseId);
	}

	




}

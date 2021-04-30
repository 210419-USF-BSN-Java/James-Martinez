package com.revature.dao;

import java.util.List;

import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.OfferException;
import com.revature.exception.PaymentException;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Purchase;

public interface PurchaseAndBidDAO {
	
    public int makePayment(Payment payment) throws PaymentException;
    public int makeOffer(Offer offer) throws OfferException;
    public int makePurchase(Purchase purchase) throws PaymentException;
    
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException;
	
	public List<Offer> viewAllOffers() throws EmptyDatabaseException;
	public List<Purchase> viewAllPurchases() throws EmptyDatabaseException;
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException;
	
	public int approveOffer();

}

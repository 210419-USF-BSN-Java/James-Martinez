package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.PurchaseAndBidDAO;
import com.revature.dbutil.PostgresConnection;
import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.InventoryException;
import com.revature.exception.OfferException;
import com.revature.exception.PaymentException;
import com.revature.models.Customer;
import com.revature.models.Mutation;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Purchase;

public class PurchaseAndBidDAOImpl implements PurchaseAndBidDAO{
	
	Logger log=Logger.getLogger(PurchaseAndBidDAOImpl.class);

	@Override
	public int makePayment(Payment payment, int purchaseId) throws PaymentException {
		int c = 0;
		Connection connection = null;
		try {
			connection = PostgresConnection.getConnection();
			String sql = "insert into radioactive_reptiles.payments(customerid,mutationname,amount) values(?,?,?)";
			String sql2 = "update radioactive_reptiles.purchases set balance=balance - ? where purchaseid = ?";
			connection.setAutoCommit(false);
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, payment.getCustomerId());
			preparedStatement.setString(2, payment.getName());
			preparedStatement.setFloat(3, payment.getAmount());
			preparedStatement.addBatch();
			c = preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setFloat(1, payment.getAmount());
			preparedStatement.setInt(2, purchaseId);
			preparedStatement.addBatch();
			c = preparedStatement.executeUpdate();
			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				log.debug(e);
				connection.rollback();
				log.debug("rollback success");
			}catch (SQLException e1) {
				log.debug("Unable to rollback");
			}
			throw new PaymentException("Internal error, Payment could not be made");
		}
		return c;
	}

	@Override
	public int makeOffer(Offer offer) throws OfferException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into radioactive_reptiles.offers(customerid,mutationname,amount) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offer.getCustomerId());
			preparedStatement.setString(2, offer.getName());
			preparedStatement.setFloat(3, offer.getAmount());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new OfferException("Internal error, Offer could not be made");
		}
		return c;
	}
	
	@Override
	public int makePurchase(Purchase purchase, String availability) throws PaymentException {
		int c = 0;
		Connection connection = null;
		try {
			connection = PostgresConnection.getConnection();
			String sql = "insert into radioactive_reptiles.purchases(customerid,mutationname,buyprice,balance) values(?,?,?,?)";
			String sql2 = "update radioactive_reptiles.mutation set availability = ? where name = ?";
			connection.setAutoCommit(false);
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, purchase.getCustomerId());
			preparedStatement.setString(2, purchase.getName());
			preparedStatement.setFloat(3, purchase.getAmount());
			preparedStatement.setFloat(4, purchase.getBalance());
			preparedStatement.addBatch();
			c = preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, availability);
			preparedStatement.setString(2, purchase.getName());
			preparedStatement.addBatch();
			c = preparedStatement.executeUpdate();
			
			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				log.debug(e);
				connection.rollback();
				log.debug("rollback success");
			}catch (SQLException e1) {
				log.debug("Unable to rollback");
			}
			throw new PaymentException("Internal error, Purchase could not be made");
		}
		return c;
	}
	
	@Override
	public List<Offer> viewAllOffers() throws EmptyDatabaseException {
		List<Offer> offerList = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from radioactive_reptiles.offers order by offerid";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Offer offer =  new Offer();
				offer.setCustomerId(resultSet.getInt("customerid"));
				offer.setName(resultSet.getString("mutationname"));
				offer.setOfferId(resultSet.getInt("offerid"));
				offer.setAmount(resultSet.getFloat("amount"));
				offer.setDateTime(resultSet.getDate("datetime"));
				offer.setStatus(resultSet.getString("status"));
				offerList.add(offer);
			}
			if(offerList.size()==0) {
				throw new EmptyDatabaseException("No offers found in the database");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return offerList;
	}
	
	@Override
	public List<Offer> viewOfferByCustomer(int custId) throws EntryNotFoundException {
		List<Offer> offList = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from radioactive_reptiles.offers where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, custId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Offer offer = new Offer();
				offer.setOfferId(resultSet.getInt("offerid"));
				offer.setCustomerId(resultSet.getInt("customerid"));
				offer.setName(resultSet.getString("mutationname"));
				offer.setAmount(resultSet.getFloat("amount"));
				offer.setDateTime(resultSet.getDate("datetime"));
				offer.setStatus(resultSet.getString("status"));
				offList.add(offer);
			}
			if(offList.size()==0) {
				throw new EntryNotFoundException("No offers found with the customer ID: "+custId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return offList;
	}

	@Override
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException {
		List<Payment> payList = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from radioactive_reptiles.payments where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, custId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Payment payment =  new Payment();
				payment.setCustomerId(resultSet.getInt("customerid"));
				payment.setName(resultSet.getString("mutationname"));
				payment.setAmount(resultSet.getFloat("amount"));
				payment.setDateTime(resultSet.getDate("datetime"));
				payList.add(payment);
			}
			if(payList.size()==0) {
				throw new EntryNotFoundException("No payments found with the customer ID: "+custId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return payList;
	}

	@Override
	public List<Purchase> viewAllPurchases() throws EmptyDatabaseException {
		List<Purchase> purchaseList = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from radioactive_reptiles.purchases order by purchaseid";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Purchase purchase = new Purchase();
				purchase.setCustomerId(resultSet.getInt("customerid"));
				purchase.setName(resultSet.getString("mutationname"));
				purchase.setPurchaseId(resultSet.getInt("purchaseid"));
				purchase.setAmount(resultSet.getFloat("buyprice"));
				purchase.setDateTime(resultSet.getDate("purchasedate"));
				purchase.setBalance(resultSet.getFloat("balance"));
				purchaseList.add(purchase);
			}
			if(purchaseList.size()==0) {
				throw new EmptyDatabaseException("No purchases found in the database");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return purchaseList;
	}

	@Override
	public List<Purchase> viewPurchaseByCustomer(int custId) throws EntryNotFoundException {
		List<Purchase> purList = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from radioactive_reptiles.purchases where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, custId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Purchase purchase = new Purchase();
				purchase.setCustomerId(resultSet.getInt("customerid"));
				purchase.setName(resultSet.getString("mutationname"));
				purchase.setAmount(resultSet.getFloat("buyprice"));
				purchase.setDateTime(resultSet.getDate("purchasedate"));
				purchase.setPurchaseId(resultSet.getInt("purchaseid"));
				purchase.setBalance(resultSet.getFloat("balance"));
				purList.add(purchase);
			}
			if(purList.size()==0) {
				throw new EntryNotFoundException("No purchases found with the customer ID: "+custId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return purList;
	}


	@Override
	public Offer getOfferById(int offerId) throws EntryNotFoundException {
		Offer offer = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from radioactive_reptiles.offers where offerid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offerId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				offer=new Offer();
				offer.setOfferId(offerId);
				offer.setName(resultSet.getString("mutationname"));
				offer.setAmount(resultSet.getFloat("amount"));
				offer.setStatus(resultSet.getString("status"));
				offer.setCustomerId(resultSet.getInt("customerid"));
				offer.setDateTime(resultSet.getDate("datetime"));
			}
			if(offer==null) {
				throw new EntryNotFoundException("No offer found with ID : "+offerId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return offer;
	}

	@Override
	public Purchase getPurchaseById(int purchaseId) throws EntryNotFoundException {
		Purchase purchase = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from radioactive_reptiles.purchases where purchaseid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, purchaseId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				purchase=new Purchase();
				purchase.setPurchaseId(purchaseId);
				purchase.setName(resultSet.getString("mutationname"));
				purchase.setAmount(resultSet.getFloat("buyprice"));
				purchase.setBalance(resultSet.getFloat("balance"));
				purchase.setCustomerId(resultSet.getInt("customerid"));
				purchase.setDateTime(resultSet.getDate("purchasedate"));
			}
			if(purchase==null) {
				throw new EntryNotFoundException("No purchase found with ID : "+purchaseId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return purchase;
	}
	
	@Override
	public int approveOffer(String status, int offerId) {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "update radioactive_reptiles.offers set status = ? where offerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, offerId);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return c;
	}

	




}

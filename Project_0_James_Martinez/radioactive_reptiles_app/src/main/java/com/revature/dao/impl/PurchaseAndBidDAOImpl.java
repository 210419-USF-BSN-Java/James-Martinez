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
import com.revature.exception.OfferException;
import com.revature.exception.PaymentException;
import com.revature.models.Customer;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Purchase;

public class PurchaseAndBidDAOImpl implements PurchaseAndBidDAO{
	
	Logger log=Logger.getLogger(PurchaseAndBidDAOImpl.class);

	@Override
	public int makePayment(Payment payment) throws PaymentException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into radioactive_reptiles.payments(customerid,name,amount,datetime) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, payment.getCustomerId());
			preparedStatement.setString(2, payment.getName());
			preparedStatement.setFloat(3, payment.getAmount());
			preparedStatement.setDate(4, payment.getDateTime());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new PaymentException("Internal error, Payment could not be made");
		}
		return c;
	}

	@Override
	public int makeOffer(Offer offer) throws OfferException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into radioactive_reptiles.offers(customerid,name,amount,datetime,offerid,status) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offer.getCustomerId());
			preparedStatement.setString(2, offer.getName());
			preparedStatement.setFloat(3, offer.getAmount());
			preparedStatement.setDate(4, offer.getDateTime());
			preparedStatement.setInt(4, offer.getOfferId());
			preparedStatement.setString(4, offer.getStatus());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new OfferException("Internal error, Offer could not be made");
		}
		return c;
	}
	
	@Override
	public int makePurchase(Purchase purchase) throws PaymentException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into radioactive_reptiles.payments(customerid,name,buyprice,purchasedate,purchaseid,balance) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, purchase.getCustomerId());
			preparedStatement.setString(2, purchase.getName());
			preparedStatement.setFloat(3, purchase.getAmount());
			preparedStatement.setDate(4, purchase.getDateTime());
			preparedStatement.setInt(5, purchase.getPurchaseId());
			preparedStatement.setFloat(6, purchase.getBalance());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
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
				offer.setName(resultSet.getString("name"));
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
	public List<Payment> viewPaymentByCustomer(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
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
				purchase.setName(resultSet.getString("name"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int approveOffer() {
		// TODO Auto-generated method stub //AKA CHANGE STATUS
		return 0;
	}




}

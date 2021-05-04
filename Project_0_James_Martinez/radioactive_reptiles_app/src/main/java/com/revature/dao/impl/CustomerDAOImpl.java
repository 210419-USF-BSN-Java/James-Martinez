package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.CustomerDAO;
import com.revature.dbutil.PostgresConnection;
import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.RegistrationException;
import com.revature.models.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	
	Logger log=Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public int createNewCustomer(Customer customer) throws RegistrationException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into radioactive_reptiles.customer(name,email,password,location) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getEmail());
			preparedStatement.setString(3, customer.getPassword());
			preparedStatement.setString(4, customer.getLocation());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new RegistrationException("Internal error, Customer Account could not be created");
		}
		return c;
	}

	@Override
	public List<Customer> listAllCustomerAccounts() throws EmptyDatabaseException {
		List<Customer> customerList = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from radioactive_reptiles.customer order by customerid";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustid(resultSet.getInt("customerid"));
				customer.setName(resultSet.getString("name"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customer.setLocation(resultSet.getString("location"));
				customerList.add(customer);
			}
			if(customerList.size()==0) {
				throw new EmptyDatabaseException("No Customer Accounts found in the database");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return customerList;
	}

	@Override
	public Customer getCustomerById(int custId) throws EntryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean custLogin(String email, String password){
		int check = 0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql ="select email, password from radioactive_reptiles.customer";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next() && check == 0) {
				String realEmail = resultSet.getString("email");
				String realPassword = resultSet.getString("password");
			     if(email.equals(realEmail) && password.equals(realPassword)) {
			    	 check = 1;
					} 
				}
			} catch (ClassNotFoundException | SQLException e) {
				log.debug(e);
			}
			if (check == 1) {
				return true;
			}else {
				return false;
			}
	}

	@Override
	public int getIdByEmailPassword(String email, String password) {
		int accountId = 1;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select customerid from radioactive_reptiles.customer where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			accountId = resultSet.getInt("customerid");
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		
		return accountId;
	}

}

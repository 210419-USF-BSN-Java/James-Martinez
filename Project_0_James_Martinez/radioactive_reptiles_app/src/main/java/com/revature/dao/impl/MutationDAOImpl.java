package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.MutationDAO;
import com.revature.dbutil.PostgresConnection;
import com.revature.exception.InventoryException;
import com.revature.models.Mutation;

public class MutationDAOImpl implements MutationDAO{
	
	Logger log=Logger.getLogger(MutationDAOImpl.class);

	@Override
	public int addMutation(Mutation mutation, String description) throws InventoryException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into radioactive_reptiles.mutation(mutationid,name,height,weight,bid,description) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mutation.getMutationId());
			preparedStatement.setString(2, mutation.getName());
			preparedStatement.setString(3, mutation.getHeight());
			preparedStatement.setString(4, mutation.getWeight());
			preparedStatement.setFloat(5, mutation.getAskPrice());
			preparedStatement.setString(6, description);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new InventoryException("Internal error, Mutation could not be added to inventory");
		}
		return c;
	}

	@Override
	public int deleteMutationById(String mutationId) throws InventoryException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "delete from radioactive_reptiles.mutation where mutationid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mutationId);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new InventoryException("Internal error, could not delete mutation be sure correct ID was entered");
		}
		return c;
	}

	@Override
	public int editMutationById(String mutationId, int choice, String update) throws InventoryException {
		   int c = 0;
           try (Connection connection = PostgresConnection.getConnection()) {
			
			String sqlna = "update radioactive_reptiles.mutation set name = ? where mutationid= ?";
			String sqlh = "update radioactive_reptiles.mutation set height = ? where mutationid= ?";
			String sqlw = "update radioactive_reptiles.mutation set weight = ? where mutationid= ?";
			String sqlbid = "update radioactive_reptiles.mutation set bid = ? where mutationid= ?";
			String sqldes = "update radioactive_reptiles.mutation set description = ? where mutationid= ?";
			String sqlava = "update radioactive_reptiles.mutation set availability = ? where mutationid= ?";
			String sql =null;
			if(choice == 1) {
				sql = sqlna;
			}else if(choice ==2) {
				sql = sqlh;
			}else if(choice ==3) {
				sql = sqlw;
			}else if(choice ==4) {
				sql = sqlbid;
			}else if(choice ==5) {
				sql = sqldes;
			}else if(choice ==6) {
				sql = sqlava;
			}
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(2, mutationId);
			preparedStatement.setString(1, update);
			c = preparedStatement.executeUpdate();
	
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new InventoryException("Internal error, could not update Mutation be sure to select the correct option");
		}
		return c;
	}

	@Override
	public List<Mutation> listMutationByType(String mutationId) throws InventoryException {
		List<Mutation> mutateList = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = null;
			if(mutationId.matches("[M]{1}[R]{1}")) {
				 sql = "select mutationid, name, height, weight,bid, availability from radioactive_reptiles.mutation where mutationid like 'MR%'";
			}else if(mutationId.matches("[M]{1}[A]{1}")) {
				 sql = "select mutationid, name, height, weight,bid, availability from radioactive_reptiles.mutation where mutationid like 'MA%'";
			}else if(mutationId.matches("[M]{1}[B]{1}")) {
				 sql = "select mutationid, name, height, weight,bid, availability from radioactive_reptiles.mutation where mutationid like 'MB%'";
			}else if(mutationId.matches("[M]{1}[P]{1}")) {
				 sql = "select mutationid, name, height, weight,bid, availability from radioactive_reptiles.mutation where mutationid like 'MP%'";
			}else {
				sql = "select mutationid, name, height, weight,bid, availability from radioactive_reptiles.mutation";
			}
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Mutation mutation=new Mutation();
				mutation.setMutationId(resultSet.getString("mutationid"));
				mutation.setName(resultSet.getString("name"));
				mutation.setHeight(resultSet.getString("height"));
				mutation.setWeight(resultSet.getString("weight"));
				mutation.setAskPrice(resultSet.getFloat("bid"));
				mutation.setAvailability(resultSet.getString("availability"));
				mutateList.add(mutation);
			}
			if(mutateList.size()==0) {
				throw new InventoryException("There are currently no mutations of this type in the database");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new InventoryException("Internal error, could not retrieve Mutations");
		}
		return mutateList;
	}

	@Override
	public String getMutationDescription(String mutationid) {
		String description = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select description from radioactive_reptiles.mutation where mutationid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mutationid);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				description = resultSet.getString("description");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return description;
	}


	@Override
	public Mutation getMutationById(String mutationId) throws InventoryException {
		Mutation mutation = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select name, height, weight,bid, availability from radioactive_reptiles.mutation where mutationid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mutationId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				mutation=new Mutation();
				mutation.setMutationId(mutationId);
				mutation.setName(resultSet.getString("name"));
				mutation.setHeight(resultSet.getString("height"));
				mutation.setWeight(resultSet.getString("weight"));
				mutation.setAskPrice(resultSet.getFloat("bid"));
				mutation.setAvailability(resultSet.getString("availability"));
			}
			if(mutation==null) {
				throw new InventoryException("No Mutation found with ID : "+mutationId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new InventoryException("Internal error, could not access Mutation");
		}
		return mutation;
	}

}

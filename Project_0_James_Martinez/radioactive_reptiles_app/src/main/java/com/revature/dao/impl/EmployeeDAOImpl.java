package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDAO;
import com.revature.dbutil.PostgresConnection;
import com.revature.exception.EmptyDatabaseException;
import com.revature.exception.EntryNotFoundException;
import com.revature.exception.InventoryException;
import com.revature.exception.RegistrationException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Mutation;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	Logger log=Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public int createNewEmployee(Employee employee) throws RegistrationException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into radioactive_reptiles.employee(name,email,password) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPassword());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new RegistrationException("Internal error, employee could not be added to database");
		}
		return c;
	}

	@Override
	public int deleteEmployeeById(int empId) throws EntryNotFoundException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "delete from radioactive_reptiles.employee where employeeid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, empId);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new EntryNotFoundException("Internal error, could not delete employee be sure correct ID was entered");
		}
		return c;
	}

	@Override
	public List<Employee> listAllEmployeeAccounts() throws EmptyDatabaseException {
		List<Employee> employeeList = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select employeeid, name, email, password from radioactive_reptiles.employee where manager = 'N' order by employeeid";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpLogin(resultSet.getInt("employeeid"));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPassword(resultSet.getString("password"));
				employeeList.add(employee);
			}
			if(employeeList.size()==0) {
				throw new EmptyDatabaseException("No Employees found in the database");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EntryNotFoundException {
		Employee employee = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select name, email, password from radioactive_reptiles.employee where employeeid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, empId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				employee=new Employee();
				employee.setEmpLogin(empId);
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPassword(resultSet.getString("password"));
			}
			if(employee==null) {
				throw new EntryNotFoundException("No Mutation found with ID : "+empId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return employee;
	}

	@Override
	public boolean empLogin(String email, String password) {
		int check = 0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql ="select email, password from radioactive_reptiles.employee";
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
	public String getManagerByEmailPassword(String email, String password) {
		String manager = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select manager from radioactive_reptiles.employee where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			manager = resultSet.getString("manager");
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
		}
		return manager;
	}

}

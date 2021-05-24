package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.impl.UserServiceImpl;

public class EmployeeUserServlet extends HttpServlet{
	
	UserService uServ = new UserServiceImpl();
	ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
	    PrintWriter pw = response.getWriter();
	    
	    int id = (int) session.getAttribute("id");
	    System.out.println(id + "in EmpUserServlet");
		
	    User user = uServ.getEmployeeById(id);
	    pw.write(om.writeValueAsString(user));
	    
		
	}
	

}

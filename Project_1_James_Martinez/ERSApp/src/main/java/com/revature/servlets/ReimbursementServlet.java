package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.services.impl.ReimbursementServiceImpl;
import com.revature.services.impl.UserServiceImpl;

public class ReimbursementServlet extends HttpServlet{
	
	ReimbursementService reimbServ = new ReimbursementServiceImpl();
	UserService uServ = new UserServiceImpl();
	ObjectMapper om = new ObjectMapper();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
	    PrintWriter pw = response.getWriter();
	    
	    
	    int id = (int) session.getAttribute("id");
	    System.out.println(id);
		
	    User user = uServ.getUserById(id);
	    
	    if(user.getRole().equals("manager")) {
	    	request.getRequestDispatcher("manager-reimbursement");
	    }else {
	    	request.getRequestDispatcher("employee-reimbursement");
	    }
	    
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

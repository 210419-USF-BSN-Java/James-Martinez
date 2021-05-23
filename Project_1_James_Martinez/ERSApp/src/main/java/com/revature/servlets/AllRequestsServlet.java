package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.services.impl.ReimbursementServiceImpl;
import com.revature.services.impl.UserServiceImpl;

public class AllRequestsServlet extends HttpServlet{
	
	UserService uServ = new UserServiceImpl();
	ReimbursementService reimbServ = new ReimbursementServiceImpl();
	ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		int userId = (int)session.getAttribute("id");
		System.out.println(userId +"inALLREQ");
		
		String status = request.getParameter("status");
		//String status = "pending";
		List<Reimbursement> reqList = new ArrayList<>();
		
		reqList = reimbServ.listAll(status);
		pw.write(om.writeValueAsString(reqList));
	}

}

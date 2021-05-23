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

public class ManagerReimbursementServlet extends HttpServlet{
	
	UserService uServ = new UserServiceImpl();
	ReimbursementService reimbServ = new ReimbursementServiceImpl();
	ObjectMapper om = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
	    PrintWriter pw = response.getWriter();
		int empId = Integer.parseInt(request.getParameter("userId"));
		System.out.println(empId);
	
		User user = uServ.getEmployeeById(empId);
		String status = "pending";

		if (user != null) {
			List<Reimbursement> reimbList = reimbServ.listReimbByIdandStatus(empId, status);
			pw.write(om.writeValueAsString(reimbList));
		} else {
			response.sendError(404, "Request not found");
		}
		}catch(NumberFormatException e) {
			System.out.println(e);
			doPut(request, response);
		}

	}
  
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
	    PrintWriter pw = response.getWriter();
	    
	    int resoId = (int)session.getAttribute("id");
	    System.out.println(resoId);
		int reimbId = Integer.parseInt(request.getParameter("reimbursementId"));
		System.out.println(reimbId);
		String status = request.getParameter("reimbStatus");
		System.out.println(status);
		int statusId = 0;
		
		if(status.equals("approved")){
			statusId = 2;
		}else if(status.equals("declined")) {
			statusId = 3;
		}
		System.out.println(statusId);
		
		int check = reimbServ.updateReimbursementStatus(reimbId, statusId, resoId);
		
		if(check == 0) {
			pw.write("<div style='color:red;'> Unable Resolve Request </div>");
		}else {
			pw.write("<div style='color:green;'> Request Resolved Successfully </div>");
		}
	}
	
}

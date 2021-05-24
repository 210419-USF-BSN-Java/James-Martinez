package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.services.UserService;
import com.revature.services.impl.UserServiceImpl;

public class EmployeeUpdateServlet extends HttpServlet{
	
	UserService uServ = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPut(request,response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		PrintWriter pw = response.getWriter();

		int id = (int) session.getAttribute("id");
		System.out.println(id + "in EmpUpdateServlet");

		String update = request.getParameter("updateChoice");
		String newUpdate = request.getParameter("updateText");

		int choice = 0;

		if (update.equals("firstName")) {
			choice = 1;
		} else if (update.equals("lastName")) {
			choice = 2;
		} else if (update.equals("username")) {
			choice = 3;
		} else if (update.equals("password")) {
			choice = 4;
		} else if (update.equals("email")) {
			choice = 5;
		} else {
			response.sendError(404);
		}
		System.out.println(choice);

		int check = uServ.updateEmployeeById(id, choice, newUpdate);

		if (check == 0) {
			pw.write("<div style='color:red;'> Unable Resolve Request </div>");
		} else {
			pw.write("<div style='color:green;'> Request Resolved Successfully </div>");
		}

	}

}

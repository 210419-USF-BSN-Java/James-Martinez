package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.impl.UserServiceImpl;

public class LoggedInServlet extends HttpServlet{
	
	UserService uServ = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    
	HttpSession session = request.getSession(false);
		
    PrintWriter pw = response.getWriter();
    
    int id = (int) session.getAttribute("id");
    System.out.println(id);
    
    User user = uServ.getEmployeeById(id);  //user keeps coming out null I do not know why :( im tired im sad i hate this project
    System.out.println(user);
    
    if(user != null && session != null) {
	if (user.getRole().equals("manager")) {
		pw.write("<div style='color:red;'> Welcome!"+user.getFirstName()+user.getLastName()+" </div>");
		request.getRequestDispatcher("static/manager-home.html").forward(request, response);
	}else {
		pw.write("<div style='color:red;'> Welcome!" + user.getFirstName() + user.getLastName() + " </div>");
		request.getRequestDispatcher("static/employee-home.html").forward(request, response);	
	}
    }else {
    	pw.write("<div style='color:red;'> You are not logged in! </div>");
    }
}
}

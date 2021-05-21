package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.UserDelegate;

public class RequestHelper {
	
//	UserDelegate ud = new UserDelegate();
//	ReimbursementDelegate rd = new ReimbursementDelegate();
//	
//	public void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//		
//		StringBuilder uriString = new StringBuilder(request.getRequestURI());
//		// uriString = /ERSApp/User/1
//
//		//get the relevant path
//		uriString.replace(0, request.getContextPath().length() + 1, "");
//		// uriString = User/1
//
//		if (uriString.indexOf("/") != -1) {
//			//set an attribute 'path' to be used in the delegates for additional information, ie: retrieve by id
//			 
//			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
//			//path = 1, user has been removed
//			
//			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
//			//here uriString = user
//		}
//		
//		//  Based on the uriString, the request/response are then routed to the appropriate delegate
//	    switch(uriString.toString()) {
//	    case "user":
//	        ud.process(request, response); 
//	    	break;
//	    case "reimbursement":	
//	    	rd.process(request, response);  //re-routing
//	    	break;
//	    default:
//	    	response.sendError(404, "Path not supported");
//	    }
//		
//		
//		
//		
//	}

}

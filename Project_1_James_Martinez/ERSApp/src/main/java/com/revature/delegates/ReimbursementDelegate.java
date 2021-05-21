package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.ReimbursementService;
import com.revature.services.impl.ReimbursementServiceImpl;

public class ReimbursementDelegate implements Delegatable{

	private ReimbursementService reimbService = new ReimbursementServiceImpl();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String path = (String) request.getAttribute("path");
		
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
			case "GET":
				
				break;
			case "POST":
				
				break;
			default:
				response.sendError(400, "Request not supported.");
			}
		}else{ //Validation goes here
				
			}
			
			
			
		}
	}



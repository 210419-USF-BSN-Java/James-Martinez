package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.impl.UserServiceImpl;

public class UserDelegate implements Delegatable{

	private UserService uService = new UserServiceImpl();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
String path = (String) request.getAttribute("path");
		
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
			case "GET": //logic to select
				
				break;
			case "POST": //logic to create
				
				break;
            case "PUT": //logic to update
				
				break;
			default:
				response.sendError(400, "Request not supported.");
			}
		}else{ //Validation goes here
				
			}
		
	}

}

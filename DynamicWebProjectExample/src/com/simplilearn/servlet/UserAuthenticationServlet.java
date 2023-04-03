package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAuthenticationServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  
	    { 
	        response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	          
	        out.print("Welcome ADMIN");  
	        out.close();  
	    }  
}
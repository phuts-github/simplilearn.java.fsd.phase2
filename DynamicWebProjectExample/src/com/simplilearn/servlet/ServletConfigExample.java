package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletConfigExample")
public class ServletConfigExample extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		Enumeration<String> e = config.getInitParameterNames();
	
		String str = "";
		System.out.println("Servlet Config Parameters:");
		while(e.hasMoreElements()) {
			str = e.nextElement();
			System.out.println(str + " : " + config.getInitParameter(str));
			out.print("<br>Name: " + str);
			out.print(" value:" + config.getInitParameter(str));
		}
		
		ServletContext context = getServletContext();
		Enumeration<String> contextEnum = context.getInitParameterNames();
		
		String contextStr = "";
		System.out.println("\n");
		System.out.println("Servlet Context Parameters:");
		while(contextEnum.hasMoreElements()) {
			contextStr = contextEnum.nextElement();
			System.out.println(contextStr + " : " + context.getInitParameter(contextStr));
			
		}
		
		out.close();
		
	}
	
}
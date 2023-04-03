package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextExample extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		ServletContext context = getServletContext();
		Enumeration<String> e = context.getInitParameterNames();
		
		String str = "";
		System.out.println("\n");
		System.out.println("Servlet Context Parameters:");
		while(e.hasMoreElements()) {
			str = e.nextElement();
			System.out.println(str + " : " + context.getInitParameter(str));
			out.print("<br>Name: " + str);
			out.print(" value:" + context.getInitParameter(str));
		}
		
		out.close();
	
	}
	
}
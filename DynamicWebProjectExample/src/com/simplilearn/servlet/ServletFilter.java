package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.print("my servlet filter is being invoked...");
		
		filterChain.doFilter(request, response);
		
		out.print("my servlet filter after chain operation...");
		
	}

}
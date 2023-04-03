package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserAuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,  
	        FilterChain chain) throws IOException, ServletException  {  
	          
	    PrintWriter out=resp.getWriter();  
	          
	    String password=req.getParameter("password");  
	    if(password.equals("admin")){  
	    chain.doFilter(req, resp);//sends request to next resource  
	    }  
	    else{  
	    out.print("username or password error!");  
	   }  

}
}
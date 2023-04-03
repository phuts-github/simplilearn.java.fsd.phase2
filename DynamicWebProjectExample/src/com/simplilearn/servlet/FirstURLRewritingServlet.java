package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstURLRewritingServlet
 */
@WebServlet("/FirstURLRewritingServlet")
public class FirstURLRewritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstURLRewritingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String username = request.getParameter("username"); 
        String salary = request.getParameter("salary");
        out.print("Username: " + username); 
        out.print("Salary: " + salary + "<br>"); 
        
        
       out.print("<a href='url2?uname="+username+"'>Click Me</a>");
	
       out.close();
	}
	

}
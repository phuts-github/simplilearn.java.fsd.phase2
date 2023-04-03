package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondHttpSessionServlet
 */
@WebServlet("/SecondHttpSessionServlet")
public class SecondHttpSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondHttpSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        HttpSession httpSession = request.getSession(false);
        //Getting the value from the hidden field  
        String username=(String)httpSession.getAttribute("uname"); 
        String password=(String)httpSession.getAttribute("password"); 
        
        out.print("Hello "+ username + "!!! Your paasword is: " + password + ".");  
  
        out.close();
	}

}
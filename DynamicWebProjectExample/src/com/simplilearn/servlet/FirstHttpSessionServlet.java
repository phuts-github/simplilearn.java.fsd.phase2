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
 * Servlet implementation class FirstHttpSessionServlet
 */
@WebServlet("/FirstHttpSessionServlet")
public class FirstHttpSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstHttpSessionServlet() {
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
        String password = request.getParameter("password");
        out.print("Username: " + username); 
        out.print("Password: " + password + "<br>"); 
        
        HttpSession session = request.getSession();
        session.setAttribute("uname", username);
        session.setAttribute("password", password);
        
        out.print("<a href='httpsession2'>Click Me</a>");
	
        out.close();
	}

}
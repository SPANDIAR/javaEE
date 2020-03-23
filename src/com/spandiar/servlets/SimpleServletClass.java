package com.spandiar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServletClass
 */
@WebServlet(description = "SimpleServletClass", urlPatterns = { "/SimpleServletClassPath" })
public class SimpleServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter().println("<h3>My first Servlet</h3>");
		System.out.println("This is getting printed from the Servlet's doGet method");
		response.setContentType("text/html");
		response.getWriter().println("<h3>My first servlet code</h3>");
	}

}

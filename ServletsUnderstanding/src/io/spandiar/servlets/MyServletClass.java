package io.spandiar.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServletClass
 */
@WebServlet(urlPatterns = {"/MyServletClassPath"}, initParams={@WebInitParam(name="defaultUser", value="John Doe")}) 
public class MyServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (userName == null || userName.isEmpty()) {
			response.getWriter().printf("<h3>Hello there!!! I am inside the Get method</h3>");
		}else {
			response.getWriter().printf("<h3>Hello " + userName + "!!! I am inside the Get method</h3>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the session details
		HttpSession session = request.getSession();
		
		response.getWriter().printf("Session ID: " + request.getSession().getId());
		
		// Get the init parameters from the Servlet Object Init Params
		response.getWriter().printf("Default User: " + this.getServletConfig().getInitParameter("defaultUser"));
		response.getWriter().printf("Default Country is: " + this.getServletConfig().getInitParameter("defaultCountry"));
		
		// Get the parameters supplied in the form
		String userName = request.getParameter("userName");
		String location = request.getParameter("location");
		String profession = request.getParameter("profession");
		String[] interest = request.getParameterValues("interest");
		
		response.setContentType("text/html");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		// printing the details from the form back to the response
		if (userName == null || userName.isEmpty()) {
			response.getWriter().printf("<h3>Hello there!!! I am inside the POST method</h3>");
			response.getWriter().printf("We know you are " + (String) session.getAttribute("sessionUser"));
		}else {
			// Add the user to the session
			session.setAttribute("sessionUser", userName);
			
			response.getWriter().printf("<h3>Hello " + userName + "!!! We are inside the POST method</h3>");
			response.getWriter().printf("<h3>We know you are from " + location + " and you are an " + profession + " </h3>");
			for(int i=0;i<interest.length;i++) {
				response.getWriter().printf("<h3>We also know you like " + interest[i] + " </h3>");
			}
		}
	}

}

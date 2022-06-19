package com.raju.contactus;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.raju.dao.RequestDao;
import com.raju.pojos.Request;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest servletRequest , HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=servletRequest.getRequestDispatcher("contactus.jsp");
		requestDispatcher.forward(servletRequest, response);
	}

	protected void doPost(HttpServletRequest servletRequest, HttpServletResponse response) throws ServletException, IOException {
		String name = servletRequest.getParameter("name");
		String email = servletRequest.getParameter("email");
		String message = servletRequest.getParameter("message");
		Boolean isActive = true;
		
		Request request = new Request();
		request.setName(name);
		request.setEmail(email);
		request.setMessage(message);
		request.setIsActive(isActive);
		
		RequestDao requestDao = new RequestDao();
		requestDao.saveRequest(request);
		
		response.getWriter().print("<h1>Data saved Successfully..! We well get back to you soon...!</h1>");
	}

}

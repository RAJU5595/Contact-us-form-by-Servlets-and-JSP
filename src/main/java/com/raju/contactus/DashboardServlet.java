package com.raju.contactus;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.raju.dao.RequestDao;
import com.raju.pojos.Request;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDao requestDao = new RequestDao();
		List <Request> activeRequests = requestDao.getActiveRequests();
		List <Request> archiveRequests = requestDao.getArchiveRequests();
		
		request.setAttribute("archiveRequests", archiveRequests);
		request.setAttribute("activeRequests", activeRequests);
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest servletRequest , HttpServletResponse response) throws ServletException, IOException {
		int requestId = Integer.parseInt(servletRequest.getParameter("getQueryId"));
		RequestDao requestDao= new RequestDao();
		requestDao.updateStatusOfRequest(requestId);
		response.sendRedirect("dashboard");
	}
}

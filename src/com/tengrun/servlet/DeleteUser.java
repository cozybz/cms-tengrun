package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.tools.DAOfactory;

public class DeleteUser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOfactory.getUserDAOInstance().delete(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("UserManager");
	}

}

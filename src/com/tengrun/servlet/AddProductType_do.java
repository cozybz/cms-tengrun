package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.tools.DAOfactory;

public class AddProductType_do extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DAOfactory.getProductTypeDAOInstance().insert(request.getParameter("name"));
		response.sendRedirect("ProductTypeManager");
	}

}

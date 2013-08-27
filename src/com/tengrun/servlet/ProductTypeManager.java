package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.ProductType;
import com.tengrun.pojo.User;
import com.tengrun.tools.DAOfactory;

public class ProductTypeManager extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ProductType> all=DAOfactory.getProductTypeDAOInstance().queryAll();
		request.setAttribute("all", all);
		request.getRequestDispatcher("/WEB-INF/WebFiles/admin/ProductTypeManager.jsp").forward(request, response);
	}

}

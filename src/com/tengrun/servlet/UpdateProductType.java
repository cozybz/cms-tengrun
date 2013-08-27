package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.ProductType;
import com.tengrun.tools.DAOfactory;

public class UpdateProductType extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductType productType =DAOfactory.getProductTypeDAOInstance().queryById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("productType", productType);
		request.getRequestDispatcher("/WEB-INF/WebFiles/admin/UpdateProductType.jsp").forward(request, response);
	}

}

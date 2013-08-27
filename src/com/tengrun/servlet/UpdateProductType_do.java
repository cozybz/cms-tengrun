package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.ProductType;
import com.tengrun.tools.DAOfactory;

public class UpdateProductType_do extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ProductType productType=new ProductType();
		productType.setId(Integer.parseInt(request.getParameter("id")));
		productType.setProjectType(request.getParameter("name"));
		DAOfactory.getProductTypeDAOInstance().update(productType);
		response.sendRedirect("ProductTypeManager");

	}

}

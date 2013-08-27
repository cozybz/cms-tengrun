package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.Product;
import com.tengrun.pojo.ProductType;
import com.tengrun.tools.DAOfactory;
public class UpdateProduct extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ProductType> all=null;
		all=DAOfactory.getProductTypeDAOInstance().queryAll();
		request.setAttribute("all", all);
		Product product =DAOfactory.getProductDAOInstance().queryById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("product", product);
		request.getRequestDispatcher("/WEB-INF/WebFiles/admin/UpdateProduct.jsp").forward(request, response);

	}

}

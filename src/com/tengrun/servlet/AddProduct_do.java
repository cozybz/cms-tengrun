package com.tengrun.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.Product;
import com.tengrun.tools.DAOfactory;

public class AddProduct_do extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Product product=new Product();
		product.setImgUrl(request.getParameter("imgUrl"));
		product.setInformation(request.getParameter("content"));
		product.setName(request.getParameter("name"));
		product.setProductType(request.getParameter("productType"));
		DAOfactory.getProductDAOInstance().insert(product);
		response.sendRedirect("ProductManager");
	}

}

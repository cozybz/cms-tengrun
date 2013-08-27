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

public class InfoDisplay extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("id")!=null&&!request.getParameter("id").equals(""))
		{
		Product product =DAOfactory.getProductDAOInstance().queryById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("product", product);
		}
		request.getRequestDispatcher("/WEB-INF/WebFiles/infodisplay.jsp").forward(request, response);
	}

}

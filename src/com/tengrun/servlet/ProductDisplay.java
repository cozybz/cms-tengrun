package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.Product;
import com.tengrun.tools.DAOfactory;

public class ProductDisplay extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("type")!=null)
		{
			List<Product> all=null;
			int totalpage=0;
			String type=null;
			type = new String(request.getParameter("type").getBytes("ISO-8859-1"), "UTF-8");
			int curpage;
			if(request.getParameter("curpage")!=null)
			{curpage=Integer.parseInt(request.getParameter("curpage"));}
			else{curpage=1;}
			
			totalpage=DAOfactory.getProductDAOInstance().totalPage(type, 6);
			all=DAOfactory.getProductDAOInstance().queryByPage(type, 6, curpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("curpage", curpage);
			request.setAttribute("all", all);
		}
		request.getRequestDispatcher("/WEB-INF/WebFiles/productdisplay.jsp").forward(request, response);
	}

}

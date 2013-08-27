package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.Product;
import com.tengrun.tools.DAOfactory;

public class ProductManager extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		List<Product> all=null;
		String keyword=request.getParameter("keyword");
		if(keyword==null)
		{
			int totalpage=0;
			int curpage;
			if(request.getParameter("curpage")!=null)
			{curpage=Integer.parseInt(request.getParameter("curpage"));}
			else{curpage=1;}
			totalpage=DAOfactory.getProductDAOInstance().totalPage(null, 8);
			all=DAOfactory.getProductDAOInstance().queryByPage(null, 8, curpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("curpage", curpage);
		}else{
			all=DAOfactory.getProductDAOInstance().queryByLike(keyword);
		}
		request.setAttribute("all", all);
		request.getRequestDispatcher("/WEB-INF/WebFiles/admin/ProductManager.jsp").forward(request, response);
	}

}

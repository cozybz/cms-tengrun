package com.tengrun.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.Product;
import com.tengrun.tools.DAOfactory;



public class Index extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> allNews=null;
		allNews=DAOfactory.getProductDAOInstance().queryByPage("新闻", 8, 1);
		request.setAttribute("allNews", allNews);
		
		List<Product> allImgs1=null;
		List<Product> allImgs2=null;
		List<Product> allImgs3=null;
		allImgs1=DAOfactory.getProductDAOInstance().queryByPage("首页滚动图片", 3, 1);
		allImgs2=DAOfactory.getProductDAOInstance().queryByPage("首页滚动图片", 3, 2);
		allImgs3=DAOfactory.getProductDAOInstance().queryByPage("首页滚动图片", 3, 3);
		request.setAttribute("allImgs1", allImgs1);
		request.setAttribute("allImgs2", allImgs2);
		request.setAttribute("allImgs3", allImgs3);
		
		request.getRequestDispatcher("/WEB-INF/WebFiles/index.jsp").forward(request, response);

	}
}

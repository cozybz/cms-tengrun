package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tengrun.pojo.User;
import com.tengrun.tools.DAOfactory;

public class Loginyz extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=new User();
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));
		HttpSession ht=request.getSession();
		if(DAOfactory.getUserDAOInstance().loginyz(user))
		{
			ht.setAttribute("username",user.getUsername());
			request.getRequestDispatcher("/admin/adminMain").forward(request, response);
		}else{
			ht.setAttribute("login", "登陆失败");
			request.getRequestDispatcher("/WEB-INF/WebFiles/login.jsp").forward(request, response);;
		}
	}
	}


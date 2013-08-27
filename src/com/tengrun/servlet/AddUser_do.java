package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.User;
import com.tengrun.tools.DAOfactory;


public class AddUser_do extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user=new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		DAOfactory.getUserDAOInstance().insert(user);
		response.sendRedirect("UserManager");

	}

}

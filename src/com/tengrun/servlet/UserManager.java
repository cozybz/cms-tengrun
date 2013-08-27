package com.tengrun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tengrun.pojo.User;
import com.tengrun.tools.DAOfactory;

public class UserManager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> all=DAOfactory.getUserDAOInstance().queryAll();
		request.setAttribute("all", all);
		request.getRequestDispatcher("/WEB-INF/WebFiles/admin/UserManager.jsp").forward(request, response);
	}

}

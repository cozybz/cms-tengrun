package com.tengrun.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFile extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("path");
		File file=new File(name);
		file.delete();
		request.getRequestDispatcher("/WEB-INF/WebFiles/admin/UploadManager.jsp").forward(request, response);

	}

}

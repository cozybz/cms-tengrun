<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jspsmart.upload.*"%>
<%@ page import="java.text.*"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  <%
  SimpleDateFormat   formatter   =new   SimpleDateFormat( "yyyyMMddHHmmss"); 
  Date   currentTime=new   Date(); 
  String time=formatter.format(currentTime); 
  
  	boolean x=false;
  	String y=null;
	SmartUpload smart=new SmartUpload();
	smart.initialize(pageContext);
	
	smart.upload();

		String ext=smart.getFiles().getFile(0).getFileExt();
		if(smart.getFiles().getFile(0).getSize()!=0)
		{
		x=true;
		String filename=time+"."+ext;
		y="upload/"+filename;
		smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/")+"upload"+java.io.File.separator+filename);
		}

	request.setAttribute("resultx",x);
	request.setAttribute("resulty",y);
	pageContext.forward("/admin/UploadManager");
  %>
  
  </body>
</html>

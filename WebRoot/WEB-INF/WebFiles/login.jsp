<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    
    <title>管理登录</title>
    <base href="<%=basePath%>">
  </head>
  
  <body>
<div style="width:403px; height:222px; background:url(images/login.png); margin:150px auto;">
	<div style="width:403px; height:69px;"></div>
	<div style="width:190px; height:153px; margin-left:213px;">
    	<form action="loginyz" method="post">
        	<input type="text" name="username"  size="14"/>
            <input type="password" name="password" size="14" style="margin-top:15px;" /><br>
            <input type="submit" value="登录"  style="margin-top:10px;"/>
        </form>
    </div>
</div>
  </body>
</html>

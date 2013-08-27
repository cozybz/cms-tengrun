<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>产品分类管理</title>
<style type="text/css"> 
*{
	padding:0;
	margin:0;
	outline:none;
}
body{
	font:宋体 Verdana, Geneva, sans-serif;
	font-size:12px;
}
#lefter{
	width:205px;
	background-color:#F2F2F2;
	height:200px;
}
#lefter ul{
	border:1px;
	line-height:2em;
}
.bar1{
	list-style:none;
	display:block;
	padding-left:80px;
	background-image:url(images/htline2.jpg);
	background-repeat:no-repeat;
}
.bar2{
	list-style:none;
	display:block;
	background-color:#F2F2F2;
	height:10px;
}
#lefter ul li a{
	color:#FFF;
	text-decoration:none;
}
#lefter ul span{
	display:block;
	width:205px;
	height:15px;
	background-image:url(images/htline1.jpg);
}
#lefter ul li a:link {
 color:#FFF;
 text-decoration: none;
}
#lefter ul li a:visited {
 color:#FFF;
 text-decoration: none;
}
#lefter ul li a:hover {
 color:#000;
 text-decoration: underline;
}
</style>

<style type="text/css">
.content {width:550px;margin:20px auto;}
table {width:100%;}
th, td {    padding:6px 0;text-align:center;}
th { background-color:#007D28 color:#ffffff;  }
tr {background-color:#edf5fd;}
.odd {background-color:#e4edf6;} 
.highlight { background-color:#E0E0E0;  }
</style> 
<script type="text/javascript">
function addClass(element, value) {   
if(!element.className) {
	element.className = value; } 
	else { 
	element.className += " "+value;   }
	}    
function stripeTable() {
	var tables = document.getElementsByTagName("table"); 
	for(var i=0; i<tables.length; i++) {
		var rows = document.getElementsByTagName("tr");      
		for(var j=0; j<rows.length; j++) { 
			if(j%2 == 0) {  
				addClass(rows[j], "odd");  
				rows[j].setAttribute("class", "odd"); }
				}  
			}
		} 
function highlightRows() {
	var rows = document.getElementsByTagName("tr"); for(var i=0; i<rows.length; i++) {  rows[i].oldClassName = rows[i].className;rows[i].onmouseover = function() {
		addClass(this, "highlight");   
		} 
		rows[i].onmouseout = function() { this.className = this.oldClassName;
		} 
	} 
}
window.onload = function() { 
stripeTable(); highlightRows(); } 
</script>
  </head>
  
  <body>
  
  <div style="width:960px; background: #999; margin:0 auto;">
    	<!--头部-->
    	<div style=" width:960px; height:220px; background:#DD22B8; background:url(images/header.jpg)">
        			<div style=" height:220px; width:300px; padding-top:150px; padding-left:20px; font-size:24px; font-weight:bold; font-family:Georgia, 'Times New Roman', Times, serif;">唐山藤润金属制品后台管理</div>
        </div>
    	<!--主体-->
        <div style=" width:960px; height:450px; background:#999; margin-top:5px;">
        <!--导航-->
        				<div style=" width:205px; height:450px; background-color:#F2F2F2; float:left;">
					        	<div id="lefter">
					                <ul>
					                <span></span>
					                   <li class="bar1"><a href="admin/AddUser">增加用户</a></li>
					                   <li class="bar2"></li>
					                   <li class="bar1"><a href="admin/UserManager">管理用户</a></li>
					                   <li class="bar2"></li>
					                   <li class="bar1"><a href="admin/AddProduct">增加产品</a></li>
					                   <li class="bar2"></li>
					                   <li class="bar1"><a href="admin/ProductManager">管理产品</a></li>
					                   <li class="bar2"></li>
					                   <li class="bar1"><a href="admin/AddProductType">增加产品分类</a></li>
					                   <li class="bar2"></li>  
					                   <li class="bar1"><a href="admin/ProductTypeManager">管理产品分类</a></li>
					                   <li class="bar2"></li> 
					                   <li class="bar1"><a href="admin/UploadManager">文件上传</a></li>
					                   <li class="bar2"></li>  
					                   <span></span> 
					                </ul>
								</div>
        				</div>
        <!--操作-->
        <div style=" width:750px; height:450px; background-color:#F2F2F2; margin-left:5px; float:left;">
        			<div style=" background: url(images/zhuti.jpg); width:750px; height:30px;">
            				<div style="width:90px; height:30px; margin-left:35px; font-weight:bold; padding-top:10px;">产品分类管理</div>
            		</div>
					<div>
					<table>
					<tr>
					<th>板块ID</th>
					<th>板块名</th>
					<th>修改</th>
					<th>删除</th>
					</tr>
					<c:forEach var="productType" items="${requestScope.all}">
					<tr>
						<td>${productType.getId() }</td>
						<td>${productType.getProductType() }</td>
						<td><c:if test="${productType.getId()!=5&&productType.getId()!=6}"><a href="admin/UpdateProductType?id=${productType.getId() }">修改</a></c:if></td>
						<td><c:if test="${productType.getId()!=5&&productType.getId()!=6 }"><a href="admin/DeleteProductType?id=${productType.getId() }">删除</a></c:if></td>
					</tr>
					</c:forEach>
					
					</table>   
					</div>
            	
            </div>
        </div>

        <!--尾部-->
        <div style=" width:960px; height:150px; background: #069; margin-top:5px;"></div>
    </div>
  
  

  
  </body>
</html>









  
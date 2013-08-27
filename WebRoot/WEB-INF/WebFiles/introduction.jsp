<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <base href="<%=basePath%>">
<style type="text/css">
#right .box {
    width:182px;
    margin:-1px 0 7px 0;
}

#right h2 {
    background:url(images/sidenav.png) no-repeat;
    font-size:12px;
    height:16px;
    line-height:16px;
    margin:0px;
    padding:6px 10px;
    display:block;
    text-decoration:none;
    color:#000;
    letter-spacing:0px;
}

#right .inside, #right .box ul {
    background:url(images/sidenav_strip.jpg) no-repeat;
}

#right .gradient {
    background:#f0f6f7 url(images/h300.png) repeat-x; 
    margin:0 3px;   
    padding:6px 8px;
}

#right .gradient.ruby {
    background:#fff url(images/h150.png) repeat-x;
}

#right .clear {
    background:url(images/sidenav.png) no-repeat 0 -353px;
    height:10px;    
}


/* box content */
#right .box ul {
    margin:0;
    padding:0;
}

#right .box li {    
    list-style-type:none;       
}

#right .box a {
    display:block;
    padding:5px 8px;
    border-bottom:1px solid #ddd;
    text-decoration:none;   
    font-size:11px;
    margin:0px 3px;
}

#plugins_index #right .box a {
    padding:4px 8px;
    font-size:11px;
}

#right .box a:hover {
    background-color:#d9dee3;
    color:black;
    }
.imgbox{
width: 220px;
 height: 220px;
 border:1px solid #099 ;
 float: left;
 margin-top:20px;
 margin-left: 10px;
}

</style>

  <link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="js/jquery.tools.min.js"></script>
    <title>管理登录</title>
    
  </head>
  
<body>
<div id="bg">
<div id="container">
   <div id="header" style="background-image:url(images/head.gif)">
   </div>
   <div class="clearfloat"></div>
   <div id="nav">
       <div class="nav_main">
         <ul>
           <li><a href="index"><span>首页</span></a></li>
           <li><a href="ProductDisplay?type=新闻"><span>企业新闻</span></a></li>
           <li><a href="introduction"><span>企业简介</span></a></li>
           <li><a href="ProductDisplay?type=宠物笼"><span>产品展厅</span></a></li>
           <li><a href="#"><span>联系我们</span></a></li>
        </ul>
        <div class="clearfloat"></div>
       </div>    
   </div>
   <div id="headImg">
       <div class="change" style="margin-top:0px;">
         <ul>
                <li><img src="images/scroll1.jpg"/></li>
                <li><img src="images/scroll2.gif"/></li>
                <li><img src="images/scroll3.gif"/></li>
                <li><img src="images/scroll4.jpg"/></li>
          </ul>
       </div>
   
   </div>
 <div>
   <div id="pageB" style="height:300px; margin-top:3px;float: left">
		        <div id="pageBA" style="width: 228px; border:1px solid #09C;">
					            <div id="pageBATittle" style="height:30px;">
					                <img src="images/pageCALogo.gif" alt="产品类别"/>
					            </div>
					            <div id="pageBAContent" style="height:260px; background-color:#FFF; padding-top:10px;background:url(images/h300.png) repeat-x;">
					                <!--分类内容-->
							                <table style="width:200; height:200px; margin-left:15px; ">
							                    <tr><td>地址：</td><td>天津市海北工业区</td></tr>
							                    <tr><td>电话：</td><td>022-69357677</td></tr>
							                    <tr><td>手机：</td><td>13821953277</td></tr>
							                    <tr><td>传真：</td><td>022-69356662</td></tr>
							                    <tr><td>邮编</td><td>301506</td></tr>
							                </table>
					            </div>
		        </div>
			        <div id="pageCA" style="width: 228px;margin-top:3px ; border:1px solid #099;">
				            <div id="pageBATittle" style="height: 30px;">
				                <img src="images/pageBALogo.gif" align="联系我们"/>
				            </div>
			            <div id="pageBAContent" style="height: 232px; background-color:#FFF; padding-left:20px;background:url(images/h300.png) repeat-x;">
								<div id="right" >
										<div class="box">
											<ul>
					<center><li ><a href="ProductDisplay?type=宠物笼" style="font-size: 18px;">宠物笼</a></li></center>
					<center><li ><a href="ProductDisplay?type=宠物围栏" style="font-size: 18px;">宠物围栏</a></li></center>
					<center><li ><a href="ProductDisplay?type=铁艺钩" style="font-size: 18px;">铁艺钩</a></li></center>
					<center><li ><a href="ProductDisplay?type=铁艺门" style="font-size: 18px;">铁艺门</a></li></center>
					<center><li ><a href="ProductDisplay?type=栅栏" style="font-size: 18px;">栅栏</a></li></center>
					<center><li ><a href="ProductDisplay?type=园艺装饰品" style="font-size: 18px;">园艺装饰品</a></li></center>
											</ul>
										</div>
								</div>
			            </div>
	        </div>
   </div>
   

   
    <div id="pageC"  style="border:1px solid #099;margin-top:3px;margin-left:5px;width: 723px;height:566px;background:u#f6f7f8;float: left;">
    
	       <div style="width: 723px;height: 30px;background-image:url(images/zhuti.jpg); " >
	      			<div style="font-weight:bold; margin-left: 22px;padding-top: 5px;"><p>企业简介</p></div>
		    </div>
	    
	    
	    

	    		<div style="width: 723px;height:60px;border-bottom: solid 3px #6d9ed0;"><center><h1 style="padding-top:20px; ">企业简介</h1></center></div>
	    		<div style="width: 723px;height:471px;border-bottom: solid 1px #6d9ed0;">
	    		<img src="images/company.jpg" alt="公司近照" style="float:left; margin-right:10px; width: 150px;height: 130px; margin-left: 5px;">
	    		<p>&nbsp;&nbsp;&nbsp;&nbsp;唐山藤润金属制品有限公司位于天津市芦台经济开发区海北工业区，公司驻地紧靠112国道，地理位置十分优越，交通非常便利。公司建于2005年，是一家专业从事金属制品生产，集设计，开发，生产，销售于一体的发展中公司，生产的产品远销美国、澳大利亚等国。公司具有先进的技术，可靠的质量保证，完善的售后服务。我们恪守“务实、创新、诚信、高效”的经营理念，坚持以人为本，谋求长足发展。 公司总经理曹荣存诚望与有志于创业的国内外朋友和公司全体员工一道携手并进，共创辉煌。</p>

	    		</div>

	    
	  		  

	    		
	    	

    </div>
    
    
</div>
    <div style="clear: both;"></div>
    <div id="pageD" style="margin-top:10px;height: 80px;border-top: solid 10px #6d9ed0;background-color: #f6f7f8)">
    <center><p style="margin-top:20px;font-size: 12px;"> 　唐山藤润金属制品有限公司　版权所有</p></center>
    <center><p style="font-size: 12px;margin-top: 1px;" >Copyright (C) 2011-2012　</p></center>
    </div>
    
</div>
</div>





<script type="text/javascript" language="javascript">
		 $(document).ready(function(){
		 var objStr = ".change ul li";
		 $(objStr + ":not(:first)").css("display","none");
		 setInterval(function(){
		 if( 
			 $(objStr + ":last").is(":visible")){
		  $(objStr + ":first").fadeIn("slow").addClass("in");
		  $(objStr + ":last").hide()
		 }
		 else{
		  $(objStr + ":visible").addClass("in");
		  $(objStr + ".in").next().fadeIn("slow");
		  $(objStr + ".in").hide().removeClass("in")}
		 },5000) //每3秒钟切换
		})
</script>

</body>
</html>




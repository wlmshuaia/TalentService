<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/admin/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    <link href="<%=request.getContextPath()%>/CSS/head.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  	<%@ include file="/front/frame/header.jsp" %>
  	<div id="main" style="background-color:#efeff5; padding:20px;">
    	<div id="login_box" style="width:400px; height:450px; margin:0 auto; background-color:#fbfbfd">
        	<s:form action="login/wloginAction_login.action" method="post">
	        	<div style="background-color:#fbfbfd; height:72px;">
	            	<img src="<%=request.getContextPath()%>/images/logo.gif"  style=" float:left;"/> 
	                <p style="color:#ff6800; float:left; margin-left:50px; font-size:30px; line-height:10px;">用户登录</p>
	            </div>
        
        		<div style="margin-left:73px; margin-top:40px; width:255px; height:48px; border:#b3d5dd thin solid;background-color:#b3d5dd; border-radius:7px;">
                	<img src="<%=request.getContextPath()%>/images/yonghuming.gif" style="float:left; margin-left:5px;"/>
                	<input type="text" required placeholder="用户名" name="username" id="idname" style=" font-family:微软雅黑; border:none; outline:none; width:203px; height:45px; background-color:#b3d5dd;  color:#FFF; font-size:20px; float:left;" />
        		</div>
        		
                <div style="margin-left:73px; margin-top:20px; width:255px; height:48px; border:#3e6372 thin solid;background-color:#3e6372; border-radius:7px;">
                    <img src="<%=request.getContextPath()%>/images/mima.gif" style="float:left; margin-left:5px;"/>
                    <input type="password" required placeholder="密码" name="password" id="passwd" style=" font-family:微软雅黑; outline:none; border:none; width:203px; height:45px;  color:#FFF; font-size:20px;background-color:#3e6372; float:left;"  />
        		</div>
        		<input type="submit" value="登录" style="margin-left:73px; border:#ff6800 solid thin; border-radius:7px; outline:none; background-color:#ff6800; margin-top:40px;color:#FFF; width:255px; height:50px; font-family:'微软雅黑'; font-size:20px; text-align:center; letter-spacing:30px; text-indent:2em;" />

		        <div style="margin-left:50px; margin-top:60px; width:290px; height:30px;">
		        	<a style=" margin-left:3px; float:left;">忘记密码？</a>
		        	<a style="float:left; margin-left:70px;">未注册？</a>
		            <s:a action="" style="float:left; color:#ff6800">点击注册</s:a>
		        </div>
		   </s:form>
		 </div>
    </div>
    
	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

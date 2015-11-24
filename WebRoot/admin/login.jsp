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
  
  <div id="main" style="background:url(<%=request.getContextPath()%>/images/beijing.gif); background-size:100%; height: 100%;">
	  <div style="width:1120px; height:auto; margin:0 auto;">
	      <img src="<%=request.getContextPath()%>/images/logo5.png" style="float:left; margin-top: 250px; width: ; height: ; " />
	      <s:form action="alogin/aloginAction_login.action" method="post" style="float: left; margin-top: 250px;">
		      <div id="login_box" style=" width:255px; float:left; margin-top:80px; margin-left:150px; opacity:0.8;">     
		          <div style=" width:255px; height:60px;background-color:#4a4e57; border-radius:7px;">
		              <img src="<%=request.getContextPath()%>/images/yonghuming_houtai.gif" style="float:left; margin-left:5px;"/>
		              <s:textfield placeholder="用户名" name="adminname" id="idname" style="font-family:微软雅黑; border:none; outline:none; width:195px; margin-left:5px; height:58px; background-color:#4a4e57;  color:#FFF; font-size:20px; float:left;" />
		          </div>
		          <div style=" margin-top:2px;width:255px; height:60px;background-color:#4a4e57; border-radius:7px;">
		              <img src="<%=request.getContextPath()%>/images/mima_houtai.gif" style="float:left; margin-left:5px;"/>
		              <s:password placeholder="密码" name="adminpassword" id="passwd" style=" font-family:微软雅黑; outline:none; border:none; width:195px; height:58px;  color:#FFF; font-size:20px;background-color:#4a4e57; float:left; margin-left:5px;" />
		          </div>
		      </div>
		      <input type="submit" value="" onmouseover="this.style.opacity='0.2';" onmouseout="this.style.opacity='0.5';" style=" background-image:url(<%=request.getContextPath()%>/images/houtai_button.gif); opacity:0.5;float:left; font-size:36px; cursor:pointer; height:122px; width:80px; border:none; border-radius:7px; margin-top:80px;" />
	      </s:form>
  </div>
  
  
	<%--<s:form action="alogin/aloginAction_login.action" method="post">
		用户名：<s:textfield name="adminname" />
		密码：<s:password name="adminpassword" />
		<s:submit label="登录" />
	</s:form>
  --%></body>
</html>

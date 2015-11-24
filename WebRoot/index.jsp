<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.talentservice.utils.OAUtils, com.talentservice.domain.User"%>
<%@ include file="/admin/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>人才服务社交平台</title>

	<!-- Set render engine for 360 browser -->
	<meta name="renderer" content="webkit">
	
	<style type="text/css">
		.headImage { width: 100%; height:616px; margin:0 auto;}
		.headImage img { width: 100%;}
		#sige{ width: 100%; overflow:hidden; padding-bottom:20px; margin:0 auto;}
		#sige div{ width:155px; height:180px; float:left; margin-top:75px;}
		#sige div ul{ padding:0; width:125px; height:125px; margin:0; margin-left:15px;}
		#sige div li{ list-style:none; color:#3e6372; font-size:25px; padding:;}
	</style>
	
  </head>
  
  <body >
	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#fff; padding-bottom:30px;">
    	<div class="headImage">
			<img src="<%=request.getContextPath()%>/images/shouye1.gif" />    
        </div>
        <div id="sige">
        	<div style="margin-left:220px;"><ul style="background:url(<%=request.getContextPath()%>/images/shouye3.gif);"></ul><li>发布承接项目</li></div>
            <div style="margin-left:400px;"><ul style="background:url(<%=request.getContextPath()%>/images/shouye4.gif);"></ul><li>就业实训平台</li></div>
            <div style="margin-left:500px;"><ul style="background:url(<%=request.getContextPath()%>/images/shouye5.gif);"></ul><li>发现爱好圈子</li></div>
            <div style="margin-left:400px;"><ul style="background:url(<%=request.getContextPath()%>/images/shouye6.gif);"></ul><li>建立我的人脉</li></div>
        </div>
    </div>
	<%@ include file="/front/frame/bottom.jsp" %>
	<%--<ul>
		<li>
			<%
				User user = (User) OAUtils.fromSession("user") ;
				if(user != null){
					out.println("欢迎您："+user.getUsername()+"  <a href='login/wloginAction_logout.action'>退出</a>");
				}else{
					out.println("<a href='login/wloginAction_loginUI.action'>登录</a> <a href='register/wregisterAction_registerUI.action'>注册</a>");
				}
			%>
		</li>
	</ul>
  --%>
  </body>
</html>

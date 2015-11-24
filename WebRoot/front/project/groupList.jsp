<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.lang.Integer, com.talentservice.utils.DataUtils"%>
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
    
    <title>团队列表</title>
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
    <style type="text/css">
    	.projectType {}
    	.projectType ul {}
    	.projectType ul li { float: left; margin-left: 5px; border: gray 1px solid; padding: 3px; background: white;}
    	.projectType ul li a {text-decoration: none; color: #5c9ec3;}
    	.projectType ul li a span {color: #b34300;}
    	
    	a{ text-decoration:none;}
    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	
	<div id="main" style="background-color:#efeff5; height: auto; margin:0 auto; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:30px; margin:0 auto; border:2px dashed #999; border-radius:5px; margin-top:5px;">
        	<span style="font-size:20px; margin-left:5px; font-size:20px;">当前位置</span>
        	>><a>首页</a>>>
            <a>我的团队</a>
            
        </div>
    	<div style=" width:960px; min-height: 1200px; margin:0 auto; margin-top:5px;">
            <div style="width:790px; background:#FFF; min-height: 600px; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
            	
            	<div style="width:750px; height:60px; border-bottom:2px #e7f1f3 dotted; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">团队管理</div>
                <div>
					<s:iterator value="dataList">
						<ul>
							<li>团队编号：<s:property value="groupnumber" />&nbsp;&nbsp;&nbsp;&nbsp;<s:a action="wprojectAction_groupTalkUI.action?gid=%{gid}">进入聊天</s:a></li>
							<li>团队名称：<s:property value="groupname" /></li>
							<li>创建时间：<s:property value="foundtime" /></li>
							<li>创建人：<s:property value="user.username" /></li>
							<li>所属项目：<s:property value="project.title" /></li>
						</ul>
					</s:iterator>
                </div>
            </div>
       	</div>
    </div>
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

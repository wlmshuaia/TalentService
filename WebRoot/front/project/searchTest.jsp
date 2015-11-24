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
    
    <title>搜索結果</title>
    
    <style type="text/css">
    	.projectType {}
    	.projectType ul {}
    	.projectType ul li { float: left; margin-left: 5px; border: gray 1px solid; padding: 3px; background: white;}
    	.projectType ul li a {text-decoration: none; color: #5c9ec3;}
    	.projectType ul li a span {color: #b34300;}
    	
    	a{ text-decoration:none;}
    </style>
    
    <script type="text/javascript">
    	function handle() {
    		alert('handle');
    	}
    </script>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	
	<div>
		搜索结果。
		<s:form action="project/
		luceneAction_getSearch.action">
			<s:textfield onpropertychange="handle();" oninput="handle();" name="field"></s:textfield>
			<s:submit value="搜索"></s:submit>
		</s:form>
	</div>
	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

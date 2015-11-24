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
    
    <title>搜索结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
            <a>搜索結果</a>
            
        </div>
    	<div style=" width:960px; min-height: 1200px; margin:0 auto; margin-top:5px;">
            <div style="width:790px; background:#FFF; min-height: 600px; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
            	
            	<div style="width:750px; height:60px; border-bottom:2px #e7f1f3 dotted; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">搜索结果</div>
                <div>
                	共 <s:property value="#dataList.size()" /> 条<br>
					<s:iterator value="dataList">
						<ul>
							<li>标题：<s:a action="project/wprojectAction_getInfo.action?pid=%{pid}"><s:property value="title" escape="false" /></s:a></li>
							<li>描述：<s:property value="description" escape="false" /></li>
						</ul>
					</s:iterator>
                </div>
            </div>
       	</div>
    </div>
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.lang.Integer"%>
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
    
    <title>项目列表</title>
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
	
    <style type="text/css">
		#xuesheng{width:100%; padding-bottom:20px; margin-top:30px;}
		#xuesheng li{ width:100%; margin-top:10px; height:40px; list-style:none;}
		#xuesheng li div{ float:left; width:40px; height:40px;background:url(<%=request.getContextPath()%>/images/yanshi.gif); background-size: cover; border-radius:40px;}
		#xuesheng li span{ display:block; height:30px; font-size:18px; margin-top:4px; margin-left:30px; float:left;}
    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; padding-bottom:20px; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:30px; margin:0 auto;font-size:20px; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a>学生列表</a>
        </div> 		
        
        <div style=" width:960px; padding-bottom:20px; margin:0 auto; background:#FFF; border-top:3px #ff6900 solid; border-radius:5px 5px 0 0 ; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;">
            <div style=" width:870px; margin:0 auto;margin-top:30px;">
                <div style="overflow:hidden;">
                    <div style="float:left; height:40px; font-size:24px;">我的学生:</div>
                    <input type="text" style="display:block; float:left; height:38px; width:200px; font-size:24px; margin-left:40px;" />
                    <div style=" float:left; width:50px; height:40px; background:url(<%=request.getContextPath()%>/images/search.png); float:left; border:1px #ff6900 solid; margin-left:2px; border-radius:2px; box-shadow:2px 0px #ff6900;"></div>
                </div>
                
                <s:iterator value="dataList">
                	<div id="xuesheng">
	                	<li>
	                    	<div style=" float:left; width:40px; height:40px;background:url(<%=request.getContextPath()%>/images/yanshi.gif); background-size: cover; "></div>
	                        <span><s:a action="studentAction_getProjects.action?sid=%{sid}"><s:property value="name" /></s:a></span>
	                        <span><s:property value="sex" /></span>
	                        <span><s:property value="professional" /></span>
	                    </li>
	                </div>
                </s:iterator>
                
            </div>
        </div>
    </div>	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

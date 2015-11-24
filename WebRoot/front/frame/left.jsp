<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.talentservice.domain.User, com.talentservice.utils.OAUtils" %>
<%@ include file="/admin/common/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>导航</title>
    
	<link href="<%=request.getContextPath()%>/CSS/head.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		#liebiao{ width:166px; min-height:180px; background:#FFF;border-bottom:1px #dde0e1 solid; box-shadow:0px 1px #b7b7ba;}
		#liebiao li{ list-style:none;  width:166px; height:50px; color:#4c6d7b; font-size:18px; text-align:center; line-height:3em;}
		#liebiao li a{  color:#4c6d7b;}
		#fc a{ display:inline-block; width:83px; height:105px;}
		#fc a:hover{ cursor:pointer;}
		#liebiao li a:hover{ color:#ff6900; cursor:pointer;}
		
	</style>
  </head>
  
  <body>
  
	<div style="width:166px; float:left; height: auto;">
	    <div id="fc" style=" width:166px; min-height:105px;">
	        <div style="width:83px; height:105px; float:left; background:url(<%=request.getContextPath()%>/images/fabu.gif)"><a></a></div>
	        <div style="width:83px; height:105px; float:left; background:url(<%=request.getContextPath()%>/images/chengjie.gif)"><a href=""></a></div>
	    </div>
	    
	    <div id="liebiao">
	        <li><a>项目管理</a></li>
	        <li><a>计划管理</a></li>
	        <li><a>评价管理</a></li>
	        <li><a>团队管理</a></li>
	    </div>
	 </div> 
	 
  </body>
</html>

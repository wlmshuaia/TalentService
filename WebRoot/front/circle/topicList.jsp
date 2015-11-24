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
    
    <title>话题列表</title>
   	
  </head>
  
  <body>
  	话题列表，
  	<s:iterator value="dataList">
  		<ul>
  			<li>标题：<s:a action="wcircleAction_topicInfo.action?tid=%{tid}"><s:property value="title" /></s:a></li>
  			<li>描述：<s:property value="content" /></li>
  			<li>所属圈子：<s:a action="wcircleAction_dataList.action?cid=%{circle.cid}"><s:property value="circle.circlename" /></s:a></li>
  			<li>创建时间：<s:property value="foundtime" /></li>
  			<li>创建人：<s:property value="user.username" /></li>
  		</ul>
  	</s:iterator>
  </body>
</html>

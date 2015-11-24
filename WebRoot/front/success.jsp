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
    
    <title>success</title>
    
    <script type="text/javascript">
    	$(function(){
    		setTimeout(function(){
    			//window.location.href = '/TalentService/index.jsp';
    			window.location.href = '/TalentService/project/wprojectAction_dataList.action';
    		}, 2000);
    		
    	});
    </script>
    
  </head>
  
  <body>
	success.<br />
	<a href="/TalentService/index.jsp">首页</a>
  </body>
</html>

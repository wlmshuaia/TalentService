<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/admin/common/common.jsp" %>
<%@ page import="com.talentservice.utils.OAUtils, com.talentservice.domain.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传测试</title>

  </head>
  
  <body>
  	
  <form action="user/userAction_upload.action" enctype="multipart/form-data" method="post">
      	文件:<input type="file" name="file">
        <input type="submit" value="上传" />
  </form><br/>
  <s:fielderror />
  
  </body>
</html>

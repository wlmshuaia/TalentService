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
    
    <title>注册</title>
    
    <style>
		table{ color:#3e6373;}
		table input{ height:25px; border:1px #ff6900 solid; background:#FFF; font-size:20px; border-radius:4px;}
		p{ font-size:36px;}
		body{ font-size:18px;}
		#xuanze{ color:#000; font-size:18px;}
		#xuanze input{ display:inline-block; width:15px; height:15px;}
	</style>
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/user_add.js"></script>
    
  </head>
  
  <body>
	 <%@ include file="/front/frame/header.jsp" %>
	 <div id="main" style="background-color:#efeff5; height:680px; padding-top:80px;">
 		<div style="width:400px; height:580px; margin:0 auto; background-color:#fbfbfd">
 		<s:form id="stuForm" action="wregisterAction_register.action">
            <center>
                <p style=" display:inline-block;color:#ff6900;">注册</p>
                <table cellspacing="15px">
                    <tr>
                        <td align="right">用户名</td>
                        <td><input type="text" name="username" style=" width:100%"/></td>
                    </tr>
                    <tr>
                        <td align="right">密码</td>
                        <td><input type="password" name="password" style="width:100%"/></td>
                    </tr>
             
                    <tr>
                        <td align="right">确认密码</td>
                        <td><input type="password" name="passwordConfirm" style="width:100%"/></td>
                    </tr>
                    <tr>
                        <td align="right">类型	</td>
                        <td id="xuanze">
                            <label><input type="radio" value="0" name="registerType" checked="checked"/>学生</label>
                            <label><input type="radio" value="1" name="registerType"/>学校</label>
                            <label><input type="radio" value="2" name="registerType"/>职业人</label>
                            <label><input type="radio" value="3" name="registerType"/>企业</label>
                            <label><input type="radio" value="4" name="registerType"/>教师</label>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>验证邮箱</td>
                        <td>
                            <input type="email" name="mail" style=" width:100%" />
                        </td>
                    </tr>
                </table>
                <input type="submit" value="注册" name="regist" style="margin-top:30px; width:200px; height:60px; color:#FFF; background:#ff6900; border:none; border-radius:6px; font-size:34px; letter-spacing:1em; text-align:center; text-indent:1em;" />
        	</center>
        </s:form>
		</div>
	</div>
	<%@ include file="/front/frame/bottom.jsp" %>
<%--
	<s:form id="stuForm" action="wregisterAction_register.action">
		用户名：<s:textfield name="username"></s:textfield><s:label id="usernameTip" /><br />
		邮箱：<s:textfield name="mail" required="true"></s:textfield><br />
		类型：<s:select list="registerType" name="registerType" listKey="id" listValue="content"></s:select><br />
		类型：<select name="registerType">
				<option value="0">在校学生</option>
				<option value="1">在职员工</option>
				<option value="2">各大高校</option>
				<option value="3">社会企业</option>
			</select><br />
		密码：<s:password name="password"></s:password><br />
		确认密码：<s:password name="passwordConfirm"></s:password><br />
		<input type="button" id="registerSubmit" value="注册" />
	</s:form>
--%>
  </body>
</html>

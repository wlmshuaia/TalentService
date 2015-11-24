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
    
    <title>注册验证码</title>
    
    <script type="text/javascript">
    	$(function(){
    		$("#registerVerify").click(function(){
    			var verifyCode = $("input[name=verify]").val() ;
    			if(verifyCode == ""){
    				$.messager.show({
    					title: '提示信息',
    					msg: '请输入验证码'
    				});
    			}else{
    				$.post('register/wregisterJsonAction_verify.action', {verify: verifyCode}, function(result){
        				if(result == "验证码错误") {
        					$.messager.show({
            					title: '提示信息',
            					msg: '验证码输入错误！'
            				});
        				}else{
        					window.location.href = "login/wloginAction_loginUI.action" ;
        				}
        			}) ;
    			}
    		});
    	});
    </script>
    
  </head>
  
  <body>
	验证码已发送到邮箱，请复制并在下面的框中输入， 若未收到邮件，请点击<a href="register/wregisterAction_register.action">重新发送</a><br><br>
	
	<s:form action="register/wregisterAction_verify.action">
		请输入验证码：<s:textfield name="verify"></s:textfield>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="registerVerify" value="提交" />
	</s:form>
	
  </body>
</html>

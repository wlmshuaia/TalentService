<%@page import="com.opensymphony.xwork2.ActionContext"%>
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
    
    <title>学院资料</title>
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
	
	<script type="text/javascript">
		function formSubmit() {
			
			if(confirm("保存修改？")) {
				//$('#myForm').submit() ;
				$('#myForm').form('submit', {    
				    success: function(result){
				    	var data = eval('(' + result + ')');
				    	alert(data.message) ;
				    	window.location.reload();
				    }
				});
				/*$.ajax({
					type: 'post',
					data: $('#myForm').serialize(),
					url: 'user/studentAction_personal.action',
					dataType: 'json',
					success: function(result) {
						alert(result.message) ;
					},
					error: function(result) {
				        alert(result.message) ;
					}
				}) ;*/
	        }
		}
	</script>
	
	<style>
		table tr th input{ height:20px; height: 30px; font-size:20px; font-weight: 0px; border:1px #b2d4dd solid; width:100%; border-radius:3px; }
		a{ text-decoration:none;}
		#liebiao{ width:166px; height: auto; background:#FFF;border-bottom:1px #dde0e1 solid; box-shadow:0px 1px #b7b7ba;}
		#liebiao li{ list-style:none;  width:166px; height:50px; color:#4c6d7b; font-size:18px; text-align:center; line-height:3em;}
		#liebiao li a{  color:#4c6d7b;}
		#liebiao li a:hover{ color:#ff6900; cursor:pointer;}
		.choose {color: #ff6900;}
		
		.userAdd { width: auto; height: auto; overflow: hidden;}
		.userAdd div { margin: 10px 0 0 50px; }
		.userAdd .userField { width: 200px; height: auto;}
		.userAdd .userAddSubmit input { width: auto; height: auto; border: none; border-radius: 4px; background: #3e6372; color: white; text-align: center; padding: 6px 8px; cursor: pointer;}
		
	</style>
    
  </head>
  
  <body>
  	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; margin:0 auto; padding-bottom: 30px; border-top:1px #6b6b6b solid;">
    	<div id="weizhi" style="width: 85%; height:auto; margin:0 auto; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
        	<s:a action="schoolAction_getSchool.action?sid=%{#school.uid}"><s:property value="#school.username" /></s:a>>>
            <a>添加学院</a>
        </div>
    	<div style=" width: 85%; height:auto; overflow: hidden; margin:0 auto; margin-top:5px;">
            <div style="width: 100%; background:#FFF; height:auto; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
	            <div class="userAdd">
	            	<s:form id="myForm" action="user/collegeAction_school.action" method="post">
		            	<s:hidden name="uid" value="%{#school.uid}"></s:hidden>
		            	<div class="userField">
		            		学院名称：<s:textfield name="username"></s:textfield>
		            	</div>
		            	<div class="userField">
		            		登录密码：<s:password name="password"></s:password>
		            	</div>
		            	<div class="userField">
		            		密码确认：<s:password name="passwordConfirm"></s:password>
		            	</div>
		            	<div class="userAddSubmit">
		            		<s:submit value="添加学院"></s:submit>
		            	</div>
	            	</s:form>
	            </div>
            </div>
            
       	</div>
    
    </div>
	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

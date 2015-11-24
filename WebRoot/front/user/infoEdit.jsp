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
    
    <title>学校资料</title>
    
    <!-- Set render engine for 360 browser -->
	<meta name="renderer" content="webkit">
	
	<!-- No Baidu Siteapp-->
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css">
	
	<!-- umeditor css -->
	<link href="<%=request.getContextPath()%>/umeditor/themes/default/css/umeditor.css" rel="stylesheet">
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	
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
				/* $.ajax({
					type: 'post',
					data: $('#myForm').serialize(),
					url: 'user/schoolAction_school.action', 
					dataType: 'json',
					success: function(result) {
						alert(result.message) ;
					},
					error: function(result) {
				        alert(result.message) ;
					}
				}) ; */
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
		
	</style>
    
  </head>
  
  <body>
  	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; margin:0 auto; padding-bottom: 30px; border-top:1px #6b6b6b solid;">
    	<div id="weizhi" style="width: 85%; height:auto; margin:0 auto; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
        	<s:a action="schoolAction_getSchool.action?sid=%{#school.sid}"><s:property value="#user.username" /></s:a>>>
            <a>信息修改</a>
        </div>
    	<div style=" width: 85%; height:auto; overflow: hidden; margin:0 auto; margin-top:5px;">
            <div style="width: 15%; float:left; height: auto;float:left">
                <div id="liebiao">
                    <li><a href="user/schoolAction_getSchool.action">学校资料</a></li>
                    <li><s:a style="color:#ff6900;" action="schoolAction_infoEditUI.action?sid=%{#school.sid}">信息修改</s:a></li>
                </div>
             </div>
            
            <div style="width: 83%; background:#FFF; height:auto; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
	            <s:form id="myForm" action="schoolAction_school.action" method="post" enctype="multipart/form-data">
	            	<s:hidden name="sid" value="%{#school.sid}"></s:hidden>
	            	<div style="width:100%; height:200px; padding-left: 25px; border-bottom:2px #e7f1f3  solid; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">
	                	<div style="width:128px; height:128px; float:left; border:1px #000000 solid; font-size: 12px; border-radius: 100px; margin-top:15px;">
	                		<s:if test="#school.gravatar != NULL">
	                			<img alt="显示图片" style="width: 100%; height: 100%; border-radius: 100px; " src="<s:url action='user/schoolAction_getPic.action'></s:url>">
	                		</s:if>
	                		<s:else>
	                			<img alt="" src="<%=request.getContextPath()%>/images/touxiang_auto.png" style="width: 100%; height: 100%;">
	                		</s:else>
	                		<s:file name="upload" placeholder="上传头像"></s:file>
	                		<s:hidden name="gravatar" value="%{#school.gravatar}"></s:hidden>
	                	</div>
	                    <div style="height:128px; margin-top:15px; float:left; margin-left:10px;">
	                    	<div style="height:30px; font-size:16px; color:#3e6270; margin-top:0px; line-height:1em;">
	                    		学校名称：<s:textfield name="username" value="%{#user.username}"></s:textfield>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="oneContent">
	                	<div class="schoolIntro">
		                	<div class="issueHead">学校简介</div>
		                </div>
		                <div class="schoolContent">
		                	<div class="am-g am-g-fixed">
								<div class="am-u-sm-12">
									<div class="am-form-group">
										<!-- <script type="text/plain" id="myEditor" style="width: 100%;height: 28rem;"></script> -->
										<s:textarea id="myEditor" style="width: 100%;height: 28rem;" name="introduction" value="%{#school.introduction}">
										</s:textarea>
									</div>
								</div>
							</div>
		                	<input type="button" onclick="formSubmit();" id="infoSubmit" class="infoSubmit" value="保存修改" />
		                </div>
	                </div>
	                
            	</s:form>
            </div>
            
       	</div>
    
    </div>
	<!-- message input end -->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<!--<![endif]-->
	<!--[if lte IE 8 ]>
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<![endif]-->
	
	<!-- umeditor js -->
	<script charset="utf-8" src="<%=request.getContextPath()%>/umeditor/umeditor.config.js"></script>
	<script charset="utf-8" src="<%=request.getContextPath()%>/umeditor/umeditor.min.js"></script>
	<script src="<%=request.getContextPath()%>/umeditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
		$(function() {
			// 初始化消息输入框
			var um = UM.getEditor('myEditor');
			k() ;
		});
	</script>
	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

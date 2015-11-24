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
    
    <title>项目详情</title>
	
	<script type="text/javascript">
		$(function(){
			
			$('#bidChoose').click(function(){
				alert('d');
				alert("<s:property value='%{#data.pid}'/>") ;
				
				$.ajax({
					type: 'post',
					//url: 'project/wbidAction_bidChoose.action?pid='<s:property value="%{#data.pid}"/>'&taskId='<s:property value="%{#task.id}"/>'&uid='<s:property value="%{#user.uid}"/>'',
					datatype: 'json',
					success: function(result){
						var data = eval('(' + result + ')');  // change the JSON string to javascript object    
				        alert(data.message) ;
					},
					error: function(result){
						var data = eval('(' + result + ')');  // change the JSON string to javascript object    
				        alert(data.message) ;
					}
				});
				
			});
			
		});
	</script>
	
	<style type="text/css">
		#yigejihua { width: 750px; height: 150px; margin:0 auto; line-height: 30px; }
		
		.yige{ width:710px; margin:10px auto; border: #b2d4dd 1px solid; border-radius: 8px;}
		#yigejingbiaofangan div{ float:left; }
		#yigejingbiaofangan div li{ font-size:14px; list-style:none;}
		#yigejingbiaofangan div li span{ margin-left:60px;}
		#xuantachengjie{ cursor:pointer; margin-top:30px; color:#ff6900; border:2px #ff6900 solid; font-size:16px; text-align:center; line-height:27px; border-radius:4px;}
		#xuantachengjie a { color: #ff6900;}
		#xuantachengjie a:hover { color: #fff;}
		#xuantachengjie:hover{ color:#fff; background:#ff6900;}
    	
    	.projectList {color: #9a9a9a;}
    	.projectList a{ color: #0d97da;}
    	.project { margin-top: 20px;}
	</style>
	
  </head>
  
  <body>
 	<%@ include file="/front/frame/header.jsp" %>
  	<%-- <s:property value="#data.title" /><br />
  	项目最新日志： <s:property value="#projectlogLatest.handletime" />&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="#projectlogLatest.handle" /><br />
  	状态： <s:property value="#data.status" /><br /> --%>
  	
  	<div style=" margin:0 auto;">
  		<div style="width:750px; height:60px; border-bottom:3px #e7f1f3 dotted; margin:0 auto; font-size:22px; line-height:2em; color: #3e6373">
	  		<s:property value="#data.title" />
	  	</div>
	    <div id="yigejihua">
	      	<div>项目最新日志：<span> <s:property value="#projectlogLatest.handletime" />&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="#projectlogLatest.handle" /></span></div>
	        <div>状态： <s:property value="#data.status" /></span></div>
      	</div>
  	</div>
  	
  <%-- 	<div style="width:750px; height:60px; border-bottom:3px #e7f1f3 dotted; margin:0 auto; font-size:22px; line-height:2em; color:#3e6373">
  		<s:property value="#data.title" />
  	</div>
  	<div id="yigejihua">
		  	<div>计划金额:<span><s:property value="#data.planmoney" /></span></div>
		    <div>交付日期:<span><s:property value="#data.completedate" /></span></div>
		    <div>验收协议:<span><s:property value="#data.standard" /></span></div>
		    <div>制定时间:<span><s:property value="#data.uploadtime" /></span></div>
		</div> --%>
  	
  	<s:iterator value="bidList">
  		<div class="yige" style="padding: 10px;">
	        <div style="height:50px; font-size:18px;">竞标方案:</div>
	        	<div style="height:150px;" id="yigejingbiaofangan">
	             <div style="min-width: 100px; min-height: 120px; ">
	             	<div style="float: left;width: 80px; height: 80px; background:url(<%=request.getContextPath()%>/images/touxiang.gif); background-size:100% 100%;"></div>
	            	 	<div style="clear: both;"></div>
	            	 	<span style="display: block; float: left; padding-left: 4px;">
	            	 		<s:property value="user.username" />
	            	 	</span>
	             </div>
	             <div style="width:440px; height:130px; margin-left:30px; line-height: 25px;">
	                 <li>金额:<span><s:property value="bidmoney" /></span></li>
	                 <li>周期:<span><s:property value="bidcycle" /></span></li>
	                 <li>发布时间:<span style="margin-left:28px;"><s:property value="bidtime" /></span></li>
	                 <li>计划:<span><s:property value="plan" /></span></li>
	             </div>
	             <div id="xuantachengjie" style=" width:87px; height:30px;">
	             	<s:a action="project/wbidAction_bidChoose.action?pid=%{project.pid}&taskId=%{#task.id}&uid=%{user.uid}">选他承接</s:a>
	             </div>
	         </div>
		</div> 
  		<%-- <ul>
  			<li>竞标人：<s:property value="user.username" /></li>
  			<li>金额：<s:property value="bidmoney" /></li>
  			<li>周期：<s:property value="bidcycle" /></li>
  			<li>发布时间：<s:property value="bidtime" /></li>
  			<li>计划：<s:property value="plan" /></li>
  			<li><s:a action="project/wbidAction_bidChoose.action?pid=%{project.pid}&taskId=%{#task.id}&uid=%{user.uid}">选他承接</s:a></li>
  		</ul> --%>
  	</s:iterator>
  	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

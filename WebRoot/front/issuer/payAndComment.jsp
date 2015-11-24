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
    
    <title>付款评论</title>
	
	<script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
	
	<style type="text/css">
		ul {list-style-type: none;}
		ul li {float: left; margin-left: 15px;}
		
		a{ text-decoration:none;}
		#tijiao{width:120px; height:30px; border:2px #ff6900 solid; border-radius:4px; color:#ff6900; background: white; font-size:20px; margin-top:10px; cursor:pointer; text-align:center; }
		#tijiao:hover{ color:#fff; background:#ff6900;}
	</style>

  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	
	<div id="main" style="background-color:#efeff5; padding-bottom:20px; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:30px; margin:0 auto; font-size:20px; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a>付款评价</a>
        </div>
        <s:form action="project/wplanAction_payAndComment.action">
	        <s:hidden name="pid" value="%{#pid}"></s:hidden>
			<s:hidden name="taskId" value="%{#taskId}"></s:hidden>
			<s:hidden name="type" value="%{#type}"></s:hidden>
	        <div style=" width:960px; margin:0 auto; margin-top:10px; padding-top:20px; padding-bottom:20px; background:#FFF; border-radius:5px 0 0 5px; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-left:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;">
	            <div style=" width:770px; margin:0 auto;">
	               <div style=" font-size:20px;">支付款项：</div>
	               <div style="font-size:16px; color:#ff6900; margin-top:20px;">金额：<input type="text" />元</div>
	               <div style="font-size:16px; color:#ff6900;">密码：<input type="password" /></div>
	               <div style=" font-size:20px; margin-top:30px;">简短评价：</div>
	               <div style="margin-top:15px;">
	               		<s:textarea name="content" style=" width:500px; height:200px; font-size:20px;" ></s:textarea>
	               </div>
	               <s:submit  id="tijiao" label="提交"></s:submit>
	            </div>
	        </div>
        </s:form>
    </div>
	
	<%-- 付款评价。
	<s:form action="project/wplanAction_payAndComment.action">
		<s:hidden name="pid" value="%{#pid}"></s:hidden>
		<s:hidden name="taskId" value="%{#taskId}"></s:hidden>
		<s:hidden name="type" value="%{#type}"></s:hidden>
		评价内容：<s:textarea name="content" rows="10" cols="100"></s:textarea><br/>
		<s:submit label="确认评价"></s:submit>
	</s:form> --%>
	
 	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

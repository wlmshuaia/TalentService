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
    
    <title>计划详情</title>
	
	<script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
	
	<style type="text/css">
		a{ text-decoration:none; color:#ff6900; }
		a:hover { color:#fff; }
		#yigejihua{ color:#889ca5; width:750px; height:200px; margin:0 auto; margin-top:20px;}
		#yigejihua div{ margin-top:5px; font-size:16px;}
		#yigejihua div span{ margin-left:20px;}
		#yigejihua div input[type=submit] {background: white; width:160px; height:35px; color:#ff6900;  border-radius:4px; float:left; text-align:center; line-height:33px;  border:2px #ff6900 solid; cursor:pointer; margin-left:10px;}
		#yigejihua div div:hover{ color:#fff; background:#ff6900;}
	</style>

  </head>
  
  <body>
  	<%@ include file="/front/frame/header.jsp" %>
  	<div id="main" style="background-color:#efeff5; height:680px; margin:0 auto; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:25px; margin:0 auto; border-radius:5px; margin-top:5px;">
        	<span style=" margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a>计划管理</a>
        </div>
    	<div style=" width:960px; height:560px; margin:0 auto; margin-top:5px;">
            <%@ include file="/front/frame/left.jsp" %>
            <div style="width:790px; background:#FFF; padding-bottom:20px; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
            	<div style="width:750px; height:60px; border-bottom:3px #e7f1f3 dotted; margin:0 auto; font-size:22px; line-height:2em; color:#3e6373">计划管理</div>
                <div id="yigejihua">
                	<div>计划金额:<span><s:property value="#data.planmoney" /></span></div>
                    <div>交付日期:<span><s:property value="#data.completedate" /></span></div>
                    <div>验收协议:<span><s:property value="#data.standard" /></span></div>
                    <div>制定时间:<span><s:property value="#data.uploadtime" /></span></div>
                	<div style="margin-top: 20px;">
                		<s:if test="#type == 'confirmPlan'">
                			<div style="margin-left:0px;"><s:a action="wplanAction_confirmPlan.action?pid=%{#data.project.pid}&taskId=%{taskId}">确认计划</s:a></div>
	                        <div><s:a action="">返回修改</s:a></div>
                		</s:if>
                		
                		<s:elseif test="#type == 'completePlan'">
                			<s:form action="wplanAction_completePlan.action" enctype="multipart/form-data">
                				<s:hidden name="pid" value="%{#data.project.pid}"></s:hidden>
                				<s:hidden name="taskId" value="%{taskId}"></s:hidden>
                				<span style="display: block; padding: 0; margin: 0 0 15px 0;">
                					上传附件：<s:file name="file"></s:file>
                				</span>
                				<div style="margin-left: 0px; clear: both;">
                					<s:submit  style="margin-left: 0px; clear: both;" value="完成计划"></s:submit>
                				</div>
                			</s:form>
                		</s:elseif>
                		
                		<s:elseif test="#type == 'confirmProduct'">
                			<div style="margin-left:0px;"><s:a action="wplanAction_confirmProduct.action?pid=%{#data.project.pid}&taskId=%{taskId}">确认产品</s:a></div>
                		</s:elseif>
                		
                		<s:elseif test="#type == 'planOver'">
                			<div style="margin-left:0px;"><s:a action="wplanAction_planOver.action?pid=%{#data.project.pid}&taskId=%{taskId}&executionId=%{executionId}">项目完工</s:a></div>
	                        <div><s:a action="wplanAction_makePlanUI.action?pid=%{#data.project.pid}&taskId=%{taskId}&executionId=%{executionId}&newPlan=1">添加新计划</s:a></div>
                		</s:elseif>
                    	
                    </div>
                </div>
            </div>
            <%-- <div style="width:790px; background:#FFF; height:559px; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
            	<div style="width:750px; height:60px; border-bottom:2px #e7f1f3 dotted; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">计划管理</div>
                <div>
                	<ul>
                		<li>金额：<s:property value="#data.planmoney" /></li>
                		<li>完成周期：<s:property value="#data.completedate" /></li>
                		<li>验收标准：<s:property value="#data.standard" /></li>
                		<li>制定时间：<s:property value="#data.uploadtime" /></li>
                		<s:if test="#type == 'confirmPlan'">
                			<li>操作：<s:a action="wplanAction_confirmPlan.action?pid=%{#data.project.pid}&taskId=%{taskId}">确认计划</s:a>|<s:a action="">返回修改</s:a></li>
                		</s:if>
                		<s:elseif test="#type == 'completePlan'">
                			<li>操作：<s:a action="wplanAction_completePlan.action?pid=%{#data.project.pid}&taskId=%{taskId}">完成计划</s:a></li>
                		</s:elseif>
                		<s:elseif test="#type == 'confirmProduct'">
                			<li>操作：<s:a action="wplanAction_confirmProduct.action?pid=%{#data.project.pid}&taskId=%{taskId}">确认产品</s:a></li>
                		</s:elseif>
                		<s:elseif test="#type == 'planOver'">
                			<li>操作：
                				<s:a action="wplanAction_planOver.action?pid=%{#data.project.pid}&taskId=%{taskId}&executionId=%{executionId}">项目完工</s:a>
                				|
                				<s:a action="wplanAction_makePlanUI.action?pid=%{#data.project.pid}&taskId=%{taskId}&executionId=%{executionId}&newPlan=1">添加新计划</s:a>
                			</li>
                		</s:elseif>
                	</ul>
                </div>
            </div> --%>
       	</div>
    </div>
  	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

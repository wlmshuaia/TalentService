<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.lang.Integer, com.talentservice.utils.DataUtils"%>
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
    
    <title>计划管理</title>
    
    <style type="text/css">
    	.projectType {}
    	.projectType ul {}
    	.projectType ul li { float: left; margin-left: 5px; border: gray 1px solid; padding: 3px; background: white;}
    	.projectType ul li a {text-decoration: none; color: #5c9ec3;}
    	.projectType ul li a span {color: #b34300;}
    </style>
    
  </head>
  
  <body>
	项目管理。<br />
	
	<div class="projectType">
		<ul>
			<li><a href="project/wprojectAction_dataList.action?status=bidding">待审核<span>(<s:property value="#dataList.{?#this.project.status=='待审核'}.size()" />)</span></a></li>
			<li><a href="">竞标中<span>(<s:property value="#dataList.{?#this.project.status=='竞标中'}.size()" />)</span></a></li>
			<li><a href="">进行中<span>(<s:property value="#dataList.{?#this.project.status=='进行中'}.size()" />)</span></a></li>
			<li><a href="">已完成<span>(<s:property value="#dataList.{?#this.project.status=='已完成'}.size()" />)</span></a></li>
			<li><a href="">全部项目<span>(<s:property value="#dataList.size()" />)</span></a></li>
		</ul>
	</div>
	
	<br />
	
	<s:iterator value="dataList">
		<ul>
			<li>标题：<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}"><s:property value="project.title" /></s:a></li>
			<li>
				<s:if test="project.status == '竞标中'">
					<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}">邀请竞标</s:a>
				</s:if>
				<s:elseif test="project.status == '进行中'">
					<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}">制定计划</s:a>
				</s:elseif>
				
			</li>
			<li>所属分类：<s:property value="project.category.catename" /></li>
			<li>状态：<s:property value="project.status" /></li>
			<li>时间：<s:property value="project.foundtime" /></li>
		</ul>
	</s:iterator>
	
	<div class="page">
		<%--<%
			int start = Integer.parseInt(ActionContext.getContext().get("start").toString()) ;
			int end = Integer.parseInt(ActionContext.getContext().get("end").toString()) ;
			int pageNum = Integer.parseInt(ActionContext.getContext().get("page").toString()) ;
			
			if(pageNum > 1){
				out.print("<span><a href='project/wprojectAction_personalProjectList?start="+(pageNum-1)+"'>上一页</a></span>") ;
			}
		%>
		<ul>
			<%
				for(int i = start; i <=
				end; i ++){
					if(i == pageNum){
						out.print("<li class='choose'><b>"+i+"</b></li>") ;
					}else{
						out.print("<li><a href='project/wprojectAction_personalProjectList?start="+i+"'>"+i+"</a></li>") ;
					}
				}
				
			%>
		</ul>
		<%
			if(pageNum < end){
				out.print("<span><a href='project/wprojectAction_personalProjectList?start="+(pageNum+1)+"'>下一页</a></span>") ;
			}
		%>
	--%></div>
	
  </body>
</html>

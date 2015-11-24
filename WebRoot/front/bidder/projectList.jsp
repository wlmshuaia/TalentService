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
    
    <title>项目列表</title>
    
   	<script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/js/xiangmuguanliliebiao.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all11.js"></script>
    
    <style type="text/css">
    	.projectType {}
    	.projectType ul {}
    	.projectType ul li { float: left; margin-left: 5px; border: gray 1px solid; padding: 3px; background: white;}
    	.projectType ul li a {text-decoration: none; color: #5c9ec3;}
    	.projectType ul li a span {color: #b34300;}
    	
    	
    	#xiangmuguanliliebiao{border-bottom:3px #e7f1f3 solid; width:750px; margin:0 auto; height:30px; margin-top:10px;}
		#xiangmuguanliliebiao li{ width:120px; height:30px; color:#66818c; list-style:none; float:left; margin-left:20px; text-align:center;}
		
		#chakanxianyoujingbiaofangan{width:160px; height:33px; float:left; background:#bddae1; margin-top:40px; text-align:center; border-radius:4px; line-height:30px; letter-spacing:2px; cursor:pointer; }
		#chakanxianyoujingbiaofangan a{ color: #3e6372;}
		#chakanxianyoujingbiaofangan a:hover { color: white;}
		#chakanxianyoujingbiaofangan:hover{ color:#fff; background:#ff6900; }
		
		.chakanxianyoujingbiaofangan{ color: #3e6372;  width:160px; height:33px; float:left; background:#bddae1; margin-top:40px; text-align:center; border-radius:4px; line-height:30px; letter-spacing:2px; cursor:pointer; }
		.chakanxianyoujingbiaofangan a{ color: #3e6372;}
		.chakanxianyoujingbiaofangan a:hover { color: white;}
		.chakanxianyoujingbiaofangan:hover{ color:#fff; background:#ff6900; }
		
		.yige{ width:710px; margin:0 auto; border: #b2d4dd 1px solid; border-radius: 8px;}
		#yigejingbiaofangan div{ float:left; }
		#yigejingbiaofangan div li{ font-size:14px; list-style:none;}
		#yigejingbiaofangan div li span{ margin-left:60px;}
		#xuantachengjie{ cursor:pointer; margin-top:30px; color:#ff6900; border:2px #ff6900 solid; font-size:16px; text-align:center; line-height:27px; border-radius:4px;}
		#xuantachengjie:hover{ color:#fff; background:#ff6900;}
    	
    	.projectList {color: #9a9a9a;}
    	.projectList a{ color: #0d97da;}
    	.project { margin-top: 20px;}
    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	
	 <div id="main" style="background-color:#efeff5; min-height: 680px; margin:0 auto; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:30px; margin:0 auto; border:2px dashed #999; border-radius:5px; margin-top:5px;">
        	<span style="font-size:20px; margin-left:5px; font-size:20px;">当前位置</span>
        	>><a>首页</a>>>
            <a>我的承接</a>
            
        </div>
    	<div style=" width:960px; min-height: 560px; margin:0 auto; margin-top:5px;">
            <%@ include file="/front/frame/left.jsp" %>
            <%-- <div style="width:790px; background:#FFF; min-height:559px; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
            	
            	<div style="width:750px; height:60px; border-bottom:2px #e7f1f3 dotted; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">项目管理</div>
                <div>
                <s:iterator value="dataList">
					<s:if test="project.status != '竞标中' & project.status != '进行中'">
						<s:if test="project.status == '确认计划'">
							<ul>
								<li>标题：<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}"><s:property value="project.title" /></s:a></li>
								<li><s:a action="wplanAction_confirmPlanUI.action?pid=%{project.pid}&taskId=%{task.id}">确认计划</s:a></li>
								<li>所属分类：<s:property value="project.category.catename" /></li>
								<li>状态：<s:property value="project.status" /></li>
								<li>时间：<s:property value="project.foundtime" /></li>
							</ul>
						</s:if>
						<s:elseif test="project.status == '完成计划'">
							<ul>
								<li>标题：<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}"><s:property value="project.title" /></s:a></li>
								<li><s:a action="wplanAction_completePlanUI.action?pid=%{project.pid}&taskId=%{task.id}">完成计划</s:a></li>
								<li>所属分类：<s:property value="project.category.catename" /></li>
								<li>状态：<s:property value="project.status" /></li>
								<li>时间：<s:property value="project.foundtime" /></li>
							</ul>
						</s:elseif>
						<s:elseif test="project.status == '完成作品'">
							<ul>
								<li>标题：<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}"><s:property value="project.title" /></s:a></li>
								<li><s:a action="wplanAction_completeProductUI.action?pid=%{project.pid}&taskId=%{task.id}">完成作品</s:a></li>
								<li>所属分类：<s:property value="project.category.catename" /></li>
								<li>状态：<s:property value="project.status" /></li>
								<li>时间：<s:property value="project.foundtime" /></li>
							</ul>
						</s:elseif>
						<s:elseif test="project.status == '双方互评'">
							<ul>
								<li>标题：<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}"><s:property value="project.title" /></s:a></li>
								<li><s:a action="wplanAction_commentUI.action?pid=%{project.pid}&taskId=%{task.id}&executionId=%{task.executionId}&type=bidder">对发布方评价</s:a></li>
								<li>所属分类：<s:property value="project.category.catename" /></li>
								<li>状态：<s:property value="project.status" /></li>
								<li>时间：<s:property value="project.foundtime" /></li>
							</ul>
						</s:elseif>
						<s:elseif test="project.status == '发包方完成了评价'">
							<ul>
								<li>标题：<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}"><s:property value="project.title" /></s:a></li>
								<li><s:a action="wplanAction_commentUI.action?pid=%{project.pid}&taskId=%{task.id}&executionId=%{task.executionId}&type=bidder">等待接包方评价</s:a></li>
								<li>所属分类：<s:property value="project.category.catename" /></li>
								<li>状态：<s:property value="project.status" /></li>
								<li>时间：<s:property value="project.foundtime" /></li>
							</ul>
						</s:elseif>
						<s:elseif test="project.status == 'project.status == '已完成'">
							<ul>
								<li>标题：<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}"><s:property value="project.title" /></s:a></li>
								<li><s:a action="wplanAction_commentUI.action?pid=%{project.pid}&taskId=%{task.id}&executionId=%{task.executionId}&type=bidder">项目结束</s:a></li>
								<li>所属分类：<s:property value="project.category.catename" /></li>
								<li>状态：<s:property value="project.status" /></li>
								<li>时间：<s:property value="project.foundtime" /></li>
							</ul>
						</s:elseif>
					</s:if>
				</s:iterator>
				
                </div>
            
            </div> --%>
            
            
            <div style="width:790px; background:#FFF; padding-bottom:20px; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
            	
            	<div style="width:750px; height:60px; margin:0 auto; font-size:22px; line-height:2em; color:#3e6373">
                	项目管理
                	<s:a style=" display:inline-block;width:150px; height:30px; background:#ff6900; color:#fff; font-size:18px; margin-left:50px; text-align:center; line-height:30px; margin-top:10px; cursor:pointer; border-radius:4px;" action="project/wprojectAction_addUI.action">免费发布项目</s:a>
                </div>
                
                <div id="xiangmuguanliliebiao">
                	<li>待审核(2)</li>
                    <li>竞标中(3)</li>
                    <li>进行中(4)</li>
                    <li>已完成(7)</li>
                    <li>全部项目(16)</li>
                </div>
                
                <div style=" width:750px; margin:0 auto; margin-top:20px; padding-bottom:20px;">
                	<div style=" width:100%;" class="projectList">

						<s:if test="#dataList.size() != 0">
						<s:iterator value="dataList">
							<s:if test="project.status != '竞标中' & project.status != '进行中' & project.status != '计划已完成'">
								<div style="width:100%; overflow:hidden;" class="project">
									<div style="width:550px; height:100px; margin-left:20px; float:left;">
		                                <div style="height:37px; font-size: 18px; color:#7dc1e4;">
		                                	<s:a action="wprojectAction_personalProjectInfo.action?pid=%{project.pid}&taskId=%{task.id}">
		                                		<s:property value="project.title" />
		                                	</s:a>
		                                </div>
		                                <div style="height:28px; width:100%;">
								                                    发布日期：<span style=" display:inline-block;width:100px;"><s:property value="project.foundtime" /></span>
								                                    状态：<span style=" display:inline-block;width:130px;"><s:property value="project.status" /> </span>
								                                   进度：<span style=" display:inline-block;width:130px;"><s:property value="project.status" /> </span>
		                                </div>
		                                <div style="height:25px;">
		                                	剩余：<span style=" display:inline-block;width:130px;">7天5小时23分</span>
		                                	分类：<span style=" display:inline-block;width:130px;"><s:property value="project.category.catename" /></span>
		                                </div>
		                           </div>
		                            <s:if test="project.status == '确认计划'">
			                            <div id="chakanxianyoujingbiaofangan"><s:a action="wplanAction_confirmPlanUI.action?pid=%{project.pid}&taskId=%{task.id}">确认计划</s:a></div>
		                            </s:if>
									
	                            	<s:elseif test="project.status == '完成计划'">
										<div id="chakanxianyoujingbiaofangan"><s:a action="wplanAction_completePlanUI.action?pid=%{project.pid}&taskId=%{task.id}">完成计划</s:a></div>
									</s:elseif>
									
									<s:elseif test="project.status == '完成作品'">
										<div id="chakanxianyoujingbiaofangan"><s:a action="wplanAction_completeProductUI.action?pid=%{project.pid}&taskId=%{task.id}">完成作品</s:a></div>
									</s:elseif>
									
									<s:elseif test="project.status == '确认作品'">
			                            <div id="chakanxianyoujingbiaofangan"><s:a action="wplanAction_confirmProductUI.action?pid=%{project.pid}&taskId=%{task.id}">确认作品</s:a></div>
									</s:elseif>
									
									<s:elseif test="project.status == '双方互评'">
										<div id="chakanxianyoujingbiaofangan"><s:a action="wplanAction_commentUI.action?pid=%{project.pid}&taskId=%{task.id}&executionId=%{task.executionId}&type=bidder">对发布方评价</s:a></div>
									</s:elseif>
									
									<s:elseif test="project.status == '发包方完成了评价'">
										<div id="chakanxianyoujingbiaofangan"><s:a action="wplanAction_commentUI.action?pid=%{project.pid}&taskId=%{task.id}&executionId=%{task.executionId}&type=bidder">等待接包方评价</s:a></div>
									</s:elseif>
									
									<s:elseif test="project.status == '已完成'">
										<div id="chakanxianyoujingbiaofangan"><s:a action="wplanAction_commentUI.action?pid=%{project.pid}&taskId=%{task.id}&executionId=%{task.executionId}&type=bidder">项目结束</s:a></div>
									</s:elseif>
									
								</div>
							</s:if>
								
						</s:iterator>
						
					</s:if>
                    </div>
								
              </div>
            
       	</div>
    
    </div>
	<%@ include file="/front/frame/bottom.jsp" %>
	
  </body>
</html>

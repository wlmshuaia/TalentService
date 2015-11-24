<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.lang.Integer"%>
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
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
	
    <style type="text/css">
		#xuesheng{width:100%; padding-bottom:20px; margin-top:30px;}
		#xuesheng1{ width:100%; height:150px;  margin-top:10px;}
		#xuesheng1 div{ float:left;}
		#xuesheng1_1{  float:left; width:40px; height:40px;background:url(../images/yanshi.gif); background-size: cover; border-radius:40px; margin-left:50px;}
		#xuesheng1_2{ margin-left:20px;}
		#xuesheng1_3 li{ list-style:none; font-size:18px; margin-left:100px; margin-top:5px;}
		
		#xuesheng2{ width:100%; padding-bottom:20px;}
		#xuesheng2_1{ width:780px; margin:0 auto; font-size:18px;}
		#xuesheng2_2{ width:740px; margin:0 auto; font-size:16px; margin-top:10px;}
		#xuesheng2_2 li{ list-style:none; margin-top:10px; overflow:hidden;}
		#xuesheng2_2 li div{ float:left; font-size:16px;}
		#mingcheng{ width:200px; margin-left:30px;}
		#jindu{ width:100px; margin-left:50px;}
		#jindutiao{ width:100px;  height:3px; margin-top:7px; margin-left:100px; background:#ccc;}
		#jindutiao div{ background:#3e6371; height:100%;}
		#jindut{ width:100px;  margin-top:7px; margin-left:100px;}
    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; padding-bottom:20px; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:30px; margin:0 auto; font-size:20px; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a>学生项目列表</a>
            
        </div> 		
        
        <div style=" width:960px; padding-bottom:20px; margin:0 auto; margin-top:10px; background:#FFF; border-top:3px #ff6900 solid; border-radius:5px 5px 0 0 ; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;">
            <div style=" width:870px; margin:0 auto;margin-top:30px;">

                <div id="xuesheng">
					<div id="xuesheng1">
                    	<div id="xuesheng1_1"></div>
                        <div id="xuesheng1_2">TNT</div>
                        <div id="xuesheng1_3">
                        	<li>姓名：<span><s:property value="#data.name" /></span></li>
                            <li>性别：<span><s:property value="#data.sex" /></span></li>
                            <li>专业：<span><s:property value="#data.professional" /></span></li>
                        </div>
                    </div>
                    
                    <div id="xuesheng2">
                    	<div id="xuesheng2_1">承接项目:</div>
                        <div id="xuesheng2_2">
                        	<li>
                            	<div id="mingcheng">项目名称</div>
                                <div id="jindu">项目状态</div>
                                <div id="jindut">
                                	进度
                                </div>
                            </li>
                        	<s:iterator value="dataList">
                        		<li>
	                            	<div id="mingcheng"><s:a href="project/wplanAction_getPlans.action?pid=%{pid}"><s:property value="title" /></s:a></div>
	                                <div id="jindu"><s:property value="status" /></div>
	                                
	                                <s:if test="status == '竞标中'">
	                                	 <div id="jindutiao" style="">
		                                	<div style="width:10%;"></div>
		                                </div>
	                                </s:if>
	                                
	                                <s:elseif test="status == '进行中'">
	                                	 <div id="jindutiao">
		                                	<div style="width:20%;"></div>
		                                </div>
	                                </s:elseif>
	                                
	                                <s:elseif test="status == '双方互评'">
	                                	 <div id="jindutiao">
		                                	<div style="width:80%;"></div>
		                                </div>
	                                </s:elseif>
	                                
	                                <s:elseif test="status == '发包方完成了评价' || status == '承接方完成了评价'">
	                                	 <div id="jindutiao">
		                                	<div style="width:90%;"></div>
		                                </div>
	                                </s:elseif>
	                                
	                                <s:elseif test="status == '已完成'">
	                                	 <div id="jindutiao">
		                                	<div style="width:100%;"></div>
		                                </div>
	                                </s:elseif>
	                                
	                                <s:elseif test="status == '制定计划'">
	                                	 <div id="jindutiao">
		                                	<div style="width:20%;"></div>
		                                </div>
	                                </s:elseif>
	                               
	                               <s:elseif test="status == '确认计划'">
	                                	 <div id="jindutiao">
		                                	<div style="width:35%;"></div>
		                                </div>
	                                </s:elseif>
	                                
	                                <s:elseif test="status == '完成计划'">
	                                	 <div id="jindutiao">
		                                	<div style="width:35%;"></div>
		                                </div>
	                                </s:elseif>
	                                
	                                <s:elseif test="status == '确认作品'">
	                                	 <div id="jindutiao">
		                                	<div style="width:65%;"></div>
		                                </div>
	                                </s:elseif>
	                                
	                                <s:elseif test="status == '双方互评'">
	                                	 <div id="jindutiao">
		                                	<div style="width:80%;"></div>
		                                </div>
	                                </s:elseif>
	                                
	                            </li>
                        	</s:iterator>
                        </div>
                    
                    </div>
                    
                </div>
            
            </div>
        </div>
    </div>
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

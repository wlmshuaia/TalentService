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
    
    <title>计划列表</title>
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
    <style type="text/css">
    	table input{ border:#b2d4dd thin solid; border-radius:4px; font-family:"微软雅黑";}
		#d1{ color:#3d6473}
		#d1 div{ float:left; margin-left:20px; }
		#d1 div span{ margin-left:5px;}
		#d1 div input{ margin-left:10px;  width:30px; height:18px; color:#b2d4dd; border-radius:4px;}
		#d2 div{ margin-top:5px; width:100%; height:30px; display:none;}
		#d2{ color:#3d6473}
		#d2 div span{ display:inline-block; font-size:16px; width:40px; text-align:left;; float:left;}
		#d2 div input{ margin-left:20px; width:50%; height:20px; float:left; border:#b2d4dd thin solid; border-radius:4px;}
		#d3{ color:#3d6473}
		#d3 div{ width:100%; margin-top:10px; height:30px;}
		#d3 div span{ display:inline-block; width:100px; float:left; text-align:left;}
		#d3 div select{ font-weight:bold; width:40px; margin-left:50px; float:left; border:#b2d4dd thin solid; border-radius:4px;}
		#d3 div option{}
		
		#zuoshang{ height:70px; width:844px; border-bottom:2px #e5e5e5 solid; margin:0 auto;}
		#zuoshang div{ float:left; margin-top:20px;}
		#zuoshang div li{ float:left; list-style:none; width:65px; margin-left:23px; height:30px; color:#3e6373; font-size:21px;    }
		#zuoxia{ width:826px; margin:0 auto; }
		
		#zuoxia div{ width:800px; margin:0 auto;}
		#xinxi{ margin-top:10px; height:150px;}
		#xinxi li{ width:360px; height:30px; float:left; list-style:none;border-bottom:1px #CCC dashed; margin-left:20px; margin-top:18px;}
		#xinxi li div{ float:left; width:325px; line-height:2em; text-indent:1em;}
		
		#youxia{ width:240px; margin-top:7px;}
		#youxia div{ width:240px; height:265px; background:#FFF; margin-top:13px; border-radius:4px 4px 0 0; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;}
		#youxia div div{ width:220px; margin:0 auto; height:42px; border-bottom:2px #e5e5e5 solid; border-top:none; color:#3e6372; box-shadow:none; border-right:none; font-size:22px; text-indent:4px; line-height:2em;}
		
		.planList {  }
		.planList .plan-info { border: #3e6372 1px solid;border-radius: 8px; float: left; margin-top: 10px;}
		.planList .plan-info .files { float: left; width: 200px; height: 30px; padding: 4px 0 10px 15 ; }
		.planList ul { display: block; float: left;  padding: 4px 0 10px 15px; margin-left: 20px;}
		.planList ul li { list-style-type: none; margin-top: 10px;}
		
    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	
	<div id="main" style="background-color:#efeff5; padding-bottom: 30px; width:100%; margin:0 auto; margin-bottom: 50px;border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:1120px; height:30px; margin:0 auto;font-size:18px; border-radius:5px; margin-top:5px;">
        	<span style=" margin-left:5px;">当前位置</span>
        	>>首页>>
            <a>项目详情</a>
        </div>
        <div style="width:1120px; margin:0 auto; margin-top:10px; overflow: hidden;">
        	<div style="width:870px; float:left; margin-left:0px; border-right:1px #9b9b9b solid; border-bottom:1px #9b9b9b solid; background:#FFF; border-top:3px #ff6900 solid; border-radius:5px 5px 0 0 ;">
                   <div id="zuoxia">
                    	<div style="color:#58afdc; height:50px; line-height: 45px; font-size:22px;"><s:property value="#data.title" /></div>
                    	<div style="height:30px; font-size:16px; margin-top:10px;">
                        	最新动态：
                            <span style=" color:#58afdc; display:inline-block; width:190px;"><s:property value="#projectlogList[#projectlogList.size()-1].handletime" /></span>
                        	<span style=" color:#58afdc; display:inline-block;"><s:property value="#projectlogList[#projectlogList.size()-1].handle" /></span>
                        </div>
                        
                        <div style="height:80px;">
                        	<s:if test="#data.status == '竞标中'">
                        		<img src="<%=request.getContextPath()%>/images/xiangmujindu_1.gif"/>
                        	</s:if>
                        	<s:elseif test="#data.status != '审核中' && #data.status != '竞标中'  && #data.status != '已完成' ">
                        		<img src="<%=request.getContextPath()%>/images/xiangmujindu_4.gif"/>
                        	</s:elseif>
                        	<s:elseif test="#data.status == '双方互评">
                        		<img src="<%=request.getContextPath()%>/images/xiangmujindu_2.gif"/>
                        	</s:elseif>
                        	<s:elseif test="#data.status == '已完成">
                        		<img src="<%=request.getContextPath()%>/images/xiangmujindu_3.gif"/>
                        	</s:elseif>
                        </div>
                    	<div id="xinxi">
                        	<li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_1.gif);"></div>
                                <div>发布时间：<span><s:property value="#data.foundtime" /></span></div>
                            </li>
                            
                           	<li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_2.gif);"></div>
                                <div>项目预算：<span>
                                		<s:if test="#data.budget == 1">
	                                		免费练手
	                                	</s:if>
	                                	<s:elseif test="#data.budget == 2">
	                                		小于￥1000
	                                	</s:elseif>
	                                	<s:elseif test="#data.budget == 3">
	                                		￥1000-￥3000
	                                	</s:elseif>
	                                	<s:elseif test="#data.budget == 4">
	                                		￥3000-￥5000
	                                	</s:elseif>
                                </span></div>
                            </li>
                            <li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_3.gif);"></div>
                                <div>开发周期：<span>
                                		<s:if test="#data.projectend == 1">
	                                		详谈
	                                	</s:if>
	                                	<s:elseif test="#data.projectend == 2">
	                                		1-5天
	                                	</s:elseif>
	                                	<s:elseif test="#data.projectend == 3">
	                                		5-10天
	                                	</s:elseif>
	                                	<s:elseif test="#data.projectend == 4">
	                                		10-20天
	                                	</s:elseif>
	                                	<s:elseif test="#data.projectend == 5">
	                                		20-30天
	                                	</s:elseif>
	                                	<s:elseif test="#data.projectend == 6">
	                                		30天以上
	                                	</s:elseif>
                                </span></div>
                            </li>
                           	<li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_4.gif);"></div>
                                <div>项目分类：<span><s:property value="#data.category.catename" /></span></div>
                            </li>
                            <li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_5.gif);"></div>
                                <div>已有竞标：<span>6</span></div>
                            </li>
                        	<li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_6.gif);"></div>
                                <div>竞标要求：<span>
                                	<img src="<%=request.getContextPath()%>/images/phone.jpg" />
                               		<img src="<%=request.getContextPath()%>/images/realName.jpg" />
                               		<img src="<%=request.getContextPath()%>/images/invoice.jpg" />
                                </span></div>
                            </li>
                        </div>
                        
                        <div style="height:150px;background:#b2d4dd; margin-top:30px; border-radius: 4px;">
                        	<div style="width:108px; height:108px; float:left; margin-left:20px; margin-top:20px;">
                        		<img style="width:108px; height:108px;" src="<%=request.getContextPath()%>/images/self.png" />
                        	</div>
                            <div style="float:left; height:108px; width:300px; margin-top:20px; margin-left:20px;">
                            	<div style="color:#547885; font-size:18px;"><s:property value="#data.userByFounderId.username" /></div>
                                <div style="color:#95a1a2; margin-top:10px; font-size:16px; ">身份：职业人</div>
                                <div style="color:#95a1a2; margin-top:5px; font-size:16px;">来自：杭州</div>
                            
                            </div>
                            <div style=" float:left; width:300px; margin-top:50px;">
                            	<s:if test="#data.userByUndertakerId == null">
                            		<img src="<%=request.getContextPath()%>/images/jingbiaohouchakan.gif" />
                            	</s:if>
                            	<s:else>
                            		<span style="color:#95a1a2;">手机：<s:property value="#data.phone" /></span>
                            	</s:else>
                            </div>
                        </div>
                        
                        <div style="margin-top:30px; font-size:18px; color:#8b9fa7">
                        	 <b>项目状态：</b> <s:property value="#data.status" /><br>
                        </div>
                        
                    	<div style="margin-top:30px; font-size:18px; color:#8b9fa7">
                        	<b>项目描述：</b><br />
                        	<div style="width:100%; font-size:16px; line-height: 25px; min-height:400px; padding-top: 15px; text-indent: 20px; line-height: ; border:1px #b2d4dd solid; border-radius:4px; margin-top:10px;">
                        		<s:property value="#data.description" escape="false" />
	                        		<s:if test="#files.size() > 0">
	                        		 <div style="margin-top: 50px;">
			                        	附件：<ul style="list-style-type: none; padding: 0; margin: 0; ">
												<s:iterator value="#files">
													<li><s:a action="wprojectAction_download.action?fid=%{fid}"><s:property value="filename" /></s:a></li>
												</s:iterator>
											</ul>
			                        </div>
	                       	 	</s:if>
                        	</div>
                        </div>
                        
                        <div style="margin-top:20px;">
                        	<div style="font-size:18px; border-bottom:1px #d9d9d9 solid; width:100%;">项目日志：</div>
                            <s:iterator value="projectlogList">
						  		<li style="list-style:none; margin-top:5px; font-size:16px; color:#b2b2b1; height:35px; width:700px; margin:0 auto; margin-top:5px; border-bottom:1px #d9d9d9 dashed;"><s:property value="handletime" /><span style=" margin-left:30px; color:#000;"><s:property value="handle" /></span></li>
						  	</s:iterator>
                        </div>
                        
                      	 <h3 style="font-weight: normal;">计划列表：</h3>
                      	 <div class="planList">
                      	 	<s:iterator value="dataList">
	                      	 	<div class="plan-info">
	                      	 		<ul>
		                      	 		<li>金额：<s:property value="planmoney" /></li>
		                      	 		<li>交付日期：<s:property value="completedate" /></li>
		                      	 		<li>验收协议：<s:property value="standard" /></li>
		                      	 		<li>发布时间：<s:property value="uploadtime" /></li>
		                      	 		<li>状态：<s:property value="state" /></li>
		                      	 	</ul>
		                      	 	<div class="files">
		                      	 		项目文件：
		                      	 		<s:a action="">
		                      	 			<img src="<%=request.getContextPath()%>/images/doc.png" />详细设计文档.docx
		                      	 		</s:a>
		                      	 	</div>
	                      	 	</div>
	                      	 	
	                      	 </s:iterator>
                      	 </div>
                    </div>
            	 
            </div>
			
			
			       	
        </div>
    </div>
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

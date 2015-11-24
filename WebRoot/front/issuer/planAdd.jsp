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
    
    <title>添加计划</title>
	
	<script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/tianjiajihua.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all10.js"></script>
	
	<style type="text/css">
		ul {list-style-type: none;}
		ul li {float: left; margin-left: 15px;}
		
		a{ text-decoration:none; color:#b6b6b6}
		a:hover{ color: white;}
	</style>
	
	<script type="text/javascript"><%--
		$(function(){
			
			$('#bidChoose').click(function(){
				alert("<s:property value='%{#data.pid}'/>") ;
				
				$.post('project/wbidAction_bidChoose.action?pid='<s:property value="%{#data.pid}"/>'&taskId='<s:property value="%{#task.id}"'', function(result){
					
				});
				
			});
			
		});
	--%></script>

  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	
	 <div id="main" style="background-color:#efeff5; height:680px; margin:0 auto; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:30px; margin:0 auto; border:2px dashed #999; border-radius:5px; margin-top:5px;">
        	<span style="font-size:20px; margin-left:5px; font-size:20px;">当前位置</span>
        	>><a>首页</a>
            <a>添加计划</a>
            
        </div>
    	<div style=" width:960px; height:560px; margin:0 auto; margin-top:5px;">
        	<%@ include file="/front/frame/left.jsp" %>
           	<div style="width:790px; background:#FFF; padding-bottom:20px; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
            	<div style="width:750px; height:60px; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">计划管理</div>
                <div style=" width:750px; margin:0 auto;">
                	<div style="height:120px; width:100%;background:#b2d4dd; border-radius:6px;">
                    	<table style=" display:inline-table; margin-top:15px;border-collapse:separate; border-spacing:2px 10px;">
                        	<tr align="right" height="30px">
                            	<th width="100px">接包方：</th>
                                <th width="250px;"><select style="width:100%; height:100%"></select></th>
                                <th width="100px">时间段：</th>
                                <th width="250px;"><select style="width:100%; height:100%"></select></th>
                            </tr>
                            <tr align="right" height="30px">
                            	<th width="100px">项目名称：</th>
                                <th width="250px;"><select style="width:100%; height:100%"></select></th>
                                <th width="100px">状态：</th>
                                <th width="250px;"><select style="width:100%; height:100%"></select></th>                           
                            </tr>
                        </table>
                    </div>
                    
                	<div style="width:100%; margin-top:30px; border:1px #b2d4dd solid; border-radius:0 0 5px 5px; padding-bottom:10px;">
                    	<table align="center" style="">
                        	<tr style="color:#6b8f9a; background:#b2d4dd" height="40px">
                            	<th width="125px">所属项目</th>
                                <th width="125px">承接方</th>
                                <th width="125px">金额</th>
                                <th width="125px">完成日期</th>
                                <th width="125px">状态</th>
                                <th width="125px">操作</th>
                            </tr>
                            <s:iterator value="planList">
	                            <tr style="color:#b6b6b6;">
	                            	<th><s:property value="project.title" /></th>
	                                <th><s:property value="project.userByUndertakerId.username" /></th>
	                                <th><s:property value="planmoney" /></th>
	                                <th><s:property value="completedate" /></th>
	                                <th><s:property value="state" /></th>
	                                <th align="center"><div style="background:#efeef4; width:100px; line-height:30px; height:30px;" id="chakan"><s:a action="">查看</s:a></div></th>                            
	                            </tr>
					 		</s:iterator>
                        </table>
                    </div>
                    
                    <div style="margin-top:30px;">
                    	<div id="tianjiajihua" style="width:150px; font-size:18px; height:34px; color:#FFF; cursor: pointer; background:#ff6900; line-height:2em; text-align:center;">添加计划</div>
                        <s:form action="project/wplanAction_makePlan.action">
	                        <s:hidden name="pid" value="%{#data.pid}"></s:hidden>
				 			<s:hidden name="taskId" value="%{#data.taskId}"></s:hidden>
				 			<s:hidden name="executionId" value="%{#data.executionId}"></s:hidden>
				 			<s:hidden name="newPlan" value="%{#newPlan}"></s:hidden>
	                        <div id="tianjiajihua1" style="background:#b2d4dd; width:100%; margin-top:15px; border-radius:4px; overflow:hidden; display:-none;">
	                        	<table style=" display:inline-table; margin-top:10px; margin-left:10px; font-size:18px; color:#7598a4; width:550px; float:left; ">
	                            	<tr height="36px">
	                                	<th width="100px" valign="top">计划金额：</th>
	                                	<th align="left"><s:textfield name="planmoney"  style="width:40%; height:100%; font-size:18px;"></s:textfield></th>
	                                </tr>
	                                <tr height="36px">
	                                	<th width="100px" valign="top">交付日期：</th>
	                                    <th align="left"><s:textfield name="completedate" style="width:40%;height:100%; font-size:18px;"></s:textfield></th>
	                                </tr>
	                                <tr>
	                                	<th height="36px" width="100px" valign="top">验收协议：</th>
	                                    <th height="70px"  align="left" valign="top"><s:textarea name="standard" style="width:100%; height:100%"></s:textarea></th>
	                                </tr>
	                            </table>
	                        	<s:submit value="确认添加" style=" width:150px; height:33px; float:left; background:#ff6900; font-size:18px; line-height:30px; text-align:center; color:#fff; float:left; margin-top:120px; margin-left:20px; border-radius:4px;" id="querentianjia"></s:submit>
                        	</s:form>
                        </div>
                    </div>
                </div>
            </div>
           	
           	<%--  <div style="width:790px; background:#FFF; height:559px; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
            	<div style="width:750px; height:60px; border-bottom:2px #e7f1f3 dotted; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">计划管理</div>
                <div>
                	已有计划列表。
		 			<ul>
		 				<li>关联项目</li>
		 				<li>承接方</li>
		 				<li>金额</li>
		 				<li>完成日期</li>
		 				<li>状态</li>
		 				<li>操作</li>
			 		</ul><br />
			 		<s:iterator value="planList">
				 			<ul>
				 				<li><s:property value="project.title" /></li>
				 				<li><s:property value="project.userByUndertakerId.username" /></li>
				 				<li><s:property value="planmoney" /></li>
				 				<li><s:property value="completedate" /></li>
				 				<li><s:property value="state" /></li>
				 				<li><s:a action="">查看</s:a></li>
				 			</ul><br />
			 		</s:iterator>
                </div>
                
                <div>
			 		添加计划：
			 		<s:form action="project/wplanAction_makePlan.action">
			 			<s:hidden name="pid" value="%{#data.pid}"></s:hidden>
			 			<s:hidden name="taskId" value="%{#data.taskId}"></s:hidden>
			 			<s:hidden name="executionId" value="%{#data.executionId}"></s:hidden>
			 			<s:hidden name="newPlan" value="%{#newPlan}"></s:hidden>
			 			计划金额：<s:textfield name="planmoney"></s:textfield><br />
			 			交付日期：<s:textfield name="completedate"></s:textfield><br />
			 			验收协议：<s:textarea name="standard" cols="50" rows="10"></s:textarea><br />
			 			<s:submit value="新增计划"></s:submit>
			 		</s:form>
			 	</div>
            </div> --%>
       	</div>
    </div>
	
 	<%--<div>
 		已有计划列表。
 			<ul>
 				<li>关联项目</li>
 				<li>承接方</li>
 				<li>金额</li>
 				<li>完成日期</li>
 				<li>状态</li>
 				<li>操作</li>
	 		</ul><br />
	 		<s:iterator value="planList">
	 			<ul>
	 				<li><s:property value="project.title" /></li>
	 				<li><s:property value="project.userByUndertakerId.username" /></li>
	 				<li><s:property value="planmoney" /></li>
	 				<li><s:property value="completedate" /></li>
	 				<li><s:property value="state" /></li>
	 				<li><s:a action="">查看</s:a></li>
	 			</ul>
	 			<br />
	 		</s:iterator>
 	</div>
 	
 	<div>
 		<s:form action="project/wplanAction_makePlan.action">
 			<s:hidden name="pid" value="%{#data.pid}"></s:hidden>
 			<s:hidden name="taskId" value="%{#data.taskId}"></s:hidden>
 			计划金额：<s:textfield name="planmoney"></s:textfield>
 			交付日期：<s:textfield name="completedate"></s:textfield>
 			验收协议：<s:textarea name="standard" cols="50" rows="10"></s:textarea>
 			<s:submit value="新增计划"></s:submit>
 		</s:form>
 	</div>
  	--%><%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

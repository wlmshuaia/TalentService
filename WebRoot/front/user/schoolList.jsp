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
		.schoolList {  width: 100%; height: auto; padding-bottom: 20px; margin:0 auto; overflow: hidden; }
		.schoolList ul { padding: 0; margin: 0; display: block; }
		.schoolList ul li { display: block; background: white; width: 500px; height: 130px; border-radius: 4px; float: left; margin: 10px 0 0 10px; }
		.schoolList .schoolHead { width: 64px; height: 64px; float: left; margin: 20px; border-radius: 100px; border: #3e6372 1px solid; }
		.schoolList .schoolInfoCon {float: left; width: 300px; height: 100%; }
		.schoolList .schoolInfoCon .schoolName { padding: 20px 0 0 20px; }
		.schoolList .schoolInfoCon .schoolName a { color: green; font-size: 16px;}
		.schoolList .schoolInfoCon .schoolIntro { width: 100%; height: 80px; padding: 0; text-indent: 20px; margin: 0; font-size: 14px; color: #3e6372; word-wrap: break-word; word-break: normal;}
		.schoolList .schoolIdentity { width: 70px; height: 100%; float: right; }
		.schoolList .schoolIdentity img { float: right; margin: 70px 20px 0 0;}
    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; padding-bottom:20px; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width: 1060px; height:30px; margin:0 auto; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a>学校列表</a>
        </div> 		
        
        <div style=" width: 1060px; padding-bottom:20px; margin:10px auto; border-radius:5px 5px 0 0 ; ">
            <div class="schoolList">
                <ul>
	                <s:iterator value="dataList">
	                	<li>
	                    	<div class="schoolHead">
	                    		<s:if test="school.gravatar != NULL">
	                    			<img alt="显示图片" style="width: 100%; height: 100%; border-radius: 100px; " src="<s:url action='userAction_getPic.action?uid=%{u.uid}'></s:url>">
	                    		</s:if>
	                    		<s:else>
	                    			<img alt="" src="<%=request.getContextPath()%>/images/touxiang_auto.png" style="width: 100%; height: 100%;">
	                    		</s:else>
	                    	</div>
	                    	<div class="schoolInfoCon">
	                    		<div class="schoolName">
	                    			<a href="user/schoolAction_getSchool.action">
	                    				<s:property value="u.username" />
	                    			</a>
	                    		</div>
	                    		<div class="schoolIntro">
	                    			<s:property value="school.introduction" escape="false" />
	                    		</div>
	                    	</div>
	                    	<div class="schoolIdentity">
	                    		<img alt="" src="<%=request.getContextPath()%>/images/touxiang_auto.png" style="width: 32px; height: 32px;">
	                    	</div>
	                    </li>
	                </s:iterator>
                </ul>
                
            </div>
            
            <div class="page">
				<%
					int start = Integer.parseInt(ActionContext.getContext().get("start").toString()) ;
					int end = Integer.parseInt(ActionContext.getContext().get("end").toString()) ;
					int pageNum = Integer.parseInt(ActionContext.getContext().get("page").toString()) ;
					
					if(pageNum > 1){
						out.print("<span><a href='user/schoolAction_dataList.action?start="+(pageNum-1)+"'>上一页</a></span>") ;
					}else{
						out.print("<span>上一页</span>") ;
					}
				%>
				<ul>
					<%
						for(int i = start; i <=
						end; i ++){
							if(i == pageNum){
								out.print("<li class='choose'><b>"+i+"</b></li>") ;
							}else{
								out.print("<li><a href='user/schoolAction_dataList.action?start="+i+"'>"+i+"</a></li>") ;
							}
						}
						
					%>
				</ul>
				<%
					if(pageNum < end){
						out.print("<span><a href='user/schoolAction_dataList.action?start="+(pageNum+1)+"'>下一页</a></span>") ;
					}else{
						out.print("<span>下一页</span>") ;
					}
				%>
			</div>
            
        </div>
    </div>	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*, java.lang.Short" pageEncoding="UTF-8"%>
<%@ page import="com.talentservice.domain.User, com.talentservice.utils.OAUtils" %>
<%@ include file="/admin/common/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>导航</title>
    
	<link href="<%=request.getContextPath()%>/CSS/head.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		.ifLogin a { color: white;}
		#geren a { color: black;}
	</style>
  </head>
  
  <body>
  
	<div id="heada">
        <div id="head">
            <a href="#">
            	<div id="head1"></div>
            </a>
            <%
            	User user = (User) OAUtils.fromSession("user") ;
            %>
            <div id="head2"></div>
            <div id="head3">
                <li><a href="project/wprojectAction_dataList.action">项目</a></li>
                <li><a href="circle/wcircleAction_dataList.action">圈子</a></li>
                <li><a href="user/schoolAction_dataList.action">院校</a></li>
                <li><a>企业</a></li>
               	<%
               		if(user != null){
                		short type = user.getType() ;
                		if(type == (short) 0){	// 学生
                			out.println("<li><a>人脉</a></li><li><a href='user/userAction_getPersonal.action'>个人</a></li>");
                		}else if(type == 1){	// 高校
                			out.println("<li><a href='user/schoolAction_getSchool.action'>学校主页</a></li>");
                		}else if(type == 4){	// 教师
                			out.println("<li><a>人脉</a></li><li><a href='user/userAction_getPersonal.action'>个人</a></li>");
                		}
               		} else {
               			out.println("<li><a>人脉</a></li><li><a href='user/userAction_getPersonal.action'>个人</a></li>");
               		}
               	%>
                	
                
            </div>
            <!-- <div id="head4">
                <input type="text" name="sousuo" id="sousuo" />
                <div></div>
            </div> -->
            <div id="head5">
            	<div id="geren" style="text-align: center;">
            		<div style=" width: 70px; text-align: center; line-height: 40px; padding-left: 20px; cursor: pointer; white-space:nowrap; overflow:hidden; text-overflow:ellipsis">
            		<%
						if(user != null){
							out.print("hi, <font color='#ff6900'>"+user.getUsername()+"</font>");
						}else{
							//out.println("<a href='login/wloginAction_loginUI.action'>登录</a> <a href='register/wregisterAction_registerUI.action'>注册</a>");
							out.print("<a href='login/wloginAction_loginUI.action'>登录</a>") ;
						}
						ActionContext.getContext().put("user", user) ;
					%>
                	</div>
                	<div class="gerenxiaoxi-container" id="gerenxiaoxi-container" style=" display: none; ">
                		<div id="gerenxiaoxi" style="height: auto; line-height:2em;">
	                		<li><a href="project/wprojectAction_personalProjectList.action">我的发布</a><span>10</span></li>
							<li><a href="project/wprojectAction_bidderProjectList.action">我的承接</a><span>8</span></li>
							<li><a href="project/wprojectAction_groupList.action">我的团队</a><span>2</span></li>
	                    	<li><a>我的关注</a><span>3</span></li>
	                        <li><a>话题动态</a><span>4</span></li>
	                        <li><a>我的私信</a><span>5</span></li>
	                        <%
	                        	if(user != null){
	                        		if(user.getType() == 4){
		                        		out.print("<li><a href='user/studentAction_getStudents.action'>学生管理</a><span>1</span></li> ") ;
		                        	}
	                        	}
	                        %>
	                    </div>
                	</div>
                </div>
               	<div class="ifLogin" style="width:70px; border:1px #3e6373 solid; background:#3e6373; color:#FFF; border-radius: 8px; font-size:20px; text-align:center; line-height:2em;">
                	<s:if test="#user != null">
	                	<a href="login/wloginAction_logout.action" style="color: white;">退出</a>
                	</s:if>
                	<s:else>
	                	<a href='register/wregisterAction_registerUI.action'>注册</a>
	                </s:else>
                </div>
            </div>
        </div>
  </div>
  </body>
</html>

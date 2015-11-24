<%@page import="com.opensymphony.xwork2.ActionContext"%>
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
    
    <title>学院资料</title>
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
	
	<script type="text/javascript">
		function formSubmit() {
			
			if(confirm("保存修改？")) {
				//$('#myForm').submit() ;
				$('#myForm').form('submit', {    
				    success: function(result){
				    	var data = eval('(' + result + ')');
				    	alert(data.message) ;
				    	window.location.reload();
				    }
				});
				/*$.ajax({
					type: 'post',
					data: $('#myForm').serialize(),
					url: 'user/studentAction_personal.action',
					dataType: 'json',
					success: function(result) {
						alert(result.message) ;
					},
					error: function(result) {
				        alert(result.message) ;
					}
				}) ;*/
	        }
		}
	</script>
	
	<style>
		table tr th input{ height:20px; height: 30px; font-size:20px; font-weight: 0px; border:1px #b2d4dd solid; width:100%; border-radius:3px; }
		a{ text-decoration:none;}
		#liebiao{ width:166px; height: auto; background:#FFF;border-bottom:1px #dde0e1 solid; box-shadow:0px 1px #b7b7ba;}
		#liebiao li{ list-style:none;  width:166px; height:50px; color:#4c6d7b; font-size:18px; text-align:center; line-height:3em;}
		#liebiao li a{  color:#4c6d7b;}
		#liebiao li a:hover{ color:#ff6900; cursor:pointer;}
		.choose {color: #ff6900;}
		
		.oneContent { width: 100%; min-height: 150px; overflow: hidden; border-bottom: #3e6372 1px solid;}
		.schoolIntro { font-size: 24px; color:#3e6270; width:100%; height: auto; margin:0 auto; margin-top:20px; padding-left: 25px; clear: right;}
		.schoolIntro .issueHead { float: left;}
		.schoolIntro .issueTrain { float: left; margin-left: 50px; font-size: 16px; padding: 4px 6px; color: white; background: #3e6372; border-radius: 4px;}
		.schoolIntro .issueTrain a { color: white;}
		.schoolContent { float: left; font-size:16px; width:100%; margin:0 auto; margin-top:20px; padding-left: 40px;}
		.schoolContent ul { padding: 0; margin: 0;}
		.schoolContent ul li { list-style: none; margin-top: 10px; display: block; width: 100%; height: 35px; line-height: 35px; }
		.schoolContent ul li a { color: #3e6372;}
		.schoolContent ul li a:hover { color: #ff6900;}
		.schoolContent .professionName { width: 150px; float:left; }
		.schoolContent .professionDevelop { width: 200px; float:left; padding-left: 150px;  white-space:nowrap; overflow:hidden; text-overflow:ellipsis}
		.schoolContent .professionInfo { width: 150px; float: right; margin-right: 50px; }
		.schoolContent .professionInfo a { color: #3e6372; }
	</style>
    
  </head>
  
  <body>
  	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; margin:0 auto; padding-bottom: 30px; border-top:1px #6b6b6b solid;">
    	<div id="weizhi" style="width: 85%; height:auto; margin:0 auto; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
        	<s:a action="schoolAction_getSchool.action?sid=%{#school.uid}"><s:property value="#school.username" /></s:a>>>
            <a><s:property value="#collegeUser.username" /></a>
        </div>
    	<div style=" width: 85%; height:auto; overflow: hidden; margin:0 auto; margin-top:5px;">
            <div style="width: 15%; float:left; height: auto;float:left">
                <div id="liebiao">
                    <li><a style="color:#ff6900;">学院资料</a></li>
                    <li><a href="fabao_jihuaguanli.html">信息修改</a></li>
                </div>
             </div> 
            
            <div style="width: 83%; background:#FFF; height:auto; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
	            <s:form id="myForm" action="user/schoolAction_school.action" method="post" enctype="multipart/form-data">
	            	<s:hidden name="user.uid" value="%{#user.uid}"></s:hidden>
	            	<div style="width:100%; height:200px; padding-left: 25px; border-bottom:2px #e7f1f3  solid; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">
	                	<div style="width:128px; height:128px; float:left; border:1px #000000 solid; border-radius: 100px; margin-top:15px;">
	                		<s:if test="#gravatar != NULL">
	                			<img alt="显示图片" style="width: 100%; height: 100%;" src="<s:url action='user/userAction_getPic.action'></s:url>">
	                		</s:if>
	                		<s:else>
	                			<img alt="" src="<%=request.getContextPath()%>/images/touxiang_auto.png" style="width: 100%; height: 100%;">
	                		</s:else>
	                		<s:file name="upload" placeholder="上传头像"></s:file>
	                		<s:hidden name="gravatar" value="%{#data.gravatar}"></s:hidden>
	                	</div>
	                    <div style="height:128px; margin-top:15px; float:left; margin-left:10px;">
	                    	<div style="height:30px; font-size:20px; color:#3e6270; margin-top:0px; line-height:1em;">
	                    		<s:property value="#collegeUser.username" />
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="oneContent">
	                	<div class="schoolIntro">
		                	<div class="issueHead">学院简介</div>
		                	<div class="issueTrain">
		                		<a href="">编辑简介</a>
		                	</div>
		                </div>
		                <div class="schoolContent">
		                	<s:if test="#college.introduction != NULL">
		                		<s:property value="#college.introduction" />
		                	</s:if>
		                	<s:else>
		                		暂无
		                	</s:else>
		                </div>
	                </div>
	                
	                <div class="oneContent">
		                <div class="schoolIntro">
		                	<div class="issueHead">专业列表</div>
		                	<div class="issueTrain">
		                		<a href="">添加专业</a>
		                	</div>
		                </div>
		                <div class="schoolContent">
		                	<s:if test="#professionList.size() == 0">
		                		暂无
		                	</s:if>
		                	<s:else>
		                		<ul>
			                		<s:iterator value="professionList">
		                				<li>
		                					<div class="professionName">
		                						<s:a action="user/collegeAction_getCollege.action?cid=%{college.cid}">
			                						<s:property value="name" />
			                					</s:a>
		                					</div>
		                					
		                					<div class="professionDevelop">
		                						<s:property value="develop" />
		                					</div>
		                					
		                					<div class="professionInfo">
		                						<a href="">专业方向</a>
		                					</div>
		                				</li>
			                		</s:iterator>
		                		</ul>
		                	</s:else>
		                </div>
		            </div>
	                
            	</s:form>
            </div>
            
       	</div>
    
    </div>
	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

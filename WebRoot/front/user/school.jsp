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
    
    <title>学校资料</title>
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
	
	<style>
		table tr th input{ height:20px; height: 30px; font-size:20px; font-weight: 0px; border:1px #b2d4dd solid; width:100%; border-radius:3px; }
		a{ text-decoration:none;}
		#liebiao{ width:166px; height: auto; background:#FFF;border-bottom:1px #dde0e1 solid; box-shadow:0px 1px #b7b7ba;}
		#liebiao li{ list-style:none;  width:166px; height:50px; color:#4c6d7b; font-size:18px; text-align:center; line-height:3em;}
		#liebiao li a{  color:#4c6d7b;}
		#liebiao li a:hover{ color:#ff6900; cursor:pointer;}
		.choose {color: #ff6900;}
		
	</style>
    
  </head>
  
  <body>
  	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; margin:0 auto; padding-bottom: 30px; border-top:1px #6b6b6b solid;">
    	<div id="weizhi" style="width: 85%; height:auto; margin:0 auto; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a><s:property value="#user.username" /></a>
        </div>
    	<div style=" width: 85%; height:auto; overflow: hidden; margin:0 auto; margin-top:5px;">
            <div style="width: 15%; float:left; height: auto;float:left">
                <div id="liebiao">
                    <li><a style="color:#ff6900;" href="user/schoolAction_getSchool.action">学校资料</a></li>
                    <li><s:a action="schoolAction_infoEditUI.action?sid=%{#school.sid}">信息修改</s:a></li>
                </div>
             </div>
            
            <div style="width: 83%; background:#FFF; height:auto; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
	            	<div style="width:100%; height:200px; padding-left: 25px; border-bottom:2px #e7f1f3  solid; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">
	                	<div style="width:128px; height:128px; float:left; border:1px #000000 solid; border-radius: 100px; margin-top:15px;">
	                		<s:if test="#school.gravatar != NULL">
	                			<img alt="显示图片" style="width: 100%; height: 100%; border-radius: 100px; " src="<s:url action='user/userAction_getPic.action?uid=%{#user.uid}'></s:url>">
	                		</s:if>
	                		<s:else>
	                			<img alt="" src="<%=request.getContextPath()%>/images/touxiang_auto.png" style="width: 100%; height: 100%;">
	                		</s:else>
	                	</div>
	                    <div style="height:128px; margin-top:15px; float:left; margin-left:10px;">
	                    	<div style="height:30px; font-size:20px; color:#3e6270; margin-top:0px; line-height:1em;"><s:property value="#user.username" /></div>
	                    </div>
	                </div>
	                
	                <div class="oneContent">
	                	<div class="schoolIntro">
		                	<div class="issueHead">学校简介</div>
		                	<div class="issueTrain">
		                		<s:a action="schoolAction_infoEditUI.action?sid=%{#school.sid}">编辑简介</s:a>
		                	</div>
		                </div>
		                <div class="schoolContent">
		                	<s:property value="#school.introduction" escape="false" />
		                </div>
	                </div>
	                
	                <div class="oneContent">
		                <div class="schoolIntro">
		                	<div class="issueHead">学院列表</div>
		                	<div class="issueTrain">
		                		<s:a href="user/collegeAction_collegeAddUI.action?sid=%{#school.sid}">添加学院</s:a>
		                		<a>学院管理员登录</a>
		                	</div>
		                </div>
		                <div class="schoolContent">
		                	<s:if test="#collegeList.size() == 0">
		                		暂无
		                	</s:if>
		                	<s:else>
		                		<ul>
			                		<s:iterator value="collegeList">
		                				<li style="border: none;">
	                						<s:a action="user/collegeAction_getCollege.action?cid=%{college.cid}">
		                						<s:property value="user.username" />
		                					</s:a>
		                				</li>
			                		</s:iterator>
		                		</ul>
		                	</s:else>
		                </div>
		            </div>
	                
	                <div class="oneContent">
		                <div class="schoolIntro">
		                	<div class="issueHead">实训动态</div>
		                	<div class="issueTrain">
			                	<a href="project/wprojectAction_addUI.action">发布实训</a>
			                </div>
		                </div>
		                <div class="schoolContent">
		                	<s:if test="#projectList.size() == 0">
		                		暂无
		                	</s:if>
		                	<s:else>
		                		<ul>
			                		<s:iterator value="projectList">
		                				<li><s:property value="description" /></li>
			                		</s:iterator>
		                		</ul>
		                	</s:else>
		                </div>
		            </div>
	                
	                <div class="oneContent">
		                <div class="schoolIntro">
		                	<div class="issueHead">所有评论</div>
		                	<div class="issueTrain">
			                	<a href="javascript:void(0)" onclick="document.getElementById('review').scrollIntoView();">添加评论</a>
			                </div>
		                </div>
		                <div class="schoolContent">
		                	<s:if test="#reviewList.size() == 0">
		                		暂无
		                	</s:if>
		                	<s:else>
		                		<ul>
		                		<s:iterator value="reviewList">
	                				<li>
	                					<div class="reviewHead">
	                						<s:if test="gravatar != NULL">
	                							<img alt="显示图片" style="width: 100%; height: 100%; border-radius: 100px; " src="<s:url action='userAction_getPic.action?uid=%{review.userByFromuserId.uid}'></s:url>">
	                						</s:if>
	                						<s:else>
	                							<img alt="" src="<%=request.getContextPath()%>/images/touxiang_auto.png" style="width: 100%; height: 100%;">
	                						</s:else>
	                					</div>
	                					<div class="reviewContainer">
	                						<div class="reviewer">
	                							<s:property value="review.userByFromuserId.username" />
	                						</div>
	                						<div class="reviewContent">
	                							<s:property value="review.content" />
	                						</div>
	                					</div>
	                					<div class="reviewTimeContainer">
	                						<div class="reviewTime">
	                							<s:property value="review.time" />
	                						</div>
	                						<div class="reviewReply">
	                							<a>回复</a>
	                						</div>
	                					</div>
	                					
	                					<%-- <s:property value="content" /> --%>
	                				</li>
		                		</s:iterator>
		                		</ul>
		                		
		                		<div class="page">
									<%
										int start = Integer.parseInt(ActionContext.getContext().get("start").toString()) ;
										int end = Integer.parseInt(ActionContext.getContext().get("end").toString()) ;
										int pageNum = Integer.parseInt(ActionContext.getContext().get("page").toString()) ;
										
										if(pageNum > 1){
											out.print("<span><a href='user/schoolAction_getSchool.action?start="+(pageNum-1)+"'>上一页</a></span>") ;
										}else{
											out.print("<span>上一页</span>") ;
										}
									%>
									<ul>
										<%
											for(int i = start; i <= end; i ++){
												if(i == pageNum){
													out.print("<li class='choose'><b>"+i+"</b></li>") ;
												}else{
													out.print("<li><a href='user/schoolAction_getSchool.action?start="+i+"'>"+i+"</a></li>") ;
												}
											}
											
										%>
									</ul>
									<%
										if(pageNum < end){
											out.print("<span><a href='user/schoolAction_getSchool.action?start="+(pageNum+1)+"'>下一页</a></span>") ;
										}else{
											out.print("<span>下一页</span>") ;
										}
									%>
								</div>
		                	</s:else>
		                	
		                	<a name="review" id="review">&nbsp;</a>
		                	<div class="review">
			              		<h5>发表评论</h5>
			              		<s:form action="schoolAction_review.action" id="reviewForm">
			              			<s:hidden name="sid" value="%{#school.sid}"></s:hidden>
			              			<div class="reviewCon">
				              			<textarea name="review.content"></textarea>
				              		</div>
				              		<div class="reviewSub">
				              			<input type="button" onclick="reviewSubmit();" value="发布评论" />
				              		</div>
			              		</s:form>
			              	</div>
		                	
		                	<script type="text/javascript">
		                		function reviewSubmit() {
		                			if(confirm("提交评论？")){
		                				/* $('#reviewForm').form('submit', {
		                					success: function(result){
		                						var data = eval('(' + result + ')');
										    	alert(data.message) ;
										    	window.location.reload();
		                					}
		                				}); */
		                				
		                				$('#reviewForm').form('submit', {    
										    success: function(result){
										    	var data = eval('(' + result + ')');
										    	alert(data.message) ;
										    	window.location.reload();
										    }
										});
		                			}
		                		}
		                	</script>
		                	
		                </div>
		                
		           </div>
		           
            </div>
            
       	</div>
    
    </div>
	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

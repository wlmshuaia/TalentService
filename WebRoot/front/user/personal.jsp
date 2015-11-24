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
    
    <title>个人中心</title>
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/diqu.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/tianxie.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all7.js"></script>
	
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
		#liebiao{ width:166px; height:480px; background:#FFF;border-bottom:1px #dde0e1 solid; box-shadow:0px 1px #b7b7ba;}
		#liebiao li{ list-style:none;  width:166px; height:50px; color:#4c6d7b; font-size:18px; text-align:center; line-height:3em;}
		#liebiao li a{  color:#4c6d7b;}
		#liebiao li a:hover{ color:#ff6900; cursor:pointer;}
		.choose {color: #ff6900;}
	</style>
    
  </head>
  
  <body>
  	<%@ include file="/front/frame/header.jsp" %>
	
	<div id="main" style="background-color:#efeff5; height:1100px; margin:0 auto; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:auto; margin:0 auto; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a>个人中心</a>
        </div>
    	<div style=" width:960px; height:auto; margin:0 auto; margin-top:5px;">
        	<div style="width:166px; float:left; height:300px;">
                <div id="fc" style=" width:166px; height:105px; background:url(<%=request.getContextPath()%>/images/gerenzhongxin.gif);"></div>
                <div id="liebiao">
                    <li><a>我的主页</a></li>
                    <li><a href="user/userAction_getPersonal.action" style="color: #ff6900">我的资料</a></li>
                    <li><a>我的账户</a></li>
                    <li><a>我的积分</a></li>
                    <li><a>我的动态</a></li>
                    <li><a>我的私信</a></li>
                    <li><a>我的收藏</a></li>
                    <li><a>我的圈子</a></li>
                    <li><a>我的人脉</a></li>
                </div>
             </div>   
            <div style="width:790px; background:#FFF; height:auto; float:left;border-bottom:1px #dde0e1 solid; box-shadow:1px 1px #b7b7ba;border-right:1px #dde0e1 solid; border-radius:4px 0 0 4px; border-left:2px #ff6900 solid; ">
	            <s:form id="myForm" action="user/studentAction_personal.action" method="post" enctype="multipart/form-data">
	            	<s:hidden name="user.uid" value="%{#user.uid}"></s:hidden>
	            	<div style="width:750px; height:160px; border-bottom:2px #e7f1f3  solid; margin:0 auto; font-size:28px; line-height:2em; color:#3e6373">
	                	<div style="width:128px; height:128px; float:left; border:1px #000000 solid; border-radius: 100px; margin-top:15px;">
	                		<s:if test="#data.gravatar != NULL">
	                			<img alt="显示图片" style="width: 100%; height: 100%; border-radius: 100px; " src="<s:url action='user/userAction_getPic.action?uid=%{#user.uid}'></s:url>">
	                		</s:if>
	                		<s:else>
	                			<img alt="" src="<%=request.getContextPath()%>/images/touxiang_auto.png" style="width: 100%; height: 100%;">
	                		</s:else>
	                		<s:file name="upload" placeholder="上传头像"></s:file>
	                		<s:hidden name="gravatar" value="%{#data.gravatar}"></s:hidden>
	                	</div>
	                    <div style="height:128px; margin-top:15px; float:left; margin-left:10px;">
	                    	<div style="height:30px; font-size:20px; color:#3e6270; margin-top:0px; line-height:1em;"><s:property value="#user.username" /></div>
	                        <div style=" margin-top:5px; height:20px;font-size:16px; line-height:1em;">项目积分：<span><s:property value="#data.integral" /></span></div>
	                        <div style=" margin-top:5px; height:20px; font-size:16px; line-height:1em;s">活跃积分：<span><s:property value="#data.integral" /></span></div>
	                        <div style=" margin-top:5px;  height:30px; font-size:16px; color:#ff6900;">
	                        	账户余额：
	                            <span>0.0</span>
	                            	元
	                            <input value="充值" style=" text-indent:10px; font-size:20px; border:1px #ff6900 solid; margin-left:30px; border-radius:4px; color:#FFF; background:#ff6900; display: inline-block; width:64px; height:28px;" />
	                        </div>
	                    </div>
	                </div>
	                
	                <div style="font-size:24px; color:#3e6270; width:730px; margin:0 auto; margin-top:20px;">基本信息</div>
	                <div style="font-size:24px; color:#ff6900; width:710px; margin:0 auto; margin-top:20px;">
		                   	<table style="font-size:20px;" cellpadding="5px" >
		                   		<tr><th align="left">昵称：</th><th><s:textfield name="name" value="%{#data.name}"></s:textfield></th></tr>
			                   	<tr><th align="left">用户名：</th><th><s:textfield style="width: 300px;" name="user.username" value="%{#user.username}"></s:textfield>（登录用）</th></tr>
			                   	<tr><th align="left">性别：</th><th><s:textfield name="sex" value="%{#data.sex}"></s:textfield></th></tr>
			                   	<tr><th align="left">出生年月：</th><th><s:textfield name="birthday" value="%{#data.birthday}" ></s:textfield></th></tr>
			                   	<tr><th align="left">籍贯：</th><th><s:textfield name="nativeplace" value="%{#data.nativeplace}" ></s:textfield></th></tr>
			                   	<tr><th align="left">居住地：</th><th><s:textfield name="address" id="juzhudi" value="%{#data.address}" ></s:textfield></th></tr>
			                   	<tr><th></th><th id="diquxuanze">
			                        <select style="width:32%;" id="deliverprovince" name="deliverprovince"></select>
									<select style="width:32%;" id="delivercity" name="delivercity"></select>
									<select style="width:32%;" id="deliverarea" name="deliverarea"></select>
                    			</th></tr>
			                   	<tr><th align="left">手机：</th><th><s:textfield name="phone" value="%{#data.phone}" ></s:textfield></th></tr>
			                   	<tr><th align="left">邮箱：</th><th><s:textfield name="mail" value="%{#data.mail}" ></s:textfield></th></tr>
			                   	<tr><th align="left">专业：</th><th><s:textfield name="professional" value="%{#data.professional}" ></s:textfield></th></tr>
			                   	<tr><th align="left">学历：</th><th><s:textfield name="degree" value="%{#data.degree}" ></s:textfield></th></tr>
			                   	<tr><th align="left">入学时间：</th><th><s:textfield name="enrollment" value="%{#data.enrollment}" ></s:textfield></th></tr>
			                   	<tr><th align="left">关注度：</th><th><s:textfield name="focus" value="%{#data.focus}" ></s:textfield></th></tr>
			                   	<tr><th align="left">积分：</th><th><s:textfield name="integral"  value="%{#data.integral}" ></s:textfield></th></tr>
			                   	<tr><th valign="top" align="left">简历：</th><th><s:textarea name="introduction" value="%{#data.introduction}" style="width:400px; font-size:20px; font-weight: bold; height:160px; border:1px #b2d4dd solid; border-radius:3px;"></s:textarea></th></tr>
			                   	<tr><th align="left">上传简历：</th><th><s:file style="width: 300px;" name="resume"></s:file>（可选）</th></tr>
			                   	<tr><th valign="top" align="left"></th><th><input type="button" onclick="formSubmit();" style="float: left; width: 120px; height: 40px; border-radius: 4px; background: white; border: blue 1px solid;"  value="保存修改" /></th></tr>
			               </table>
	                </div>
            	</s:form>
            </div>
            
       	</div>
    
    </div>
	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>

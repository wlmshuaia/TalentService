<%@page import="com.talentservice.utils.OAUtils"%>
<%@ page language="java" import="java.util.*, com.talentservice.domain.Admin, com.talentservice.utils.OAUtils" pageEncoding="UTF-8"%>
<%@ include file="/admin/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理系统</title> 
    
    <script type="text/javascript">
    	
    	$(function() {
    		$('a[title]').click(function(){
    			var src = $(this).attr("title") ;
    			var title = $(this).html() ;
    			
    			if($('#center-tabs').tabs('exists', title)){
    				$('#center-tabs').tabs('select', title) ;
    			}else{
    				var content = '<iframe scrolling="auto" frameborder="0"  src="'+src+'" style="width:100%;height:100%;"></iframe>';
        			$('#center-tabs').tabs('add',{
    	    			title:title,
    	    			content:content,
    	    			closable:true,
    	    		});
    			}
    		});
    	});
    	
    </script>
    
    <style type="text/css">
    	#north-layout {height:70px;background:#075281;}
	    #admin-info {float:right;margin:-30px 150px 0 0 ;color:white}
	    #quit-btn {clear: both; float: right; display: inline-block; color: red; margin: -5px 0 0 10px;}
	    
	    #south-layout {height: 50px; float: left;}
	    #south-layout p {text-align:center}
	    
	    #west-layout {width:200px;}
	    #menu-accordion {width:auto;height:auto;}
	    
	    #center-layout {padding:5px;background:#eee;}
	    #center-tabs {width:400px;height:350px;}
	    .loginInfo {margin: 10px 22px; line-height: 25px;}
    </style>
    
  </head>
  	<body class="easyui-layout">   
	    <div id="north-layout" data-options="region:'north',title:'',split:true,collapsible:false">
	    	<h1><font color=white size=5>&nbsp;&nbsp;&nbsp;&nbsp;后台管理系统</font></h1>
	    	<div id="admin-info">
	    		<font><b>欢迎您：<span id="admin">
	    		<%
	    			Admin admin = (Admin) OAUtils.fromSession("admin") ;
	    			out.print(admin.getAdminname()) ;
	    		%>
	    		</span></b></font>
	    		<a id="quit-btn" href="alogin/aloginAction_logout.action" class="easyui-linkbutton" data-options="plain:true"><b>退出</b></a>
	    	</div>
	    </div>
	      
	    <div id="south-layout" data-options="region:'south',title:'',split:true,collapsible:false">
	    	<p>&copy;TNT团队制作</p>
	    </div>
	    
	    <div id="west-layout" data-options="region:'west',title:'业务导航',split:true">
	    	<div id="menu-accordion" class="easyui-accordion" data-options="fit:true">
			    <div title="用户管理" data-options="iconCls:'icon-search'">
			         <ul id="user-tree" class="easyui-tree">
						<li><span><a title="admin/user/userList.jsp">用户列表</a></span></li>
						<li><span><a title="admin/user/userAdd.jsp">添加用户</a></span></li>
					</ul>
			    </div>
			    
			    <div title="项目管理" data-options="selected:true,iconCls:'icon-save'">
			    	<ul id="project-tree" class="easyui-tree">
						<li><span><a title="admin/project/approveList.jsp">项目审核</a></span></li>
						<li><span><a title="admin/project/projectList.jsp">项目列表</a></span></li>
						<li><span><a title="admin/project/projectList.jsp">项目添加</a></span></li>
						<li><span><a title="admin/project/projectList.jsp">项目回收</a></span></li>
					</ul>
			    </div>
			    
			    <div title="流程管理" data-options="iconCls:'icon-save'">
			    	<ul id="process-tree" class="easyui-tree">
						<li><span><a title="admin/workflow/workflowList.jsp">流程列表</a></span></li>
						<li><span><a>流程部署</a></span></li>
					</ul>
			    </div>
			    
			    <div title="权限控制" data-options="iconCls:'icon-save'">
			    	<ul id="rbac-tree" class="easyui-tree">
						<li><span><a title="admin/rbac/roleUserList.jsp">后台用户</a></span></li>
						<li><span><a title="admin/rbac/roleList.jsp">角色管理</a></span></li>
						<li><span><a title="admin/rbac/nodeList.jsp">权限管理</a></span></li>
					</ul>
			    </div>
			    
			    <div title="圈子管理" data-options="iconCls:'icon-sum'">
			    	<ul id="circle-tree" class="easyui-tree">
						<li><span><a title="admin/circle/circleList.jsp">圈子列表</a></span></li>
						<li><span>添加圈子</span></li>
					</ul>
			    </div>
			    
			    <div title="反馈管理" data-options="iconCls:'icon-sum'">
			    	<ul id="circle-tree" class="easyui-tree">
						<li><span><a title="">反馈列表</a></span></li>
						<li><span>添加圈子</span></li>
					</ul>
			    </div>
			    
			    <div title="分类标签" data-options="iconCls:'icon-save'">
			    	<ul id="category-tree" class="easyui-tree">
						<li><span><a title="admin/category/categoryList.jsp">分类列表</a></span></li>
						<li><span>添加分类</span></li>
						<li><span><a title="admin/label/labelList.jsp">标签列表</a></span></li>
						<li><span>添加标签</span></li>
					</ul>
			    </div>
			    
			    <div title="地区管理" data-options="iconCls:'icon-save'">
			    	<ul id="region-tree" class="easyui-tree">
						<li><span><a title="admin/region/provinceList.jsp">省级列表</a></span></li>
						<li><span><a title="admin/region/provinceList.jsp">市级列表</a></span></li>
						<li><span><a title="admin/region/provinceList.jsp">县级列表</a></span></li>
						<li><span><a title="admin/region/provinceList.jsp">街道列表</a></span></li>
					</ul>
			    </div>
			    
			    <div title="个人中心" data-options="iconCls:'icon-print'">
			    	<ul id="region-tree" class="easyui-tree">
						<li><span><a title="">信息修改</a></span></li>
					</ul>
			    </div>
			</div>
	    </div>
	    
	    <div id="center-layout" data-options="region:'center',title:''">
		    <div id="center-tabs" class="easyui-tabs" data-options="fit:true">
				<div title="首页">
					<h1 style="padding:20px;">人才服务社交平台</h1>
					<div class="loginInfo">
						<%
							String time = (String) OAUtils.fromSession("lastlogintime") ;
							String ip = (String) OAUtils.fromSession("lastloginip") ;
							
							out.print("上次登录时间： "+time+"<br/>") ;
							out.print("上次登录IP： "+ip) ;
						%>
					</div>
				</div>
			</div>
	    </div>
	    
	</body>
</html>

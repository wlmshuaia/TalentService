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
    
    <title>后台管理系统</title>
    
    <script type="text/javascript">
    	
    	// 各种 tab 的数据项
    	var tableData = {
    		// 用户列表
    		userList: [[
				{field:'username',title:'用户名',width:100},
  	        	{field:'type',title:'用户类型',width:100},
  	        	{field:'user_id',title:'用户角色ID',width:100}
			]],
 			projectList: [[
				{field:'title',title:'标题',width:100},
				{field:'category_id',title:'分类',width:100},
				{field:'description',title:'描述',width:100},
				{field:'budget',title:'预算',width:100},
				{field:'phone',title:'电话',width:100},
				{field:'mail',title:'邮箱',width:100},
				{field:'biddingend',title:'竞标结束',width:65},
				{field:'projectend',title:'项目结束',width:65},
				{field:'foundtime',title:'发布日期',width:65},
				{field:'founder_id',title:'发布人',width:50},
				{field:'undertaketime',title:'承接日期',width:65},
				{field:'undertaker_id',title:'承接人',width:50},
				{field:'approvetime',title:'审核时间',width:65},
				{field:'status',title:'状态',width:50}
 			]],
 			circleList:[[
				{field:'circlename',title:'圈子名称',width:100},
				{field:'description',title:'圈子描述',width:300},
				{field:'category_id',title:'所属分类',width:100},
				{field:'founder_id',title:'创建者',width:100},
				{field:'foundtime',title:'创建时间',width:100},
 			]],
 			categoryList:[[
				{field:'catename',title:'分类名称',width:100},
				{field:'description',title:'分类描述',width:300},
 			]],
 			labelList:[[
				{field:'labelname',title:'标签名称',width:100},
 			]],
 			provinceList:[[
				{field:'provincename',title:'省级、直辖市',width:100, sortable: true},
			]],
			cityList:[[
				{field:'cityname',title:'市级名称',width:100,},
 			]],
 			countyList:[[
				{field:'countyname',title:'县级名称',width:100},
 			]],
 			streetList:[[
				{field:'streetname',title:'街道名称',width:100},
 			]],
    	};
    	
    	// 工具栏
		var toolbar = [{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				//var arr = $("#center-tabs").tabs('getSelected').panel('options').title;//.get(0);//.datagrid('getSelections');
				//var arr = $("#center-tabs").tabs('getSelected').getPanel();//.get(0);//.datagrid('getSelections');
				
				
			}
		},{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){
				$.messager.alert('edit', '修改');
			}
		},{
			text:'删除',
			iconCls:'icon-cancel',
			handler:function(){
				var pl = $('#provinceList').datagrid('getSelections');
				
				if(pl.length <= 0){
					$.messager.show({
						titlt: '提示信息',
						msg: '请至少选择一行数据'
					});
				}else{
					
					$.messager.confirm('提示信息', '确认删除？', function(r){
						if(r){
							var ids = "" ;
							for(var i = 0; i < pl.length; i ++){
								ids += pl[i].id+",";
							}
							ids = ids.substring(0, ids.length-1);
							
							//$.messager.alert('ids', ids) ;
							
							$.post('/TalentService/province/provinceAction!delete.action', {ids: ids}, function(result){
								$('#provinceList').datagrid('reload');
								$.messager.show({
									title: '提示信息',
									msg: '操作成功！ '+pl.length+'条记录被删除'
								});
							});
						}else{
							return ;
						}
					});
					
				}
			}
		}, '-',{
			text:'详细信息',
			iconCls:'icon-search',
			handler:function(){
				var pl = $('#provinceList').datagrid('getSelections');
				
				if(pl.length != 1){
					$.messager.show({
						title: '提示信息',
						msg: '请选择一行数据'
					});
				}else{
					
					$.messager.show({
						title: '信息',
						msg: pl[0].id
					});
					handler: addTab('详细信息', '/TalentService/city/cityAction!list.action', 'cityList') ;
				}
			}
		}];
    	
    	// 动态添加 tab
	    function addTab(title, url, componentName){
	    	if ($('#center-tabs').tabs('exists', title)){
	    		$('#center-tabs').tabs('select', title);
	    	} else {
	    		//var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"><table id="'+componentName+'"></table></iframe>';
	    		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	    		$('#center-tabs').tabs('add',{
	    			title:title,
	    			content:content,
	    			closable:true,
	    		});
	    		
	    		var currentTabPanel = $("#center-tabs").tabs('getSelected');
	    	    var dynamicTable = $('<table id="'+componentName+'"></table>');
	    	    //这里一定要先添加到currentTabPanel中，因为dynamicTable.datagrid()函数需要调用到parent函数
	    	    //$.messager.alert('click', tableData[componentName]) ;
	    	    currentTabPanel.html(dynamicTable);
	    	    dynamicTable.datagrid({
	    	    	idField: 'id',
	    	    	loadFilter:pagerFilter,
	    	    	fit: true,
	    	        //rownumbers: true,
					autoRowHeight: false,
					pagination: true,
					nowrap: true,//设置为true，当数据长度超出列宽时将会自动截取  
		            striped: true,//设置为true将交替显示行背景。 
					url: url,
					frozenColumns: [[{
			           field: 'ck',
			           checkbox: true,
			           checkOnSelect: true
			       	}]],
					method:'get',
					toolbar:toolbar,
					pageSize:5,
					pageList: [5, 10, 15, 20, 25],
					columns: tableData[componentName],
	    	    });
	    	}
	    }
    	
    	// datagrid, 分页操作
		function pagerFilter(data){
			if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
				data = {
					total: data.length,
					rows: data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNum, pageSize){
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh',{
						pageNumber:pageNum,
						pageSize:pageSize
					});
					dg.datagrid('loadData',data);
				}
			});
			if (!data.originalRows){
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
			var end = start + parseInt(opts.pageSize);
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}
    	
    	// 加载完成后执行
		$(function(){
			$('#dg').datagrid({loadFilter:pagerFilter});
		});
		
    </script>
    
    <style type="text/css">
    	#north-layout {height:70px;background:#075281;}
	    #admin-info {float:right;margin:-30px 150px 0 0 ;color:white}
	    #quit-btn {clear: both; float: right; display: inline-block; color: red; margin: -5px 0 0 10px;}
	    
	    #south-layout {height:100px;padding-left:10px;}
	    
	    #west-layout {width:200px;}
	    #menu-accordion {width:auto;height:auto;}
	    
	    #center-layout {padding:5px;background:#eee;}
	    #center-tabs {width:400px;height:350px;}
    </style>
    
  </head>
  	<body class="easyui-layout">   
	    <div id="north-layout" data-options="region:'north',title:'',split:true,collapsible:false">
	    	<h1><font color=white size=5>&nbsp;&nbsp;&nbsp;&nbsp;后台管理系统</font></h1>
	    	<div id="admin-info">
	    		<font><b>欢迎您：<span id="admin">管理员</span></b></font>
	    		<a id="quit-btn" href="#" class="easyui-linkbutton" data-options="plain:true"><b>退出</b></a>
	    	</div>
	    </div>
	      
	    <div id="south-layout" data-options="region:'south',title:'Copyright',split:true">
	    	<p>TNT团队制作</p>
	    </div>
	    
	    <div id="west-layout" data-options="region:'west',title:'业务导航',split:true">
	    	<div id="menu-accordion" class="easyui-accordion" data-options="fit:true">
			    <div title="用户管理" data-options="iconCls:'icon-search'">
			         <ul id="user-tree" class="easyui-tree">
						<li><span><a onclick="addTab('用户列表','auser/auserAction!list.action', 'userList')">用户列表</a></span></li>
						<li><span><a onclick="addTab('添加用户','http://www.baidu.com', 'userAdd')">添加用户</a></span></li>
					</ul>
			    </div>
			    
			    <div title="项目管理" data-options="iconCls:'icon-save'">
			    	<ul id="project-tree" class="easyui-tree">
						<li><span><a onclick="addTab('项目列表','aproject/aprojectAction!list.action', 'projectList')">项目列表</a></span></li>
						<li><span>添加项目</span></li>
					</ul>
			    </div>
			    
			    <div title="圈子管理" data-options="iconCls:'icon-sum'">
			    	<ul id="circle-tree" class="easyui-tree">
						<li><span><a onclick="addTab('圈子列表','acircle/acircleAction!list.action', 'circleList')">圈子列表</a></span></li>
						<li><span>添加圈子</span></li>
					</ul>
			    </div>
			    
			    
			    <div title="分类管理" data-options="iconCls:'icon-save'">
			    	<ul id="category-tree" class="easyui-tree">
						<li><span><a onclick="addTab('分类列表','category/categoryAction!list.action', 'categoryList')">分类列表</a></span></li>
						<li><span>添加分类</span></li>
					</ul>
			    </div>
			    
			    <div title="标签管理" data-options="iconCls:'icon-save'">
			    	<ul id="label-tree" class="easyui-tree">
						<li><span><a onclick="addTab('标签列表','label/labelAction!list.action', 'labelList')">标签列表</a></span></li>
						<li><span>添加标签</span></li>
					</ul>
			    </div>
			    
			    <div title="地区管理" data-options="selected:true,iconCls:'icon-save'">
			    	<ul id="region-tree" class="easyui-tree">
						<li><span><a onclick="addTab('省级列表','province/provinceAction!list.action', 'provinceList')">省级列表</a></span></li>
					</ul>
			    </div>
			    
			    <div title="流程管理" data-options="selected:true,iconCls:'icon-save'">
			    	<ul id="region-tree" class="easyui-tree">
						<li><span><a onclick="addTab('省级列表','workflow/workflowAction!list.action', 'workflowList')">流程列表</a></span></li>
						<li><span><a onclick="addTab('省级列表','workflow/workflowAction!list.action', 'provinceAdd')">流程部署</a></span></li>
					</ul>
			    </div>
			    
			    <div title="其他业务" data-options="iconCls:'icon-print'">
			    	
			    </div>
			</div>
	    </div>
	    
	    <div id="center-layout" data-options="region:'center',title:''">
		    <div id="center-tabs" class="easyui-tabs" data-options="fit:true">
				<div title="首页">
					<h1 style="padding:20px;">人才服务社交平台</h1>
					<%--<table id="dg" title="用户列表" style="width:700px;height:370px" data-options="
						rownumbers:true,
						singleSelect:true,
						autoRowHeight:false,
						pagination:true,
						url:'/TalentService/user/userAction!list.action',
						method:'get',
						toolbar:toolbar,
						pageSize:10">
					<thead>
						<tr>
							<th field="username" width="100">用户姓名</th>
							<th field="type" width="100">用户类型</th>
							<th field="user_id" width="100">用户角色ID</th>
						</tr>
					</thead>
				</table>
				--%></div>
			</div>
	    </div>
	    
	</body>
</html>

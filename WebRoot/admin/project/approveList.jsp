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
    
    <title>项目审核列表</title>
	
	<script type="text/javascript">
		
		var toolbar = [{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				
			}
		},{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){
				
			}
		},{
			text:'删除',
			iconCls:'icon-cancel',
			//handler: deleteHandler($('#dataList'), "aproject/aprojectAction!delete.action")
			handler: function() {
				
				var rows = $('#dataList').datagrid('getSelections');
				
				if(rows.length < 1){
					infoTip('请选择要删除的数据！') ;
				}else{
					
					$.messager.confirm('确认','您确认想要删除吗？',function(r){    
					    if (r){
					    	var ids = [];
					    	for(var i = 0; i < rows.length; i ++){
								ids.push(rows[i].id);
							}
					    	
							$.post("aproject/aprojectAction!delete.action?ids="+ids, function(result){
								var data = eval('(' + result + ')');
								if(data.status == "success"){
									$('#dataList').datagrid('reload') ;			// 重新加载
									$('#dataList').datagrid('unselectAll') ;	// 取消选中，防止 idField 缓存
									infoTip(data.message) ;
								}else{
									infoTip('删除失败') ;
								}
							});
					    }
					});
					
				}
			}
		}, {
			text:'详细信息',
			iconCls:'icon-search',
			handler:function(){alert('查看')}
		}, '-', {
			text:'审核通过',
			iconCls:'icon-search',
			handler:function(){
				var rows = $('#dataList').datagrid('getSelections') ;
				if(rows.length != 1){
					infoTip('请选择一条数据') ;
				} else {
					
					$.messager.confirm('确认','您确认要审批通过吗？',function(r){    
					    if (r){
							$.post("aproject/aprojectAction_approve.action?isApprove=pass&taskId="+rows[0].taskId+"&pid="+rows[0].id, function(result){
								var data = eval('(' + result + ')');
								if(data.status == "success"){
									$('#dataList').datagrid('reload') ;			// 重新加载
									$('#dataList').datagrid('unselectAll') ;	// 取消选中，防止 idField 缓存
									infoTip(data.message) ;
								}else{
									infoTip('审批失败') ;
								}
							});
					    }
					});
				}
			}
		}, {
			text:'审核不通过',
			iconCls:'icon-search',
			handler:function(){
				var rows = $('#dataList').datagrid('getSelections') ;
				if(rows.length != 1){
					infoTip('请选择一条数据') ;
				} else {
					$('#myDialog').dialog({
						title: '填写理由'
					});
					
					$('#myDialog').dialog('open') ;
					
					var taskId = rows[0].taskId ;
					var pid = rows[0].id ;
					$('input[name=taskId]').attr('value', taskId);
					$('input[name=pid]').attr('value', pid);
				}
			}
		}];
		
		$(function(){
			
			$('#dataList').datagrid({
				idField: 'id',
    	    	loadFilter:pagerFilter,
    	    	fit: true,
    	        //rownumbers: true,
				autoRowHeight: false,
				pagination: true,
				nowrap: true,//设置为true，当数据长度超出列宽时将会自动截取  
	            striped: true,//设置为true将交替显示行背景。 
				url: "aproject/aprojectAction!approveList.action",
				frozenColumns: [[{
		           field: 'ck',
		           checkbox: true,
		           checkOnSelect: true
		       	}]],
				method:'get',
				toolbar: toolbar,
				pageSize: 15,
				pageList: [10, 15, 20, 25],
				columns: tableData["projectList"],
			});
			
			$('#btn1').click(function(){
				$('#myForm').form('submit', {
				    success: function(result){
				    	// 关闭数据表格
				    	$('#myDialog').dialog('close');
				    	// 重新加载当前页面
				    	$('#dataList').datagrid('reload');
				        // 显示提示信息
				    	var data = eval('(' + result + ')');  // change the JSON string to javascript object    
				        titleTip(data.status, data.message) ;
				    }
				})
			});
			
			$('#btn2').click(function(){
				$('#myDialog').dialog('close') ;
			});
			
		});
		
	</script>

  </head>
  
  <body>
  
    <table id="dataList"></table>
    
    <div id="myDialog" class="easyui-dialog" modal=true closed=true style="width:300px;">
    	<form id="myForm" action="aproject/aprojectAction_approve.action?isApprove=unpass" method="post">
    		<input type="hidden" name="taskId" value="" />
    		<input type="hidden" name="pid" value="" />
			<div class="form-contain">
				<div>审批意见:</div>
				<input name="content" class="easyui-textbox" data-options="prompt:'Enter description...', multiline:true, required:true" style="width:100%;height:100px;">
			</div>
			<a id="btn1" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
			<a id="btn2" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    	</form>
    </div>
	
  </body>
</html>

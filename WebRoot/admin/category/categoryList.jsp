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
    
    <title>分类列表</title>
	
	<script type="text/javascript">
		
		var flag ;	// 全局变量，标识是新增还是修改
		
		var toolbar = [{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				flag = 'add' ;	// 添加分类标识
				
				$('#myDialog').dialog({
					title: '添加分类'
				});
				// 清空数据
				$('#myForm').form('reset') ;
				//$('#myForm').get(0).reset() ;
				//$('#myForm').find("input").val("");
				
				// 禁用验证
				$('#myForm').form('disableValidation') ;
				
				// 打开 dialog
				$('#myDialog').dialog('open') ;
			}
		},{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){
				flag = 'edit' ;	// 修改分类标识
				
				var ids = [];
				var rows = $('#dataList').datagrid('getSelections');
				if(rows.length != 1){
					infoTip('请选择一行数据') ;
				}else{
					$('#myDialog').dialog({
						title: '分类修改'
					});
					$('#myDialog').dialog('open') ;	// 打开 dialog
					$('#myForm').get(0).reset() ;	// 重置
					$('#myForm').form('load', {		// load 数据
						cid: rows[0].id, 
						catename: rows[0].catename,
						description: rows[0].description,
					}) ;
				}
			}
		},{
			text:'删除',
			iconCls:'icon-cancel',
			handler:function(){
				var ids = [];
				var rows = $('#dataList').datagrid('getSelections');
				
				if(rows.length < 1){
					infoTip('请选择要删除的数据！') ;
				}else{
					
					$.messager.confirm('确认','您确认想要删除吗？',function(r){    
					    if (r){
					    	for(var i = 0; i < rows.length; i ++){
								ids.push(rows[i].id);
							}
							
							$.post("acategory/acategoryAction!delete.action?ids="+ids, function(result){
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
		},'-', {
			text:'详细信息',
			iconCls:'icon-search',
			handler:function(){alert('查看')}
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
				url: 'acategory/acategoryAction!list.action',
				frozenColumns: [[{
		           field: 'ck',
		           checkbox: true,
		           checkOnSelect: true
		       	}]],
				toolbar: toolbar,
				pageSize: 10,
				pageList: [5, 10, 15, 20, 25],
				columns: tableData["categoryList"],
			});
			
			// 确定按钮
			$('#btn1').click(function(){
				if($('#myForm').form('enableValidation').form('validate')){
					
					$.ajax({
						type: 'post',
						url: flag == 'add' ? 'acategory/acategoryAction_add.action' : 'acategory/acategoryAction_update.action',
						cache: false ,
						data: $('#myForm').serialize(),
						dataType: 'json',
						success: function(result) {
							// 关闭数据表格
					    	$('#myDialog').dialog('close');
					    	// 重新加载当前页面
					    	$('#dataList').datagrid('reload');
					        // 显示提示信息
					    	var data = eval('(' + result + ')');  // change the JSON string to javascript object    
					        titleTip(data.status, data.message) ;
						},
						error: function(result) {
							var data = eval('(' + result + ')');  // change the JSON string to javascript object    
					        titleTip(data.status, data.message) ;
						}
					});
					/*
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
					});*/
				}else{
					infoTip("数据验证不通过，不能保存") ;
				}
			});
			
			// 关闭按钮
			$('#btn2').click(function(){
				$('#myDialog').dialog('close');
			});
			
		});
		
	</script>

  </head>
 
  <body>
  
    <table id="dataList"></table>
    
    <div id="myDialog" title="添加分类" class="easyui-dialog" closed=true modal=true >
    	<form id="myForm" action="acategory/acategoryAction_add.action" method="post" class="easyui-form" data-options="novalidate:true">
    		<input type="hidden" name="cid" value="" />
			<div class="form-contain">
				<div>分类名称:</div>
				<input name="catename" class="easyui-textbox" data-options="prompt:'Enter a catename...', required:true" style="width:100%;height:32px;">
			</div>
			<div class="form-contain">
				<div>分类描述:</div>
				<input name="description" class="easyui-textbox" data-options="prompt:'Enter description...', multiline:true, required:true" style="width:100%;height:100px;">
			</div>
			<a id="btn1" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
			<a id="btn2" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    	</form>
    </div>
	
  </body>
</html>

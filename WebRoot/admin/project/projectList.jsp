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
				url: 'aproject/aprojectAction!list.action?status=bidding',
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
			
		});
		
		
	</script>

  </head>
  
  <body>
  
    <table id="dataList"></table>
    
    <div id="myDialog" class="easyui-dialog" modal=true closed=true style="width:300px;">
    	<form id="myForm" action="" method="post">
    		
    	</form>
    </div>
	
  </body>
</html>

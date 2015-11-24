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
    
    <title>流程列表</title>
	
	<script type="text/javascript">
		var toolbar = [{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
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
			handler:function(){alert('修改')}
		},{
			text:'删除',
			iconCls:'icon-cancel',
			handler:function(){
				$.messager.confirm('确认','您确认想要删除吗？',function(r){    
				    if (r){
				    	var rows = $('#dataList').datagrid('getSelections');
				    	var ids = [] ;
				    	for(var i = 0; i < rows.length; i ++){
							ids.push(rows[i].key);
						}
				    	
				    	$.post('aworkflow/aworkflowAction_delete?ids='+ids, function(result){
				    		var data = eval('(' + result + ')');
				    		if(data.status == "success"){
				    			$('#dataList').datagrid('reload') ;
				    			$('#dataList').datagrid('unselectAll') ;	// 取消选中
					    		infoTip(data.message) ; // 提示信息
				    		}else{
				    			infoTip('删除失败') ;
				    		}
				    	});
				    }
				});
				
			}
		},'-', {
			text:'查看流程定义',
			iconCls:'icon-search',
			handler:function(){
				var rows = $('#dataList').datagrid('getSelections');
				if(rows.length != 1){
					infoTip('请选择一行数据') ;
				}else{
					var url = 'aworkflow/aworkflowAction_showImage?deploymentId='+rows[0].deploymentId ;
					window.open(url, 300, 200) ;	// 打开流程定义图片
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
				url: 'aworkflow/aworkflowAction!list.action',
				frozenColumns: [[{
		           field: 'ck',
		           checkbox: true,
		           checkOnSelect: true
		       	}]],
				method:'get',
				toolbar: toolbar,
				pageSize: 10,
				pageList: [10, 15, 20, 25],
				columns: tableData["pdList"],
			});
			
			$('#btn1').click(function(){
				if($('#myForm').form('validate')){
					$('#myForm').form('submit', {
					    success: function(result){
					    	$('#myDialog').dialog('close');
					    	$('#dataList').datagrid('reload');
					        var data = eval('(' + result + ')');  // change the JSON string to javascript object    
					        titleTip(data.status, data.message) ;
					    }    
					});
					
				}else{
					infoTip("数据验证不通过，不能保存") ;
				}
			});
			
			$('#btn2').click(function(){
				$('#myDialog').dialog('close');
			});
		});
		
	</script>

  </head>
  
  <body>
  
    <table id="dataList"></table>
    
    <div id="myDialog" title="上传流程定义文档" class="easyui-dialog" modal=true closed=true style="width:320px;">
    	<form id="myForm" action="aworkflow/aworkflowAction_deploy.action" method="post" enctype="multipart/form-data">
    		<table>
    			<tr align="center">
    				<td colspan="2">
    					<input id="deploy" name="deploy" class="easyui-filebox" data-options="prompt:'Choose a file...', required:true" style="width:250px" />(zip)
    				</td>
    			</tr>
    			<tr align="center">
    				<td colspan="2">
    					<a id="btn1" class="easyui-linkbutton" iconCls=icon-ok >确定</a>
    					<a id="btn2" class="easyui-linkbutton" iconCls=icon-cancel >取消</a>
    				</td>
    			</tr>
    		</table>
    	</form>
    </div>
	
  </body>
</html>

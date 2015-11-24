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
    
    <title>节点列表</title>
	
	<script type="text/javascript">
		var toolbar = [{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
			}
		},{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){alert('修改')}
		},{
			text:'删除',
			iconCls:'icon-cancel',
			handler:function(){alert('删除')}
		},'-', {
			text:'详细信息',
			iconCls:'icon-search',
			handler:function(){alert('查看')}
		}];
		
		$(function(){
			
			$('#userList').datagrid({
				idField: 'id',
    	    	loadFilter:pagerFilter,
    	    	fit: true,
    	        //rownumbers: true,
				autoRowHeight: false,
				pagination: true,
				nowrap: true,//设置为true，当数据长度超出列宽时将会自动截取  
	            striped: true,//设置为true将交替显示行背景。 
				url: 'rbac/rbacAction!nodeList.action',
				frozenColumns: [[{
		           field: 'ck',
		           checkbox: true,
		           checkOnSelect: true
		       	}]],
				method:'get',
				toolbar: toolbar,
				pageSize: 10,
				pageList: [10, 15, 20, 25],
				columns: tableData["nodeList"],
			});
		});
		
	</script>

  </head>
  
  <body>
  
    <table id="userList"></table>
    
    <div id="userDialog" class="easyui-dialog" modal=true closed=true style="width:300px;">
    	<form id="userForm" action="" method="post">
    		<table>
    			<tr>
    				<td>用户名：</td>
    				<td><input type="text" name="username" class="easyui-validatebox" required=true validType="midLength[2, 5]" missingMessage="用户名不能为空" /></td>
    			</tr>
    			<tr>
    				<td>邮箱：</td>
    				<td><input name="email"class="easyui-validatebox" data-options="required:true,validType:'email'" missingMessage="邮箱不能为空" /></td>
    			</tr>
    			<tr>
    				<td>密码：</td>
    				<td><input type="password" name="password" class="easyui-validatebox" required=true missingMessage="密码不能为空" /></td>
    			</tr>
    			<tr>
    				<td>确认密码：</td>
    				<td><input type="password" name="passwordConfirm" class="easyui-validatebox" required=true validType="equals['#password']" missingMessage="确认密码不能为空" /></td>
    			</tr>
    			<tr>
    				<td>类型：</td>
    				<td>
    					<select id="cc" class="easyui-combobox" name="type" required=true missingMessage="类型不能为空" style="width:175px;">
						   	<option value="0">在校学生</option>
							<option value="1">在职员工</option>
							<option value="2">各大高校</option>
							<option value="3">社会企业</option>
						</select>
					</td>
    			</tr>
    			<tr align="center">
    				<td colspan="2">
    					<a id="btn" class="easyui-linkbutton">确定</a>
    				</td>
    			</tr>
    		</table>
    	</form>
    </div>
	
  </body>
</html>

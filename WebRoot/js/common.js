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

/**
 * 显示提示信息
 * @param text
 */
function infoTip(text) {
	$.messager.show({
		title: '提示信息',
		msg: text
	});
}

/**
 * 显示标题和提示信息
 * @param title
 * @param text
 */
function titleTip(title, text) {
	$.messager.show({
		title: title,
		msg: text
	});
}

/**
 * 工具栏 handler
 */
//var toolbarHandler = {
	function deleteHandler(obj, url){
		var ids = [];
		var rows = obj.datagrid('getSelections');
		
		if(rows.length < 1){
			infoTip('请选择要删除的数据！') ;
		}else{
			
			$.messager.confirm('确认','您确认想要删除吗？',function(r){    
			    if (r){
			    	for(var i = 0; i < rows.length; i ++){
						ids.push(rows[i].id);
					}
					
					$.post(url+"?ids="+ids, function(result){
						var data = eval('(' + result + ')');
						if(data.status == "success"){
							obj.datagrid('reload') ;
							infoTip(data.message) ;
						}else{
							infoTip('删除失败') ;
						}
					});
			    }
			});
			
		}
	}
//};



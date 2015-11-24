// 各种 tab 的数据项
var tableData = {
	// 用户列表
	userList: [[
	    {field:'id',title:'ID',width:100, hidden: true},
		{field:'username',title:'用户名',width:100},
    	{field:'type',title:'用户类型',width:100},
    	{field:'user_id',title:'用户角色ID',width:100}
	]],
	projectList: [[
        {field:'id',title:'ID',width:100, hidden: true},
        {field:'taskId',title:'taskId',width:100, hidden: true},
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
	    {field:'id',title:'ID',width:100, hidden: true},         
		{field:'circlename',title:'圈子名称',width:100},
		{field:'description',title:'圈子描述',width:300},
		{field:'category_id',title:'所属分类',width:100},
		{field:'founder_id',title:'创建者',width:100},
		{field:'foundtime',title:'创建时间',width:100},
	]],
	categoryList:[[
	    {field:'id',title:'ID',width:100, hidden: true},
		{field:'catename',title:'分类名称',width:100},
		{field:'description',title:'分类描述',width:300},
	]],
	labelList:[[
	    {field:'id',title:'ID',width:100, hidden: true},
		{field:'labelname',title:'标签名称',width:100},
	]],
	provinceList:[[
	    {field:'id',title:'ID',width:100, hidden: true},
		{field:'provincename',title:'省级、直辖市',width:100, sortable: true},
	]],
	cityList:[[
	    {field:'id',title:'ID',width:100, hidden: true},
		{field:'cityname',title:'市级名称',width:100,},
	]],
	countyList:[[
	    {field:'id',title:'ID',width:100, hidden: true},
		{field:'countyname',title:'县级名称',width:100},
	]],
	streetList:[[
        {field:'id',title:'ID',width:100, hidden: true},
		{field:'streetname',title:'街道名称',width:100},
	]],
	pdList: [[
	    {field:'id',title:'ID',width:100, hidden: true},
	  	{field:'deploymentId',title:'deploymentId',width:100, hidden: true},
	  	{field:'key',title:'key',width:100, hidden: true},
	    {field:'name',title:'流程名称',width:100},
	    {field:'version',title:'最新版本',width:300},
	]],
	roleList: [[
  	    {field:'id',title:'ID',width:100, hidden: true},
  	  	{field:'rolename',title:'角色名称',width:100},
  	    {field:'remark',title:'中文描述',width:300},
  	    {field:'status',title:'是否开启',width:300},
	]],
  	roleUserList: [[
  	    {field:'id',title:'ID',width:100, hidden: true},
  	  	{field:'adminname',title:'后台用户名称',width:100},
  	  	{field:'lastlogintime',title:'上次登录时间',width:100, hidden: true},
  	    {field:'lastloginip',title:'上次登录IP',width:100},
  	]],
  	nodeList: [[
  	    {field:'id',title:'ID',width:100, hidden: true},
  	  	{field:'nodename',title:'权限名称',width:100},
  	  	{field:'remark',title:'权限描述',width:100, hidden: true},
  	    {field:'title',title:'跳转地址',width:100},
  	    {field:'status',title:'是否开启',width:300},
  	    {field:'sort',title:'排序',width:300},
  	    {field:'pid',title:'父级',width:300},
  	]],
};


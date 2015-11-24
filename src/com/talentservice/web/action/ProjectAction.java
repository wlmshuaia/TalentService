package com.talentservice.web.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Bid;
import com.talentservice.domain.Category;
import com.talentservice.domain.Chat;
import com.talentservice.domain.Group;
import com.talentservice.domain.GroupUser;
import com.talentservice.domain.Project;
import com.talentservice.domain.Projectlog;
import com.talentservice.domain.User;
import com.talentservice.ikanalyzer.LuceneDao;
import com.talentservice.service.WorkflowManager;
import com.talentservice.utils.DataUtils;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.OAUtils;
import com.talentservice.utils.SelectDataUtils;
import com.talentservice.utils.UploadUtils;
import com.talentservice.vo.ProjectView;
import com.talentservice.vo.SelectData;

@Controller("projectAction")
@Scope("prototype")
public class ProjectAction extends BaseAction {
	
	private static final long serialVersionUID = 6206984819789171565L;

	private Project project = new Project() ;
	
	@Resource(name="workflowManager")
	private WorkflowManager workflowManager ;
	
	/* 附件上传 */
	private File[] upload ;
	private String[] uploadFileName ;
	private String[] uploadContentType ;
	
	/* 下载  */
	private InputStream inputStream ;
	private String fid ;
	
	private String category_id ;	// 分类
	
	/* 分页 */
	private String start ;
	
	// 任务 ID
	private String taskId ;
	
	// 团队 ID
	private String gid ;
	
	// 搜索字段
	private String field ;
	
	/**
	 * 前台项目数据列表
	 * @return
	 */
	public String dataList() {
		
		if("".equals(start) || start == null){
			start = "1" ;
		}
		
		int sqlStart = (Integer.parseInt(start) - 1) * DataUtils.DATA_NUM ;
		List<Project> projectList = (List<Project>) baseService.getByPage(Project.class, " and status != '审核中' ", sqlStart, DataUtils.DATA_NUM) ;
		
		int count = this.baseService.getCount(Project.class, " and status != '审核中'") ;
		int end =  count%DataUtils.DATA_NUM == 0 ? count/DataUtils.DATA_NUM : (count/DataUtils.DATA_NUM+1) ;	// 最后一页
		int page = Integer.parseInt(start) ;
		
		if(page-3 >= 1) {
			start = String.valueOf(page - 2);
		}else{
			start = "1" ;
		}
		
		String endPage = "" ;
		if(page + 3 <= end){
			endPage = String.valueOf(page + 2) ;
		}else{
			endPage = String.valueOf(end) ;
		}
		
		List<Category> cateList = (List<Category>) this.baseService.getAll(Category.class) ;
		List<com.talentservice.domain.Label> labelList= (List<com.talentservice.domain.Label>) this.baseService.getAll(com.talentservice.domain.Label.class) ;
		List<SelectData> sdList = SelectDataUtils.getBudgetData() ;
		
		ActionContext.getContext().put("start", start) ;	// 开始页
		ActionContext.getContext().put("end", endPage) ;	// 结束页
		ActionContext.getContext().put("page", page) ;		// 当前页
		ActionContext.getContext().put("count", count) ;		// 当前页
		ActionContext.getContext().put("dataList", projectList) ;	// 数据列表
		ActionContext.getContext().put("cateList", cateList) ;
		ActionContext.getContext().put("labelList", labelList) ;
		ActionContext.getContext().put("sdList", sdList) ;
		
		return listAction ;
	}
	
	/**
	 * 前台项目详情
	 * @return
	 * @throws ParseException 
	 */
	public String getInfo() throws ParseException {
		
		Project p = (Project) this.baseService.getById(Project.class, project.getPid()) ;
		//List<com.talentservice.domain.File> files = (List<com.talentservice.domain.File>) this.baseService.queryByHql("from File where project_id = "+project.getPid());
		List<com.talentservice.domain.File> files = (List<com.talentservice.domain.File>)this.baseService.getListById(com.talentservice.domain.File.class, "project_id", project.getPid()) ;
		List<Projectlog> plList = (List<Projectlog>) this.baseService.getListById(Projectlog.class, "project_id", project.getPid()) ;
		List<Bid> bidList = (List<Bid>) this.baseService.getListById(Bid.class, "project_id", project.getPid()) ;
		
		// 计算时间戳差
		long timestamp = DateUtils.getTimestamp(p.getFoundtime(), p.getBiddingend()) ;
		
		for(com.talentservice.domain.File f : files){
			System.out.println(f.getFilename());
		}
		
		ActionContext.getContext().put("data", p) ;
		ActionContext.getContext().put("files", files) ;
		ActionContext.getContext().put("projectlogList", plList) ;
		ActionContext.getContext().put("bidList", bidList) ;
		ActionContext.getContext().put("timestamp", timestamp) ;
		
		return getInfo ;
	}
	
	/**
	 * 发包方项目数据列表
	 * @return
	 */
	public String personalProjectList() {
		User user = (User) OAUtils.fromSession("user") ;
		if(user != null){
			//List<Project> projectList = (List<Project>) this.baseService.getByPage(Project.class, " and founder_id = '"+user.getUid()+"'", 0, DataUtils.DATA_NUM);
			int count = this.baseService.getCount(Project.class, "") ;
			//List<Project> projectList = (List<Project>) this.baseService.getByPage(Project.class, " and founder_id = '"+user.getUid()+"'", 0, count);
			
			List<ProjectView> projectList = new ArrayList<ProjectView>() ;
			List<Task> taskList = this.workflowManager.getTaskListByAssignee(user.getUsername()) ;
			for(Task t : taskList){
				Set<String> variableNames = this.workflowManager.getVariablesNames(t.getExecutionId()) ;
	    		Map<String, Object> map = this.workflowManager.getVariableByName(t.getExecutionId(), variableNames) ;
	    		
	    		Project p = null ;
	    		for(Entry<String, Object> entry : map.entrySet()) {
	    			if("project".equals(entry.getKey())) {
	        			p = (Project) entry.getValue() ;
	    			}
	    		}
	    		
	    		//if(p.getUserByFounderId().getUsername().equals(user.getUsername())){
	    			ProjectView pv = new ProjectView() ;
	    			pv.setProject(p) ;
	    			pv.setTask(t) ;
	    			projectList.add(pv) ;
	    		//}
			}
			
			ActionContext.getContext().put("dataList", projectList) ;
			ActionContext.getContext().put("bidList", projectList) ;
			return "personalProjectList" ;
		}else{
			return ERROR ;
		}
	}
	
	/**
	 * 发包方项目数据详情
	 * 
	 * @return
	 */
	public String personalProjectInfo() {
		Project p = (Project) this.baseService.getById(Project.class, project.getPid()) ;
		List<Projectlog> plList = (List<Projectlog>) this.baseService.getListById(Projectlog.class, "project_id", project.getPid()) ;
		List<Bid> bidList = (List<Bid>) this.baseService.getListById(Bid.class, "project_id", project.getPid()) ;
		Task task = this.workflowManager.getTaskByTaskId(taskId);
		
		ActionContext.getContext().put("data", p) ;
		ActionContext.getContext().put("task", task) ;
		ActionContext.getContext().put("projectlogLatest", plList.get(plList.size()-1)) ;
		ActionContext.getContext().put("bidList", bidList) ;
		return "personalProjectInfo" ;
	}
	
	/**
	 * 接包方项目数据列表
	 * 
	 * @return
	 */
	public String bidderProjectList() {
		User user = (User) OAUtils.fromSession("user") ;
		if(user != null){
			//List<Project> projectList = (List<Project>) this.baseService.getByPage(Project.class, " and founder_id = '"+user.getUid()+"'", 0, DataUtils.DATA_NUM);
			int count = this.baseService.getCount(Project.class, "") ;
			//List<Project> projectList = (List<Project>) this.baseService.getByPage(Project.class, " and founder_id = '"+user.getUid()+"'", 0, count);
			
			List<ProjectView> projectList = new ArrayList<ProjectView>() ;
			List<Task> taskList = this.workflowManager.getTaskListByAssignee(user.getUsername()) ;
			for(Task t : taskList){
				Set<String> variableNames = this.workflowManager.getVariablesNames(t.getExecutionId()) ;
	    		Map<String, Object> map = this.workflowManager.getVariableByName(t.getExecutionId(), variableNames) ;
	    		
	    		Project p = null ;
	    		for(Entry<String, Object> entry : map.entrySet()){
	    			if("project".equals(entry.getKey())){
	        			p = (Project) entry.getValue() ;
	    			}
	    		}
	    		
	    		//if(p.getUserByFounderId().getUsername().equals(user.getUsername())){
	    			ProjectView pv = new ProjectView() ;
	    			pv.setProject(p) ;
	    			pv.setTask(t) ;
	    			projectList.add(pv) ;
	    		//}
			}
			
			ActionContext.getContext().put("dataList", projectList) ;
			return "bidderProjectList" ;
		}else{
			return ERROR ;
		}
	}
	
	/**
	 * 发布项目视图页
	 * @return
	 */
	public String addUI(){
		
		List<Category> cateList = (List<Category>) this.baseService.getAll(Category.class) ;
		
		List<SelectData> budget = SelectDataUtils.getBudgetData() ;
		List<SelectData> biddingEnd = SelectDataUtils.getBiddingEndData() ;
		List<SelectData> projectEnd = SelectDataUtils.getProjectEndData() ;
		
		ActionContext.getContext().put("cateList", cateList);
		ActionContext.getContext().put("budget", budget);
		ActionContext.getContext().put("biddingEnd", biddingEnd);
		ActionContext.getContext().put("projectEnd", projectEnd);
		
		return addUI ;
	}
	
	/**
	 * 发布项目表单提交处理
	 * 	* 保存项目基本信息， 返回 实体对象
	 * 		* 获取 founder category foundertime status等信息
	 *  * 保存上传附件，将地址和项目id保存到 file 表中
	 *  * 增加项目日志
	 *  * 启动流程实例
	 *  * 完成当前任务
	 * @return
	 */
	public String add(){
		Project project = new Project() ;
		BeanUtils.copyProperties(this.getModel(), project) ;
		
		/*****************************************************************/
		/* 设置：category, founder, foundertime, status */
		Category category = (Category) this.baseService.getById(Category.class, Long.parseLong(category_id));
		User founder = (User) OAUtils.fromSession("user") ;
		/*
		if(founder == null){	// 登录判断
			return ERROR ;
		}
		*/
		Date foundertime = new Date() ;
		
		project.setCategory(category) ;
		project.setUserByFounderId(founder) ;
		project.setFoundtime(DateUtils.formatDate(foundertime)) ;
		project.setStatus(DataUtils.PROJECT_APPROVE) ;
		
		Project p = (Project) this.baseService.save(project) ;
		/*****************************************************************/
		
		/*****************************************************************/
		if(upload != null){
			for(int i = 0; i < upload.length; i ++){
				String url = UploadUtils.saveUploadFile(getUpload()[i]) ;
				com.talentservice.domain.File f = new com.talentservice.domain.File() ;
				
				f.setUrl(url) ;
				f.setFilename(uploadFileName[i]) ;
				f.setProject(p) ;
				
				this.baseService.save(f) ;
			}
		}
		/*****************************************************************/
		
		/*****************************************************************/
		Projectlog pl = new Projectlog() ;
		pl.setHandle(DataUtils.PROJECT_SUBMIT) ;
		pl.setHandletime(DateUtils.formatDateTime(foundertime)) ;
		pl.setProject(p) ;
		this.baseService.save(pl) ;
		/*****************************************************************/
		
		/*****************************************************************/
		// 启动流程实例, 设置流程变量
		Map<String, Object> variables = new HashMap<String, Object>() ;
		variables.put("project", p) ;
		User user = (User) OAUtils.fromSession("user") ;
		ProcessInstance pi = this.workflowManager.startPIByName(user.getUsername(), variables) ;
		
		// 完成项目发布任务 ==> issue 任务节点
		Task task = this.workflowManager.getTaskByExecutionId(pi.getId()) ;
		this.workflowManager.completeTaskByTaskId(task.getId()) ;
		/*****************************************************************/
		
		return action2action ;
	}
	
	/**
	 * 附件下载
	 * @return
	 * @throws NumberFormatException
	 * @throws FileNotFoundException
	 */
	public String download() throws NumberFormatException, FileNotFoundException {
		this.inputStream = this.baseService.download(Long.parseLong(fid));
		return SUCCESS ;
	}
	
	/**
	 * 团队列表
	 * 
	 * @return
	 */
	public String groupList() {
		// 获取对应的小组
		List<Group> groupList = (List<Group>) this.baseService.getAll(Group.class);
		
		ActionContext.getContext().put("dataList", groupList);
		return "groupList" ;
	}
	
	/**
	 * 在线聊天视图
	 * 
	 * @return
	 */
	public String groupTalkUI() {
		User user = (User) OAUtils.fromSession("user");
		Group group = (Group) this.baseService.getById(Group.class, Long.parseLong(gid));
		List<Chat> chatList = (List<Chat>) this.baseService.getListById(Chat.class, "group_id", Long.parseLong(gid));
		Project project = (Project) this.baseService.getById(Project.class, group.getProject().getPid());
		
		ActionContext.getContext().put("project", project);
		ActionContext.getContext().put("user", user);
		ActionContext.getContext().put("group", group);
		ActionContext.getContext().put("chatList", chatList);
		return "groupTalkUI";
	}
	
	/**
	 * 搜索项目
	 * 
	 * @return
	 */
	public String getSearch() {
		/*
		
		
		int sqlStart = (Integer.parseInt(start) - 1) * DataUtils.DATA_NUM ;
		List<Project> projectList = (List<Project>) baseService.getByPage(Project.class, " and status != '审核中' ", sqlStart, DataUtils.DATA_NUM) ;
		*/
		
		
		List<Category> cateList = (List<Category>) this.baseService.getAll(Category.class) ;
		List<com.talentservice.domain.Label> labelList= (List<com.talentservice.domain.Label>) this.baseService.getAll(com.talentservice.domain.Label.class) ;
		List<SelectData> sdList = SelectDataUtils.getBudgetData() ;
		
		ActionContext.getContext().put("cateList", cateList) ;
		ActionContext.getContext().put("labelList", labelList) ;
		ActionContext.getContext().put("sdList", sdList) ;
		
		LuceneDao luceneProcess = new LuceneDao("F:/index");
        try {
        	List<Project> plist = (List<Project>) this.baseService.getAll(Project.class);
            luceneProcess.createIndex(plist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //查询测试
        String [] fields = {"title"};
        Map<String, Object> val = luceneProcess.search(fields, field) ;
        List<Project> list = (List<Project>) val.get("result") ;
        // 后台输出
        for(int i = 0; i < list.size(); i ++){
            Project project = list.get(i);
            System.out.println("("+project.getPid()+") title: "+project.getTitle()+", description: "+project.getDescription());
        }
        
        if("".equals(start) || start == null){
			start = "1" ;
		}
        int count = (int) val.get("count") ;
        int end =  count%DataUtils.DATA_NUM == 0 ? count/DataUtils.DATA_NUM : (count/DataUtils.DATA_NUM+1) ;	// 最后一页
		int page = Integer.parseInt(start) ;
		
		if(page-3 >= 1) {
			start = String.valueOf(page - 2);
		}else{
			start = "1" ;
		}
		
		String endPage = "" ;
		if(page + 3 <= end){
			endPage = String.valueOf(page + 2) ;
		}else{
			endPage = String.valueOf(end) ;
		}
		
		ActionContext.getContext().put("start", start) ;	// 开始页
		ActionContext.getContext().put("end", endPage) ;	// 结束页
		ActionContext.getContext().put("page", page) ;		// 当前页
        ActionContext.getContext().put("dataList", list);
        ActionContext.getContext().put("count", count);
        
		return "searchResult" ;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public String getStart() {
		return start;
	}
	
	public String getTaskId() {
		return taskId;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public void setStart(String start) {
		this.start = start;
	}
	
	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public Object getModel() {
		return project;
	}
	
}

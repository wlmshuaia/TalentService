package com.talentservice.admin.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jbpm.api.task.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Admin;
import com.talentservice.domain.Approve;
import com.talentservice.domain.Category;
import com.talentservice.domain.File;
import com.talentservice.domain.Project;
import com.talentservice.domain.Projectlog;
import com.talentservice.domain.User;
import com.talentservice.service.WorkflowManager;
import com.talentservice.utils.DataUtils;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.JsonUtils;
import com.talentservice.utils.OAUtils;
import com.talentservice.utils.UploadUtils;

@Component("aprojectAction")
@Scope("prototype")
public class AProjectAction extends BaseAction {
	
	private static final long serialVersionUID = 8611374263167160633L;
	
	private Project project = new Project();
	
	@Resource(name="workflowManager")
	private WorkflowManager workflowManager ;
	
	// 是否审批  ==> 是否审批通过
	private String isApprove ;
	// 任务ID
	private String taskId ;
	// 审批意见
	private String content ;
	
	/**
	 * 后台获取 json 格式数据列表  ==> 审核中的项目
	 * @throws UnsupportedEncodingException
	 */
	public void approveList() throws UnsupportedEncodingException {
		List<Task> taskList = this.workflowManager.getTaskListByAssignee("admin") ;
		
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        for(Task t : taskList){
        	Set<String> variableNames = this.workflowManager.getVariablesNames(t.getExecutionId()) ;
    		Map<String, Object> map = this.workflowManager.getVariableByName(t.getExecutionId(), variableNames) ;
    		
    		for(Entry<String, Object> entry : map.entrySet()){
    			if("project".equals(entry.getKey())){
        			project = (Project) entry.getValue() ;
    			}
    		}
        	
        	jsonobj.put("taskId", t.getId()) ;
        	
        	jsonobj.put("id", project.getPid());
        	jsonobj.put("title", project.getTitle());
        	jsonobj.put("description", project.getDescription()) ;
        	jsonobj.put("budget", project.getBudget()) ;
        	jsonobj.put("phone", project.getPhone()) ;
        	jsonobj.put("mail", project.getMail()) ;
        	jsonobj.put("biddingend", project.getBiddingend()) ;
        	jsonobj.put("projectend", project.getProjectend()) ;
        	jsonobj.put("foundtime", project.getFoundtime()) ;
        	jsonobj.put("undertaketime", project.getUndertaketime()) ;
        	jsonobj.put("approvetime", project.getApprovetime()) ;
        	jsonobj.put("status", project.getStatus());
        	
        	Category category = project.getCategory() ;
        	if(category != null){
        		jsonobj.put("category_id", project.getCategory().getCatename()) ;
        	}else{
        		jsonobj.put("category_id", "") ;
        	}
        	
        	User founder = project.getUserByFounderId() ;
        	if(founder != null){
        		jsonobj.put("founder_id", project.getUserByFounderId().getUsername()) ;
        	}else{
        		jsonobj.put("founder_id", "") ;
        	}
        	
        	User undertaker = project.getUserByUndertakerId() ;
        	if(undertaker != null){
        		jsonobj.put("undertaker_id", project.getUserByUndertakerId().getUsername()) ;
        	}else{
        		jsonobj.put("undertaker_id", "") ;
        	}
        	
        	jsonArray.add(jsonobj) ;
        }
        
        writeToPage(taskList.size(), jsonArray);
	}
	
	/**
	 * 后台获取 json 格式数据列表  ==> 项目列表
	 * @throws UnsupportedEncodingException
	 */
	public void list() throws UnsupportedEncodingException {
		List<Project> projectList = (List<Project>) this.baseService.getAll(Project.class); 
		/*
		if("approve".equals(project.getStatus())){	// 审核中的状态
			int size = this.baseService.getCount(Project.class, "") ;
			projectList = (List<Project>) this.baseService.getByPage(Project.class, " and status = '"+DataUtils.PROJECT_APPROVE+"'", 0, size) ;
		}else{		// 其他所有的状态
			projectList = (List<Project>) this.baseService.getAll(Project.class);
		}*/
		
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        for(Project project : projectList){
        	jsonobj.put("id", project.getPid());
        	jsonobj.put("title", project.getTitle());
        	jsonobj.put("description", project.getDescription()) ;
        	jsonobj.put("budget", project.getBudget()) ;
        	jsonobj.put("phone", project.getPhone()) ;
        	jsonobj.put("mail", project.getMail()) ;
        	jsonobj.put("biddingend", project.getBiddingend()) ;
        	jsonobj.put("projectend", project.getProjectend()) ;
        	jsonobj.put("foundtime", project.getFoundtime()) ;
        	jsonobj.put("undertaketime", project.getUndertaketime()) ;
        	jsonobj.put("approvetime", project.getApprovetime()) ;
        	jsonobj.put("status", project.getStatus());
        	
        	Category category = project.getCategory() ;
        	if(category != null){
        		jsonobj.put("category_id", project.getCategory().getCatename()) ;
        	}else{
        		jsonobj.put("category_id", "") ;
        	}
        	
        	User founder = project.getUserByFounderId() ;
        	if(founder != null){
        		jsonobj.put("founder_id", project.getUserByFounderId().getUsername()) ;
        	}else{
        		jsonobj.put("founder_id", "") ;
        	}
        	
        	User undertaker = project.getUserByUndertakerId() ;
        	if(undertaker != null){
        		jsonobj.put("undertaker_id", project.getUserByUndertakerId().getUsername()) ;
        	}else{
        		jsonobj.put("undertaker_id", "") ;
        	}
        	
        	jsonArray.add(jsonobj) ;
        }
        
        writeToPage(projectList.size(), jsonArray);
        
	}
	
	/**
	 * 项目删除
	 * 	* 删除project表数据
	 * 	* 删除file表数据
	 * 	* 删除上传的文件
	 */
	public void delete() {
		if("".equals(ids)){
			writeJson(JsonUtils.getSuccessJson("选中数据为空！")) ;
		}else{
			// 删除file表数据
			String[] delIds = ids.split(",") ;
			boolean flag = true ;
			for(String id : delIds){
				// 获取 file 表里文件列表
				List<File> fList = (List<File>) this.baseService.getListById(File.class, "project_id", Long.parseLong(id)) ;
				for(File f : fList){
					// 删除上传的文件
					flag = UploadUtils.deleteFile(f.getUrl()) ;
					if(!flag) break ;
					
					// 删除file数据
					this.baseService.delete(f) ;
				}
				if(!flag) break ;
			}
			
			if(flag){
				// 删除 project 表数据
				this.baseService.deleteByIds(Project.class, ids) ;
				writeJson(JsonUtils.getSuccessJson("成功删除"+delIds.length+"条记录！")) ;
			}else{
				writeJson(JsonUtils.getErrorJson("删除失败")) ;
			}
			
		}
	}
	
	/**
	 * 项目审核
	 * 	* 完成审批任务节点
	 * 	* 修改project表状态
	 * 	* 审批表approve中插入数据
	 * 	* 项目日志表中插入数据
	 * 	* 传递消息到后台
	 * 	* 传递审核结果消息给项目发布方
	 */
	public void approve() {
		Admin admin = (Admin) OAUtils.fromSession("admin") ;
		if(admin != null){
			Task task = this.workflowManager.getTaskByTaskId(taskId) ;
			Project p = (Project) this.baseService.getById(Project.class, project.getPid()) ;
			
			// 审批 approve 表中插入数据
			Approve a = new Approve() ;
			a.setAdmin(admin) ;
			a.setApprovetime(DateUtils.formatDateTime(new Date())) ;
			a.setContent(content) ;
			a.setIsApprove(isApprove) ;
			a.setProject(project) ;
			this.baseService.save(a) ;
			
			/**
			 *  修改project表状态
			 *  	* 不同意直接结束流程
			 *  	* 同意则完成当前任务
			 */
			if("unpass".equals(a.getIsApprove())){	// 不同意
				System.out.println("unpass...");
				p.setStatus(DataUtils.PROJECT_UNPASS) ;
				this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_END) ;
			}else{
				System.out.println("pass...");
				p.setStatus(DataUtils.PROJECT_BIDDING) ;
				this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_BIDDING) ;
			}
			this.baseService.update(p) ;
			
			// 项目日志 projectlog 表中插入数据
			Projectlog projectlog = new Projectlog() ;
			projectlog.setProject(p) ;
			if("unpass".equals(a.getIsApprove())){
				projectlog.setHandle(DataUtils.PROJECT_APPROVE_FALSE) ;
			}else{
				projectlog.setHandle(DataUtils.PROJECT_APPROVE_TRUE) ;
			}
			projectlog.setHandletime(DateUtils.formatDateTime(new Date())) ;
			this.baseService.save(projectlog) ;
			
			// 传递审核结果消息给项目发布方
			
			// 前台传送成功信息
			writeJson(JsonUtils.getSuccessJson("审批成功")) ;
		}else{
			writeJson(JsonUtils.getErrorJson("审批失败")) ;
		}
		
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsApprove() {
		return isApprove;
	}

	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}

	public Object getModel() {
		return project;
	}
	
}

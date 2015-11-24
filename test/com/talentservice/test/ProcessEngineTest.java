package com.talentservice.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jbpm.api.IdentityService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.junit.Test;

import com.talentservice.domain.Project;
import com.talentservice.service.WorkflowManager;
import com.talentservice.utils.DataUtils;
import com.talentservice.vo.ProjectView;

public class ProcessEngineTest extends BaseSpring {
	@Test
	public void testProcessEngine() {
		 ProcessEngine processEngine = (ProcessEngine) context.getBean("processEngine") ;
	}
	
	/**
	 * 启动流程实例 ==> 需要pdkey，流程名称
	 */
	@Test
	public void testStartProcess(){
		//BaseService baseService = (BaseService) context.getBean("baseService") ;
		
		//User user = (User) baseService.getById(User.class, 1) ;
		
		//if(user != null){
			Map<String, String> variables = new HashMap<String, String>() ;
			variables.put("projectStarter", "wlm") ;
			
			ProcessInstance pi = processEngine.getExecutionService()
			//.startProcessInstanceById("project-1", variables);
			.startProcessInstanceByKey("project", variables);
			
			System.out.println(pi.getId()+", "+pi.getKey()+", "+pi.getName()+", "+pi.getState());
		//}
	}
	
	@Test
	public void testStartPI() {
		WorkflowManager workflowManager = (WorkflowManager) context.getBean("workflowManager") ;
		/*ProcessInstance pi = workflowManager.startPIByName("wlm") ;
		System.out.println("id: "+pi.getId()+", "+pi.getName());*/
	}
	
	@Test
	public void testGetTask() {
		Task task = this.processEngine.getTaskService().createTaskQuery().executionId("project.270003.to bidderComment.320002").uniqueResult() ;
		System.out.println("taskName: "+task.getName()+", "+task.getId());
	}
	
	/**
	 * 完成任务 ==> 需要taskId
	 */
	@Test
	public void testFinishTask() {
		/*String executionId = "project.550001" ;
		
		Role adminRole = (Role) this.baseService.getEntityByHql("from Role where rolename = 'admin'") ;
		System.out.println("rolename: "+adminRole.getRolename());
		Role approverRole = (Role) this.baseService.getEntityByHql("from Role where rolename = 'approver'") ;
		
		Map<String, Object> variables = new HashMap<String, Object>() ;
		variables.put("adminRole", adminRole) ;
		variables.put("approverRole", approverRole) ;
		
		processEngine.getExecutionService()
		.setVariables(executionId, variables) ;
		
		Set<String> variableNames = processEngine.getExecutionService()
		.getVariableNames(executionId) ;
		Map<String, Object> maps = processEngine.getExecutionService()
		.getVariables(executionId, variableNames) ;*/
		
		processEngine.getTaskService()
		.completeTask("310021", DataUtils.TO_FORK) ;
	}
	
	@Test
	public void testGetBidderList(){
		//List<Task> taskList = this.processEngine.getTaskService().createTaskQuery().assignee("wlm").activityName("confirmPlan").list();
		List<Task> taskList = this.processEngine.getTaskService().createTaskQuery().assignee("wlm").list();
		
		List<ProjectView> pvList = new ArrayList<ProjectView>() ;
		for(Task t : taskList){
			Set<String> variableNames = this.processEngine.getExecutionService().getVariableNames(t.getExecutionId()) ;
			Map<String, Object> map = this.processEngine.getExecutionService().getVariables(t.getExecutionId(), variableNames) ;
			
			Project p = null ;
			for(Entry<String, Object> entry : map.entrySet()){
				if("project".equals(entry.getKey())){
	    			p = (Project) entry.getValue() ;
				}
			}
			//System.out.println("p: "+p.getUserByFounderId().getUsername());
			//if(p.getUserByFounderId().getUsername().equals("wlm")){
				ProjectView pv = new ProjectView() ;
				pv.setProject(p) ;
				pv.setTask(t) ;
				pvList.add(pv) ;
			//}
		}
		
		System.out.println("pvList size: "+pvList.size());
		
	}
	
	@Test
	public void testAssignTask() {
		this.processEngine.getTaskService().assignTask("930005", "test") ;
	}
	
	@Test 
	public void testGetApproveTask() {
		List<Task> taskList = this.processEngine.getTaskService().createTaskQuery().assignee("admin").list() ;
		for(Task t : taskList){
			System.out.println(t.getId()+", "+t.getName()+", "+t.getExecutionId()+", "+t.getProgress()+", "+t.getAssignee());
			Map<String, Object> variables = (Map<String, Object>) this.processEngine.getExecutionService().getVariable(t.getExecutionId(), "project") ;
			Project project = (Project) variables.get("project") ;
			System.out.println("title: "+project.getTitle());
			//System.out.println(t.getId()+", "+t.getName()+", "+t.getExecutionId()+", "+t.getProgress()+", "+t.getAssignee());
		}
		
	}
	
	@Test
	public void testVariable() {
		String executionId = "project.960001" ;
		Set<String> variableNames = this.processEngine.getExecutionService().getVariableNames(executionId) ;
		Map<String, Object> map = this.processEngine.getExecutionService().getVariables(executionId, variableNames) ;
		for(Entry<String, Object> entry : map.entrySet()){
			System.out.println(entry.getKey()+", "+entry.getValue().toString());
		}
	}
	
	@Test
	public void testGetTaskIdByPI() {
		//this.processEngine.getTaskService().createTaskQuery().executionId("630001").list() ;
		
		
		//List<Task> taskList = (List<Task>) this.processEngine.getTaskService().createTaskQuery().assignee("wlm").list() ;
		
		Task t = this.processEngine.getTaskService().createTaskQuery().executionId("project.630001").uniqueResult();
		
		//for(Task t : taskList){
			System.out.println("name: "+t.getName()+", taskId: "+t.getId());
		//}
	}
	
	@Test
	public void testGetTaskByTaskId() {
		//Task task = this.processEngine.getTaskService().createTaskQuery().assignee("admin").uniqueResult() ;
		Task task = this.processEngine.getTaskService().getTask("970006") ;
		System.out.println("task: "+task.getExecutionId());
	}
	
	@Test
	public void testFinishTaskByTaskId() {
		String taskId = "970006" ;
		this.processEngine.getTaskService().completeTask(taskId, "to bidding") ;
	}
	
	/**
	 * 查询组任务，适合组任务多用户可执行流程的情况 ==> 需要 userId
	 */
	@Test
	public void testFindGroupTask(){
		List<Task> taskList = processEngine.getTaskService()
		.findGroupTasks("admin") ;
		
		for(Task t : taskList){
			System.out.println(t.getId()+", "+t.getName()+", "+t.getAssignee()+", ");
		}
	}
	
	/**
	 * 查询未完成的个人任务 ==> 适合单个 assignee 的情况
	 */
	@Test
	public void testFindPersonalTask(){
		System.out.println("personal");
		List<Task> taskList = processEngine.getTaskService()
				.findPersonalTasks("admin") ;
		
		System.out.println("size: "+taskList.size());
		
		for(Task t : taskList){
			System.out.println(t.getId()+", "+t.getName()+", "+t.getAssignee()+", ");
		}
	}
	
	@Test
	public void testGetProcessInstanceId() {
		/*processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.processDefinitionId(processDefinitionId)*/
	}
	
	@Test
	public void testCandidataGroups() {
		//Admin admin = this.baseService.getListById(clazz, idName, id);
		IdentityService identityService = this.processEngine.getIdentityService() ;
		
		
		String groupName = "approves" ;
		identityService.createGroup(groupName);
		
		// 创建用户
		//identityService.createUser("admin", "admin", "superAdmin") ;
		identityService.createUser("test", "test", "approve") ;
		identityService.createUser("test1", "test1", "approve") ;
		identityService.createUser("test2", "test2", "approve") ;
		identityService.createUser("test3", "test3", "approve") ;
		identityService.createUser("test4", "test4", "approve") ;
		
		// 加入用户组
		//identityService.createMembership("admin", groupName) ;
		identityService.createMembership("test", groupName) ;
		identityService.createMembership("test1", groupName) ;
		identityService.createMembership("test2", groupName) ;
		identityService.createMembership("test3", groupName) ;
		identityService.createMembership("test4", groupName) ;
	}
	
	@Test
	public void testtestCandidataGroupsTask() {
		TaskService taskService = processEngine.getTaskService() ;
		List<Task> testTask = taskService.findGroupTasks("test") ;
		System.out.println("size: "+testTask.size());
		for(Task t : testTask){
			System.out.println(t.getName()+", "+t.getId()+", "+t.getExecutionId());
		}
	}
	
	@Test
	public void testGetTaskId() {
		List<Task> taskList = processEngine.getTaskService()
		.createTaskQuery()
		.assignee("wlm")
		.list();
		
		//System.out.println(task.getId()+", "+task.getExecutionId());
		
		for(Task task : taskList){
			System.out.println(task.getId()+", "+task.getExecutionId()+", "+task.getName());
		}
	}
	
	/**
	 * 选择竞标人 ==> 承接人选择
	 */
	@Test
	public void testBidding() {
		
	}
	
}

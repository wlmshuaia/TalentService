package com.talentservice.workflow.handler;

import org.jbpm.api.Configuration;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.TaskService;
import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;
import org.jbpm.api.task.Task;

import com.talentservice.domain.Admin;
import com.talentservice.utils.OAUtils;

/**
 * 审批任务赋值
 * @author Administrator
 *
 */
public class AssignApproverHandler implements AssignmentHandler {
	
	private static final long serialVersionUID = 3505439356603156018L;
	
	public void assign(Assignable assignable, OpenExecution execution) throws Exception {
		/*Admin admin = (Admin) OAUtils.fromSession("admin") ;
		assignable.setAssignee(admin.getAdminname()) ;*/
		
		/*String executionId = execution.getProcessInstance().getId() ;	// 获取当前上下文流程实例
		Task task = taskService.createTaskQuery().processInstanceId(executionId).activityName(execution.getName()).uniqueResult();	// 获取当前任务	*/
		
		assignable.setAssignee("admin") ;
	}
	
}

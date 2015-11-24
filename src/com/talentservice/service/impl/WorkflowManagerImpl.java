package com.talentservice.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talentservice.domain.Admin;
import com.talentservice.domain.Approve;
import com.talentservice.domain.Project;
import com.talentservice.domain.Projectlog;
import com.talentservice.service.WorkflowManager;
import com.talentservice.utils.DataUtils;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.OAUtils;

@Service("workflowManager")
public class WorkflowManagerImpl implements WorkflowManager {
	
	@Resource(name="processEngine")
	private ProcessEngine processEngine ;
	
	public Collection<ProcessDefinition> getLasterVersion() {
		
		List<ProcessDefinition> pdList = this.processEngine.getRepositoryService()
				.createProcessDefinitionQuery()
				.orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)
				.list();
		
		Map<String, ProcessDefinition> maps = new HashMap<String, ProcessDefinition>() ;
		
		for(ProcessDefinition pd : pdList){
			maps.put(pd.getKey(), pd) ;
		}
		
		return maps.values();
	}
	
	@Transactional(readOnly=false)
	public void deploy(File resource) throws FileNotFoundException {
		InputStream in = new FileInputStream(resource) ;
		ZipInputStream zipInputStream = new ZipInputStream(in) ;
		this.processEngine.getRepositoryService()
		.createDeployment()
		.addResourcesFromZipInputStream(zipInputStream)
		.deploy() ;
	}
	
	@Transactional(readOnly=false)
	public InputStream showImage(String deploymentId) {
		ProcessDefinition pd = this.processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.deploymentId(deploymentId)
		.uniqueResult() ;
		
		return this.processEngine.getRepositoryService()
				.getResourceAsStream(deploymentId, pd.getImageResourceName());
	}
	
	@Transactional(readOnly=false)
	public void deletePDKEY(String pdKEYs) {
		String[] pdKeys = pdKEYs.split(",") ;
		
		for(String pdKEY : pdKeys){	// 多次删除
			List<ProcessDefinition> pdList = this.processEngine.getRepositoryService()
					.createProcessDefinitionQuery()
					.processDefinitionKey(pdKEY)
					.list() ;
			
			for(ProcessDefinition pd : pdList){
				this.processEngine.getRepositoryService()
				.deleteDeploymentCascade(pd.getDeploymentId()) ;
			}
		}
	}
	
	public ProcessInstance startPIByName(String username, Map<String, Object> variables) {
		//Map<String, String> variables = new HashMap<String, String>() ;
		variables.put("projectStarter", username) ;
		
		ProcessInstance pi = this.processEngine.getExecutionService().startProcessInstanceByKey("project", variables);
		System.out.println("startPIByName piid: "+pi.getId());
		return pi ;
	}

	public Task getTaskByExecutionId(String executionId) {
		return this.processEngine.getTaskService().createTaskQuery().executionId(executionId).uniqueResult();
	}
	
	public Task getTaskByTaskId(String taskId) {
		return this.processEngine.getTaskService().getTask(taskId);
	}
	
	public void completeTaskByTaskId(String taskId) {
		this.processEngine.getTaskService().completeTask(taskId);
	}
	
	public void completeTaskByTaskId(String taskId, String outcome) {
		this.processEngine.getTaskService().completeTask(taskId, outcome);
	}
	
	public void completeTaskByTaskId(String taskId, String outcome, Map<String, Object> variables) {
		this.processEngine.getTaskService().completeTask(taskId, outcome, variables) ;
	}

	public void setAssignTask(String taskId, String username) {
		this.processEngine.getTaskService().assignTask(taskId, username) ;
	}

	public List<Task> getTaskListByAssignee(String assign) {
		return this.processEngine.getTaskService().createTaskQuery().assignee(assign).list();
	}

	public Map<String, Object> getVariableByName(String executionId, Set<String> variablesNames) {
		return this.processEngine.getExecutionService().getVariables(executionId, variablesNames);
	}
	
	public Set<String> getVariablesNames(String executionId) {
		return this.processEngine.getExecutionService().getVariableNames(executionId) ;
	}

	public void endProcessByExecutionId(String executionId, String state) {
		this.processEngine.getExecutionService().endProcessInstance(executionId, state) ;
	}

}

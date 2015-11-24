package com.talentservice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;

import com.talentservice.domain.Approve;
import com.talentservice.domain.Project;

public interface WorkflowManager {
	// 获取最新版本流程定义列表
	public Collection<ProcessDefinition> getLasterVersion() ;
	// 流程定义部署
	public void deploy(File resource) throws FileNotFoundException ;
	// 删除流程定义
	public void deletePDKEY(String pdKEYs) ;
	// 查看流程图片
	public InputStream showImage(String deploymentId) ;
	// 启动流程实例
	public ProcessInstance startPIByName(String username, Map<String, Object> variables) ;
	// 根据流程实例 id 获取任务
	public Task getTaskByExecutionId(String executionId) ;
	// 根据taskId获取任务
	public Task getTaskByTaskId(String taskId) ;
	// 完成任务
	public void completeTaskByTaskId(String taskId) ;
	public void completeTaskByTaskId(String taskId, String outcome) ;
	public void completeTaskByTaskId(String taskId, String outcome, Map<String, Object> variables) ;
	// 根据executionId和变量名称获取流程变量
	public Map<String, Object> getVariableByName(String executionId, Set<String> variablesNames) ;
	// 设置执行人
	public void setAssignTask(String taskId, String username) ;
	// 获取任务列表
	public List<Task> getTaskListByAssignee(String assign) ;
	// 获取流程变量名称set集
	public Set<String> getVariablesNames(String executionId) ;
	// 结束流程
	public void endProcessByExecutionId(String executionId, String state) ;
}

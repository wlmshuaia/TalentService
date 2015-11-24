package com.talentservice.vo;

import java.io.Serializable;

import org.jbpm.api.task.Task;

import com.talentservice.domain.Project;

/**
 * 项目与任务中间类
 * @author Administrator
 *
 */
public class ProjectView implements Serializable {

	private static final long serialVersionUID = 4310216518092896711L;
	
	private Project project ;
	private Task task ;
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
}

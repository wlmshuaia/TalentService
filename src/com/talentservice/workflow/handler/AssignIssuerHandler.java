package com.talentservice.workflow.handler;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;

import com.talentservice.domain.User;
import com.talentservice.utils.OAUtils;

public class AssignIssuerHandler implements AssignmentHandler {

	public void assign(Assignable assignable, OpenExecution execution)
			throws Exception {
		User user = (User) OAUtils.fromSession("user") ;
		if(user != null){
			assignable.setAssignee(user.getUsername()) ;
		}
	}

}

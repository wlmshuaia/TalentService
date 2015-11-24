package com.talentservice.workflow.handler;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

import com.talentservice.utils.DataUtils;

public class DecisionCompleteHandler implements DecisionHandler {
	
	private static final long serialVersionUID = 8609018432303270982L;

	public String decide(OpenExecution execution) {
		
		String to = execution.getVariable("confirmProduct").toString();
		
		if(to.equals(DataUtils.TO_COMPLETEPLAN)){
			return DataUtils.TO_COMPLETEPLAN ;
		}
		
		return DataUtils.TO_PAYANDCOMMENT;
	}

}

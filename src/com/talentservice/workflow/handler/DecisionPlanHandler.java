package com.talentservice.workflow.handler;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

import com.talentservice.utils.DataUtils;

public class DecisionPlanHandler implements DecisionHandler {
	
	private static final long serialVersionUID = 5196283917890881479L;

	public String decide(OpenExecution execution) {
		String to = execution.getVariable("confirmPlan").toString();
		
		System.out.println("decisionPlanHandler...: "+to);
		
		if(to.equals(DataUtils.TO_MAKEPLAN)){
			return DataUtils.TO_MAKEPLAN ;
		}
		
		return DataUtils.TO_COMPLETEPLAN;
	}

}

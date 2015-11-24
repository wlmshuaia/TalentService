package com.talentservice.test;

import java.util.Collection;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.junit.Test;

import com.talentservice.service.WorkflowManager;

public class WorkflowTest extends BaseSpring {
	@Test
	public void testGetLasterVersions() {
		WorkflowManager workflowManager = (WorkflowManager) context.getBean("workflowManager") ;
		
		Collection<ProcessDefinition> pdList =  workflowManager.getLasterVersion() ;
		
		for(ProcessDefinition pd : pdList){
			System.out.println(pd.getName()+", "+pd.getVersion());
		}
	}
}

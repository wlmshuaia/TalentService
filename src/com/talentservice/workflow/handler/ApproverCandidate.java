package com.talentservice.workflow.handler;

import java.util.List;
import java.util.Map;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.talentservice.domain.AdminRole;
import com.talentservice.domain.Role;
import com.talentservice.helper.BeanFactoryHelper;
import com.talentservice.service.base.BaseService;

/**
 * 设置审批用户组
 * @author Administrator
 *
 */
public class ApproverCandidate implements AssignmentHandler  {
	
	private static final long serialVersionUID = 8387059530997353577L;
	
	private BaseService baseService ;
	
	public ApproverCandidate() {
		BeanFactory factory = BeanFactoryHelper.getFactory(); 
		baseService = (BaseService) factory.getBean("baseService") ;
	}
	
	public void assign(Assignable assignable, OpenExecution execution) throws Exception {
		
		/*String executionId = "project.330001" ;
		@SuppressWarnings("unchecked")
		Map<String, Object> variables = (Map<String, Object>) execution.getVariables();
		System.out.println("variables.size: "+variables.size());
		
		Role adminRole = (Role) variables.get("adminRole") ;
		System.out.println("adminRole: "+adminRole.getRolename());	// 可以执行
		Role approverRole = (Role) variables.get("approverRole") ;
		*/
		
		Role adminRole = (Role) this.baseService.getEntityByHql("from Role where rolename = 'admin'") ;
		System.out.println("rolename: "+adminRole.getRolename());
		Role approverRole = (Role) this.baseService.getEntityByHql("from Role where rolename = 'approver'") ;
		
		List<AdminRole> adminList = null ;
		List<AdminRole> approverList = null ;
		
		if(adminRole != null){
			adminList = (List<AdminRole>) this.baseService.getListById(AdminRole.class, "role_id", adminRole.getRid());
			for(AdminRole ad : adminList){
				System.out.println("ad: "+ad.getAdmin().getAdminname());	// 获取所有具有后台审批权限用户
				assignable.addCandidateUser(ad.getAdmin().getAdminname()) ;
			}
		}
		
		if(approverRole != null){
			approverList = (List<AdminRole>) this.baseService.getListById(AdminRole.class, "role_id", approverRole.getRid());
			for(AdminRole ap : approverList){
				System.out.println("ap: "+ap.getAdmin().getAdminname());	// 获取所有具有后台审批权限用户
				assignable.addCandidateUser(ap.getAdmin().getAdminname()) ;
			}
		}
		
	}

	public BaseService getBaseService() {
		return baseService;
	}
	
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

}

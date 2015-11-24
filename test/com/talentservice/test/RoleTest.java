package com.talentservice.test;

import java.util.List;

import org.junit.Test;

import com.talentservice.domain.AdminRole;
import com.talentservice.domain.Role;

public class RoleTest extends BaseSpring{
	@Test
	public void testRoleUserList() {
		
		String roleIds = "1,2" ;
		
		String[] ids = roleIds.split(",") ;
		for(String id : ids){
			System.out.println("id: "+id);
			List<AdminRole> arList = (List<AdminRole>) this.baseService.getListById(AdminRole.class, "role_id", Long.parseLong(id));
			for(AdminRole ar : arList){
				System.out.println(ar.getAdmin());	// 获取所有具有后台审批权限用户
			}
		}
	}
	
	@Test
	public void testGetRole() {
		Role adminRole = (Role) this.baseService.getEntityByHql("from Role where rolename = 'admin'") ;
		Role approverRole = (Role) this.baseService.getEntityByHql("from Role where rolename = 'approver'") ;
		
		System.out.println(adminRole.getRolename()+", "+approverRole.getRolename());
		
		List<AdminRole> adminList = null ;
		List<AdminRole> approverList = null ;
		
		if(adminRole != null){
			adminList = (List<AdminRole>) this.baseService.getListById(AdminRole.class, "role_id", adminRole.getRid());
			for(AdminRole ad : adminList){
				System.out.println(ad.getAdmin().getAdminname());	// 获取所有具有后台审批权限用户
			}
		}
		
		if(approverRole != null){
			approverList = (List<AdminRole>) this.baseService.getListById(AdminRole.class, "role_id", adminRole.getRid());
			for(AdminRole ap : approverList){
				System.out.println(ap.getAdmin().getAdminname());	// 获取所有具有后台审批权限用户
			}
		}
	}
}

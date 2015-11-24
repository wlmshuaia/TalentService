package com.talentservice.test;

import java.util.Date;

import org.junit.Test;

import com.talentservice.domain.Admin;
import com.talentservice.domain.Approve;
import com.talentservice.utils.DateUtils;

public class ApproveTest extends BaseSpring {
	@Test
	public void testSave() {
		Admin admin = (Admin) this.baseService.getById(Admin.class, Long.parseLong("1")) ;
		Approve a = new Approve() ;
		a.setAdmin(admin) ;
		a.setApprovetime(DateUtils.formatDateTime(new Date())) ;
		a.setContent("") ;
		a.setIsApprove("pass") ;
		
		// 审批 approve 表中插入数据
		this.baseService.save(a) ;
	}
}

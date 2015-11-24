package com.talentservice.test;

import org.junit.Test;

import com.talentservice.domain.Student;
import com.talentservice.domain.User;
import com.talentservice.utils.IdentifyUtils;

public class RegisterTest extends BaseSpring {
	
	@Test
	public void testVerify() {
		
		String code = IdentifyUtils.verifyCode(4).toString() ;
		
		System.out.println("code: "+code);
	}
	
	@Test
	public void testRegister() {
		Student stu = new Student() ;
		stu.setMail("1057654928@qq.com") ;
		this.baseService.save(stu) ;
		
		User user = new User() ;
		user.setUsername("张三") ;
		user.setPassword(IdentifyUtils.Md5("123")) ;
		user.setType(Short.parseShort("0")) ;
		user.setUserId(stu.getSid()) ;
		this.baseService.save(user) ;
	}
	
}

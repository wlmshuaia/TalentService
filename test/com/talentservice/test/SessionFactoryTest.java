package com.talentservice.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.talentservice.domain.User;
import com.talentservice.utils.OAUtils;

public class SessionFactoryTest extends BaseSpring {
	@Test
	public void testSessionFactory() {
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory") ;
	}
	
	@Test
	public void testFromSession() {
		User u = new User() ;
		u.setUsername("test") ;
		u.setPassword("123") ;
		OAUtils.putToSession("user", u) ;
		
		User user = (User) OAUtils.fromSession("user") ;
		
		System.out.println("username: "+user.getUsername());
	}
}

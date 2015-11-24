package com.talentservice.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jbpm.api.ProcessEngine;
import org.junit.AfterClass;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.talentservice.service.base.BaseService;

public class BaseSpring {
	public static ApplicationContext context ;
	public static SessionFactory sf = null ;
	public static BaseService baseService ;
	public static ProcessEngine processEngine ;
	
	@Before
	public void startSpring() {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml") ;
		sf = new Configuration().configure("jbpm/jbpm.hibernate.cfg.xml").buildSessionFactory() ;
		baseService = (BaseService) context.getBean("baseService") ;
		processEngine = (ProcessEngine) context.getBean("processEngine") ;
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close() ;
	}
}

package com.talentservice.test;

import java.util.List;

import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.talentservice.domain.User;
import com.talentservice.service.base.BaseService;

public class UserListTest extends BaseSpring {
	
	@Test
	public void testLogin() {
		BaseService baseService = (BaseService) context.getBean("baseService") ;
		
		String username = "wlm" ;
		String password = "123" ;
		User user = (User) baseService.getEntityByHql("from User where username = '"+username+"' and password = '"+password+"'") ;
		
		System.out.println("name: "+user.getUsername());
	}
	
	@Test
	public void testList() {
		//UserService userService = (UserService) context.getBean("userService") ;
		
		Session session = sf.openSession() ;
		
		List<User> userList = session.createQuery("from User").list() ;
		System.out.println("userList size: "+userList.size());
		/*User user1 = new User((long)1, "wlm", "1") ;
		User user2 = new User((long)2, "test", "2") ;
		User user3 = new User((long)3, "t", "3") ;
		userList.add(user1) ;
		userList.add(user2) ;
		userList.add(user3) ;
		*/
//		JSONArray userData = JSONArray.fromObject(userList) ;
//		System.out.println("userData: "+userData.toString());
		System.out.println("userList: "+userList.get(0).getUsername());
	}
	
	@Test
	public void testUserService() {
		/*UserService userService = (UserService) context.getBean("userService") ;
		List<User> userList = (List<User>) userService.getAllUsers() ;
		System.out.println("userList: "+userList);*/
	}
	
	@Test
	public void testDelete() {
		/*UserService userService = (UserService) context.getBean("userService") ;
		String uid = "4" ;
		userService.deleteUserById(Long.parseLong(uid));*/
	}
	
	@Test
	public void testSave() {
		/*UserService userService = (UserService) context.getBean("userService") ;
		User user = new User() ;
		user.setUsername("a");
		user.setPassword("a");
		//user.setType("3");
		//user.setUser_id((long)2);
		userService.saveUser(user) ;*/
	}
	
	@Test
	public void testGetUser() {
		HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate") ;
		String name = "wlm" ;
		String pass = "123" ;
		List<User> users = (List<User>) hibernateTemplate.find("from User where username = '"+name+"'and password = '"+pass+"'");
		
		System.out.println("username: "+users.get(0).getUsername());
	}
	
}

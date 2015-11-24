package com.talentservice.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.talentservice.domain.User;

public class OAUtils {
	
	public static Long[] string2Longs(String ids){
		String[] s = ids.split(",");
		Long[] aa = new Long[s.length];
		int index = 0;
		for(String string:s){
			aa[index] = Long.valueOf(string);
			index++;
		}
		return aa;
	}
	
	public static Object fromSession(String name) {
		return ServletActionContext.getRequest().getSession().getAttribute(name);
	}
	
	public static void putToSession(String name, Object user) {
		HttpServletRequest request = ServletActionContext.getRequest() ;
		HttpSession session = request.getSession();
		session.setAttribute(name, user) ;
		session.setMaxInactiveInterval(120 * 60); 
	}
	
	public static void removeFromSession(String name) {
		ServletActionContext.getRequest().getSession().removeAttribute(name) ;
	}
}

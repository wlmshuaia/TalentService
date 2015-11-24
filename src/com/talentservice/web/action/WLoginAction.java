package com.talentservice.web.action;

import org.springframework.stereotype.Component;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.User;
import com.talentservice.utils.IdentifyUtils;
import com.talentservice.utils.OAUtils;

@Component("wloginAction")
public class WLoginAction extends BaseAction {

	private User user = new User() ;
	
	public String loginUI() {
		return "loginUI" ;
	}
	
	public String login() {
		String username = user.getUsername() ;
		String password = user.getPassword() ;
		
		User u = (User) this.baseService.getEntityByHql("from User where username = '"+username+"' and password = '"+IdentifyUtils.Md5(password)+"'");
		
		if(u != null){
			OAUtils.putToSession("user", u) ;
			return SUCCESS;
		}else{
			return "error" ;
		}
	}
	
	public String logout(){
		OAUtils.removeFromSession("user") ;
		return "loginUI" ;
	}
	
	public Object getModel() {
		return user;
	}

}

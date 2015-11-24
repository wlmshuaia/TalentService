package com.talentservice.admin.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Admin;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.IdentifyUtils;
import com.talentservice.utils.OAUtils;

@Controller("aloginAction")
@Scope("prototype")
public class ALoginAction extends BaseAction {
	
	private static final long serialVersionUID = -4771918174383483075L;
	
	private Admin admin = new Admin() ;
	
	public String login(){
		Admin a = (Admin) this.baseService.getEntityByHql("from Admin where adminname = '"+admin.getAdminname()+"' and adminpassword = '"+IdentifyUtils.Md5(admin.getAdminpassword())+"'") ;
		if(a != null){
			// 存入 session
			OAUtils.putToSession("admin", a) ;
			// 保存上次登录的ip以及登录时间
			OAUtils.putToSession("lastlogintime", a.getLastlogintime()) ;
			OAUtils.putToSession("lastloginip", a.getLastloginip()) ;
			// 保存此次登录ip以及登录时间
			Date date = new Date() ;
			a.setLastlogintime(DateUtils.formatDateTime(date)) ;
			a.setLastloginip(ServletActionContext.getRequest().getRemoteAddr()) ;
			this.baseService.update(a) ;
			
			return "index" ;
		}else{
			return "error" ;
		}
	}
	
	public String logout() {
		OAUtils.removeFromSession("admin") ;
		return "loginUI" ;
	}
	
	public Object getModel() {
		return admin;
	}

}

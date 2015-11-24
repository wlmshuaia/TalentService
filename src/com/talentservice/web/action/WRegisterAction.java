package com.talentservice.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Enterprise;
import com.talentservice.domain.School;
import com.talentservice.domain.Student;
import com.talentservice.domain.Teacher;
import com.talentservice.domain.User;
import com.talentservice.domain.Workman;
import com.talentservice.utils.IdentifyUtils;
import com.talentservice.utils.JavaMail;
import com.talentservice.utils.OAUtils;
import com.talentservice.utils.SelectDataUtils;
import com.talentservice.vo.SelectData;

@Component("wregisterAction")
public class WRegisterAction extends BaseAction {
	
	private User user = new User() ;
	
	private String mail ;
	private String message ;
	
	private String registerType ;
	private String verify ;
	
	/**
	 * 注册视图
	 * @return
	 */
	public String registerUI() {
		List<SelectData> type = SelectDataUtils.getUserTypeData() ;
		ActionContext.getContext().put("registerType", type) ;
		return "registerUI" ;
	}
	
	/**
	 * 提交表单注册
	 * @return
	 */
	public String register() {
		JavaMail js = new JavaMail(false) ;
		String code = IdentifyUtils.verifyCode(5).toString();
		
		js.doSendHtmlEmail("注册邮件", "欢迎您注册仕可人才服务社交平台.<br/>请复制下面的验证码 <h1 color='red'>"+code+"</h1>", mail) ;
		
		System.out.println("register... mail: "+mail+", code: "+code);
		
		OAUtils.putToSession("verify", code) ;
		
		return "registerVerify" ;
	}
	
	/**
	 * 提交验证码
	 * @return
	 */
	public String verify(){
		String verifyCode = (String) OAUtils.fromSession("verify") ;
		if(verify.equals(verifyCode)){
			this.message = "验证码正确" ;

			// 保存用户信息
			switch(Integer.parseInt(registerType)){
			case 0:
				Student student = new Student() ;
				student.setMail(mail) ;
				this.baseService.save(student) ;
				user.setUserId(student.getSid()) ;
				break ;
			case 1:
				Workman workman = new Workman() ;
				workman.setMail(mail) ;
				this.baseService.save(workman) ;
				user.setUserId(workman.getWid()) ;
				break ;
			case 2:
				School school = new School() ;
				school.setMail(mail) ;
				this.baseService.save(school) ;
				user.setUserId(school.getSid()) ;
				break ;
			case 3:
				Enterprise enterprise = new Enterprise() ;
				enterprise.setMail(mail) ;
				this.baseService.save(enterprise) ;
				user.setUserId(enterprise.getEid()) ;
				break ;
			case 4:
				Teacher teacher = new Teacher() ;
				teacher.setMail(mail) ;
				this.baseService.save(teacher) ;
				user.setUserId(teacher.getTid()) ;
				break ;
			}
			user.setType(Short.parseShort(registerType)) ;
			user.setPassword(IdentifyUtils.Md5(user.getPassword())) ;
			this.baseService.save(user) ;
			
		}else{
			this.message = "验证码错误" ;
		}
		return SUCCESS ;
	}
	
	public String checkUser() {
		User u = (User) this.baseService.getEntityByHql("from User where username = '"+user.getUsername()+"'") ;
		if(u != null){
			this.message = "该用户名已存在" ;
		}else{
			this.message = "该用户名可以使用" ;
		}
		return SUCCESS;
	}
	
	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Object getModel() {
		return user;
	}

}

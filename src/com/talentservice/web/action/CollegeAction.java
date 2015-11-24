package com.talentservice.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.College;
import com.talentservice.domain.Profession;
import com.talentservice.domain.School;
import com.talentservice.domain.User;

@Controller("collegeAction")
@Scope("prototype")
public class CollegeAction extends BaseAction {
	private static final long serialVersionUID = 3819381045813625969L;
	
	private College college = new College() ;
	
	/* 学校ID  */
	private String sid ;
	/* 用户 */
	private User user ;
	
	/**
	 * 获取学院信息
	 * @return
	 */
	public String getCollege(){
		College c = (College) this.baseService.getById(College.class, college.getCid()) ;
		User user = (User) this.baseService.getEntityByHql("from User where type = '5' and user_id = '"+college.getCid()+"'") ;
		User school = (User) this.baseService.getEntityByHql("from User where type = '1' and user_id = '" + c.getSchool().getSid()+"'") ;
		List<Profession> pList = (List<Profession>) this.baseService.getListById(Profession.class, "college_id", college.getCid()) ;
		
		System.out.println("username: "+user.getUsername());
		
		ActionContext.getContext().put("collegeUser", user);
		ActionContext.getContext().put("school", school);
		ActionContext.getContext().put("college", c);
		ActionContext.getContext().put("professionList", pList);
		return "collegeInfo" ;
	}
	
	/**
	 * 添加学院视图
	 * @return
	 */
	public String collegeAddUI() {
		School s = (School) this.baseService.getById(School.class, Long.parseLong(sid)) ;
		User schoolUser = (User) this.baseService.getEntityByHql("from User where type = 1 and user_id = "+s.getSid()) ;
		ActionContext.getContext().put("school", schoolUser);
		return "collegeAddUI" ;
	}
	
	/**
	 * 添加学院表单处理
	 * @return
	 */
	public String collegeAdd() {
		
		return "schoolInfo" ;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public Object getModel() {
		return college;
	}
}

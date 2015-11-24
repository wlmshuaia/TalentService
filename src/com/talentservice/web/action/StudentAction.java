package com.talentservice.web.action;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Project;
import com.talentservice.domain.Student;
import com.talentservice.domain.User;
import com.talentservice.utils.JsonUtils;
import com.talentservice.utils.OAUtils;
import com.talentservice.utils.UploadUtils;

@Controller("studentAction")
@Scope("prototype")
public class StudentAction extends BaseAction {
	
	private static final long serialVersionUID = -3838634290413660448L;
	
	private Student student = new Student() ;
	private User user ;
	private File upload ;
	
	/**
	 * 保存信息修改
	 * 	* 保存user表信息
	 *  * 保存student表信息
	 *  
	 * @return
	 */
	public String personal() {
		System.out.println("uid: "+user.getUid());
		User u = (User) this.baseService.getById(User.class, user.getUid()) ;
		u.setUsername(user.getUsername());
		this.baseService.update(u);
		
		String url = "" ;
		System.out.println("upload: "+upload);
		if(upload != null){
			System.out.println("upload2: "+upload==null);
			url = UploadUtils.saveUploadFile(upload);
			student.setGravatar(url) ;
		}
		System.out.println("url: "+url);
		student.setSid(u.getUserId()) ;
		
		// 修改student信息
		this.baseService.update(student) ;
		// 修改user信息
		this.baseService.update(u) ;
		
		writeJson(JsonUtils.getSuccessJson("保存成功")) ;
		
		return "personal" ;
	}
	
	/**
	 * 获取学生列表
	 * 
	 * @return
	 */
	public String getStudents() {
		List<Student> studentList = (List<Student>) this.baseService.getAll(Student.class);
		
		ActionContext.getContext().put("dataList", studentList);
		return "studentList";
	}
	
	/**
	 * 获取项目列表
	 * 
	 * @return
	 */
	public String getProjects() {
		User user = (User) this.baseService.getEntityByHql("from User where type = 0 and user_id = "+student.getSid()) ;
		Student stu = (Student) this.baseService.getById(Student.class, student.getSid());
		
		List<Project> pList = (List<Project>) this.baseService.getListById(Project.class, "undertaker_id", user.getUid());
		
		ActionContext.getContext().put("data", stu);
		ActionContext.getContext().put("dataList", pList);
		return "projectList" ;
	}
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Object getModel() {
		return student;
	}
}

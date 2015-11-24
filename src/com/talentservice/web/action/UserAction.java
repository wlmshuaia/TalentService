package com.talentservice.web.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Enterprise;
import com.talentservice.domain.School;
import com.talentservice.domain.Student;
import com.talentservice.domain.Teacher;
import com.talentservice.domain.User;
import com.talentservice.domain.Workman;
import com.talentservice.utils.OAUtils;
import com.talentservice.utils.UploadUtils;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {
	
	private static final long serialVersionUID = 11111122321312L;
	
	private User user = new User() ;
	
	private Student student ;
	
	private String idName ;
	private String ids ;
	
	// 图片流
	private InputStream inputStream ;
	// 图片地址
	private String url ;
	
	// 上传测试
	// 图片
	//注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;
    //提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;


	/**
	 * 获取用户信息
	 * 
	 * @return
	 */
	public String getPersonal(){
		User user = (User) OAUtils.fromSession("user");
		
		if(user != null){
			Short type = user.getType() ;
			switch(type){
			case 0:
				Student student = (Student) this.baseService.getById(Student.class, user.getUserId());
				ActionContext.getContext().put("data", student) ;
				break;
			case 1:
				School school = (School) this.baseService.getById(School.class, user.getUserId()) ;
				ActionContext.getContext().put("data", school) ;
				break;
			case 2:
				Workman workman = (Workman) this.baseService.getById(Workman.class, user.getUid()) ;
				ActionContext.getContext().put("data", workman) ;
				break;
			case 3:
				Enterprise enterprise = (Enterprise) this.baseService.getById(Enterprise.class, user.getUserId()) ;
				ActionContext.getContext().put("data", enterprise) ;
				break;
			}
		}
		
		ActionContext.getContext().put("user", user) ;
		
		return "personal" ;
	}
	
	/**
	 * 保存用户信息表单数据提交
	 * 
	 * @return
	 */
	public String personal() {
		System.out.println("personal...");
		System.out.println(student.getPhone()+", "+student.getBirthday()+", "+student.getDegree());
		
		return "personal" ;
	}
	
	/**
	 * 上传测试
	 * @return
	 * @throws IOException 
	 */
	public String upload() throws IOException {
		String url = UploadUtils.saveUploadFile(file) ;
		System.out.println("url: "+url);
        return SUCCESS;
	}
	
	/**
	 * 获取图片
	 * 
	 * @return
	 * @throws FileNotFoundException 
	 */
	public String getPic() throws FileNotFoundException {
		User u = (User) this.baseService.getById(User.class, user.getUid()) ;
		
		if(u != null){
			String gravatar = getGravatar(u) ;
			this.inputStream = new FileInputStream(new java.io.File(gravatar));
		}
		
		return SUCCESS ;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getIdName() {
		return idName;
	}
	
	public void setIdName(String idName) {
		this.idName = idName;
	}
	
	public String getIds() {
		return ids;
	}
	
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public Object getModel() {
		return user;
	}
}

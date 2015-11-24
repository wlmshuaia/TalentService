package com.talentservice.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.College;
import com.talentservice.domain.Project;
import com.talentservice.domain.Review;
import com.talentservice.domain.School;
import com.talentservice.domain.User;
import com.talentservice.utils.DataUtils;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.JsonUtils;
import com.talentservice.utils.OAUtils;
import com.talentservice.utils.UploadUtils;

@Controller("schoolAction")
@Scope("prototype")
public class SchoolAction extends BaseAction {
	private static final long serialVersionUID = 7294287945065181679L;
	
	private School school = new School() ;
	
	// 用户名
	private String username ;
	// 上传头像
	private File upload ;
	// 获取头像图片流
	private InputStream inputStream ;
	/* 分页   */
	private String start ;
	/* 评论  */
	private Review review ;
	
	/**
	 * 获取学校列表
	 * @return
	 */
	public String dataList() {
		if("".equals(start) || start == null){
			start = "1" ;
		}
		
		int sqlStart = (Integer.parseInt(start) - 1) * DataUtils.DATA_NUM ;
		List<School> sList = (List<School>) this.baseService.getByPage(School.class, " ", sqlStart, DataUtils.DATA_NUM) ;
		List<Map<String, Object>> schoolList = new ArrayList<Map<String,Object>>() ;
		
		for(School s : sList) {
			Map<String,Object> map = new HashMap<String, Object>() ;
			User u = (User) this.baseService.getEntityByHql("from User where type = 1 and user_id = "+s.getSid()) ;
			map.put("u", u);
			map.put("school", s);
			schoolList.add(map) ;
		}
		
		int count = this.baseService.getCount(Review.class, "") ;
		int end =  count%DataUtils.DATA_NUM == 0 ? count/DataUtils.DATA_NUM : (count/DataUtils.DATA_NUM+1) ;	// 最后一页
		int page = Integer.parseInt(start) ;
		
		if(page-3 >= 1) {
			start = String.valueOf(page - 2);
		}else{
			start = "1" ;
		}
		
		String endPage = "" ;
		if(page + 3 <= end){
			endPage = String.valueOf(page + 2) ;
		}else{
			endPage = String.valueOf(end) ;
		}
		
		ActionContext.getContext().put("start", start) ;	// 开始页
		ActionContext.getContext().put("end", endPage) ;	// 结束页
		ActionContext.getContext().put("page", page) ;		// 当前页
		ActionContext.getContext().put("count", count) ;		// 当前页
		ActionContext.getContext().put("dataList", schoolList) ;		// 当前页
		
		return "dataList" ;
	}
	
	/**
	 * 获取学校信息
	 * @return
	 */
	public String getSchool() {
		
		User user = (User) OAUtils.fromSession("user") ;
		
		if(user != null){
			long schoolId = user.getUserId() ;
			School school = (School) this.baseService.getById(School.class, schoolId) ;
			
			if("".equals(start) || start == null){
				start = "1" ;
			}
			
			int sqlStart = (Integer.parseInt(start) - 1) * DataUtils.DATA_NUM ;
			List<Review> rList = (List<Review>) this.baseService.getByPage(Review.class, " and touser_id = "+user.getUid(), sqlStart, DataUtils.DATA_NUM) ;
			List<Map<String, Object>> reviewList= new ArrayList<Map<String, Object>>() ;
			
			for(Review r : rList){
				Map<String, Object> map = new HashMap<String, Object>() ;
				User fromUser = r.getUserByFromuserId() ;
				String gravatar = getGravatar(fromUser) ;
				map.put("gravatar", gravatar) ;
				map.put("review", r) ;
				reviewList.add(map) ;
			}
			
			
			int count = this.baseService.getCount(Review.class, " and touser_id = "+user.getUid()) ;
			int end =  count%DataUtils.DATA_NUM == 0 ? count/DataUtils.DATA_NUM : (count/DataUtils.DATA_NUM+1) ;	// 最后一页
			int page = Integer.parseInt(start) ;
			
			if(page-3 >= 1) {
				start = String.valueOf(page - 2);
			}else{
				start = "1" ;
			}
			
			String endPage = "" ;
			if(page + 3 <= end){
				endPage = String.valueOf(page + 2) ;
			}else{
				endPage = String.valueOf(end) ;
			}
			
			List<Project> pList = (List<Project>) this.baseService.getListById(Project.class, "founder_id", user.getUid()) ;
			List<College> colleges = (List<College>) this.baseService.getListById(College.class, "school_id", schoolId) ;
			List<Map<String, Object>> collegeList = new ArrayList<Map<String,Object>>() ;
			//List<User> collegeList = new ArrayList<User>() ;
			
			for(College college : colleges){
				Map<String, Object> collegeL = new HashMap<String, Object>() ;
				User u = (User) this.baseService.getEntityByHql("from User where type = 5 and user_id = "+college.getCid()) ;
				collegeL.put("user", u) ;
				collegeL.put("college", college) ;
				collegeList.add(collegeL) ;
				//collegeList.add(u) ;
			}
			
			ActionContext.getContext().put("start", start) ;	// 开始页
			ActionContext.getContext().put("end", endPage) ;	// 结束页
			ActionContext.getContext().put("page", page) ;		// 当前页
			ActionContext.getContext().put("count", count) ;		// 当前页
			ActionContext.getContext().put("user", user) ;
			ActionContext.getContext().put("school", school) ; 
			ActionContext.getContext().put("collegeList", collegeList) ;
			ActionContext.getContext().put("reviewList", reviewList) ;
			ActionContext.getContext().put("projectList", pList) ;
		}
		
		return "schoolInfo" ;
	}
	
	/**
	 * 学校信息编辑
	 * @return
	 */
	public String infoEditUI() {
		School s = (School) this.baseService.getById(School.class, school.getSid()) ;
		User user = (User) this.baseService.getEntityByHql("from User where type = 1 and user_id = "+school.getSid()) ;
		
		ActionContext.getContext().put("user", user) ;
		ActionContext.getContext().put("school", s) ;
		return "infoEditUI" ;
	}
	
	/**
	 * 学校信息修改处理
	 * @return
	 */
	public String school() {
		System.out.println("school: "+username);
		// 保存学校名称
		User user = (User) this.baseService.getEntityByHql("from User where type = 1 and user_id = "+school.getSid());
		user.setUsername(username);
		this.baseService.update(user) ;
		
		System.out.println("upload: "+upload);
		// 保存头像
		String url = "" ;
		if(upload != null){
			url = UploadUtils.saveUploadFile(upload) ;
			school.setGravatar(url);
		}
		System.out.println("url: "+url);
		// 保存学校信息
		this.baseService.update(school) ;
		
		writeJson(JsonUtils.getSuccessJson("保存成功"));
		return "school" ;
	}
	
	/**
	 * 获取头像
	 * @return
	 * @throws FileNotFoundException 
	 */
	public String getPic() throws FileNotFoundException {
		User u = (User) OAUtils.fromSession("user") ;
		School s = (School) this.baseService.getById(School.class, u.getUserId()) ;
		this.inputStream = new FileInputStream(new java.io.File(s.getGravatar())) ;
		return SUCCESS ;
	}
	
	/**
	 * 高校评论
	 */
	public void review() {
		System.out.println("review...");
		User u = (User) OAUtils.fromSession("user") ;
		if(u != null){
			System.out.println("review..."+u.getUsername());
			System.out.println("review..."+review.getContent());
			
			School s = (School) this.baseService.getById(School.class, school.getSid()) ;
			User toUser = (User) this.baseService.getEntityByHql("from User where type = 1 and user_id = "+s.getSid()) ;
			review.setTime(DateUtils.formatDateTime(new Date()));
			review.setUserByFromuserId(u);
			review.setUserByTouserId(toUser);
			this.baseService.save(review) ;
			writeJson(JsonUtils.getSuccessJson("评论成功"));
		}
	}
	
	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	@Override
	public Object getModel() {
		return school;
	}

}
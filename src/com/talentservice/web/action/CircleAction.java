package com.talentservice.web.action;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Category;
import com.talentservice.domain.Circle;
import com.talentservice.domain.Comment;
import com.talentservice.domain.Project;
import com.talentservice.domain.Topic;
import com.talentservice.domain.User;
import com.talentservice.utils.DataUtils;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.OAUtils;

@Controller("circleAction")
@Scope("prototype")
public class CircleAction extends BaseAction {

	private static final long serialVersionUID = -3782565488436863701L;

	private Circle circle = new Circle() ;
	
	private String tid ;	// 话题ID
	private String content ;	// 评论内容
	private String category_id ;	// 分类Id
	
	private Topic topic ;// 话题
	
	/* 分页 */
	private String start ;
	
	/**
	 * 圈子列表
	 * @return
	 */
	public String dataList() {
		if("".equals(start) || start == null){
			start = "1" ;
		}
		
		int sqlStart = (Integer.parseInt(start) - 1) * DataUtils.DATA_NUM ;
		List<Circle> dataList = (List<Circle>) this.baseService.getByPage(Circle.class, "", sqlStart, DataUtils.DATA_NUM) ;
		
		int count = this.baseService.getCount(Circle.class, "");
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
		
		ActionContext.getContext().put("dataList", dataList) ;
		return listAction ;
	}
	
	/**
	 * 圈子详情
	 * @return
	 */
	public String getInfo() {
		Circle c = (Circle) this.baseService.getById(this.getModel().getClass(), circle.getCid()) ;
		
		if("".equals(start) || start == null){
			start = "1" ;
		}
		
		int sqlStart = (Integer.parseInt(start) - 1) * DataUtils.DATA_NUM ;
		List<Topic> list = (List<Topic>) this.baseService.getByPage(Topic.class, " and circle_id = '"+c.getCid()+"'", sqlStart, DataUtils.DATA_NUM);
		
		int count = this.baseService.getCount(Topic.class, " and circle_id = '"+c.getCid()+"'");
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
		
		ActionContext.getContext().put("data", c) ;
		ActionContext.getContext().put("dataList", list) ;
		return getInfo ;
	}
	
	/**
	 * 添加圈子视图
	 * 
	 * @return
	 */
	public String circleAddUI() {
		List<Category> cateList = (List<Category>) this.baseService.getAll(Category.class) ;
		ActionContext.getContext().put("cateList", cateList) ;
		return "addUI" ;
	}
	
	/**
	 * 添加圈子表单处理
	 * 
	 * @return
	 */
	public String circleAdd() {
		User user = (User) OAUtils.fromSession("user");
		Category category = (Category) this.baseService.getById(Category.class, Long.parseLong(category_id));
		circle.setFoundtime(DateUtils.formatDateTime(new Date())) ;
		circle.setUser(user);
		circle.setCategory(category) ;
		this.baseService.save(circle) ;
		
		return "action2action" ;
	}
	
	/**
	 * 添加话题视图
	 * 
	 */
	public void addTopicUI(){
		
	}
	
	/**
	 * 添加话题
	 * 
	 */
	public String addTopic() {
		Circle c = (Circle) this.baseService.getById(Circle.class, circle.getCid()) ;
		User user = (User) OAUtils.fromSession("user") ;
		
		topic.setFoundtime(DateUtils.formatDateTime(new Date())) ;
		topic.setCircle(c) ;
		topic.setUser(user) ;
		topic.setZannumber(0);
		this.baseService.save(topic) ;
		
		ActionContext.getContext().put("cid", circle.getCid()) ;
		return "circleInfo2action" ;
	}
	
	/**
	 * 话题列表
	 * @return
	 */
	public String topicList() {
		List<Topic> list = (List<Topic>) this.baseService.getListById(Topic.class, "circle_id", circle.getCid()) ;
		ActionContext.getContext().put("dataList", list) ;
		return "topicList" ;
	}
	
	/**
	 * 话题信息，评论列表
	 * @return
	 */
	public String topicInfo() {
		Topic topic = (Topic) this.baseService.getById(Topic.class, Long.parseLong(tid)) ;
		
		if("".equals(start) || start == null){
			start = "1" ;
		}
		
		int sqlStart = (Integer.parseInt(start) - 1) * DataUtils.DATA_NUM ;
		List<Comment> commentList = (List<Comment>) this.baseService.getByPage(Comment.class, " and topic_id = '"+topic.getTid()+"'", sqlStart, DataUtils.DATA_NUM);
		
		int count = this.baseService.getCount(Comment.class, " and topic_id = '"+topic.getTid()+"'") ;
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
		
		ActionContext.getContext().put("data", topic) ;		// 话题详情
		ActionContext.getContext().put("dataList", commentList) ;	// 评论列表
		return "topicInfo" ;
	}
	
	/**
	 * 添加评论视图
	 * 
	 * @return
	 */
	public String addCommentUI(){
		
		return "addCommentUI";
	}
	
	/**
	 * 添加评论
	 * @return
	 */
	public String addComment() {
		Comment comment = new Comment() ;
		Date commenttime = new Date() ;
		Topic topic = (Topic) this.baseService.getById(Topic.class, Long.parseLong(tid)) ;
		User user = (User) OAUtils.fromSession("user") ;
		
		comment.setContent(content) ;
		comment.setCommenttime(DateUtils.formatDateTime(commenttime)) ;
		comment.setTopic(topic) ;
		comment.setUser(user) ;
		comment.setZannumber(0) ;
		
		this.baseService.save(comment) ;
		
		ActionContext.getContext().put("tid", tid) ;
		return "topicInfo2action" ;
	}
	
	/**
	 * 话题点赞
	 * 
	 */
	public void topicZan() {
		Topic topic = (Topic) this.baseService.getById(Topic.class, Long.parseLong(tid));
		topic.setZannumber(topic.getZannumber()+1);
		this.baseService.update(topic) ;
		
		String content = "{\"value\":\""+topic.getZannumber()+"\"}" ;
		writeJson(content) ;
	}
	
	/**
	 * 评论点赞
	 */
	public void zan() {
		Comment comment = (Comment) this.baseService.getById(Comment.class, circle.getCid()) ;
		comment.setZannumber(comment.getZannumber()+1);
		this.baseService.update(comment) ;
		
		/*
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        jsonobj.put("value", comment.getZannumber());
        jsonArray.add(jsonobj) ;
        
        writeOneToPage("zan", jsonArray) ;
        */
		
		String content = "{\"value\":\""+comment.getZannumber()+"\"}" ;
		writeJson(content) ;
        
	}
	
	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Object getModel() {
		return circle;
	}
	
}

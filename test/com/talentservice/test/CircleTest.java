package com.talentservice.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.talentservice.domain.Circle;
import com.talentservice.domain.Comment;
import com.talentservice.domain.Topic;
import com.talentservice.domain.User;
import com.talentservice.service.base.BaseService;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.OAUtils;

public class CircleTest extends BaseSpring {
	
	@Test
	public void testList() {
		
		List<Circle> dataList = (List<Circle>) baseService.getAll(Circle.class) ;
		
		for(Circle circle : dataList){
			System.out.println("name: "+circle.getCirclename()+", "+circle.getCategory().getCatename());
		}
	}
	
	@Test
	public void testTopicList() {
		//List<Topic> topicList = (List<Topic>) baseService.getListById(Topic.class, "circle_id", (long)1) ;
		List<Topic> topicList = (List<Topic>) baseService.getByPage(Topic.class, " and circle_id = '"+(long)1+"' ", 0, 2);
		
		for(Topic t : topicList){
			System.out.println("title: "+t.getTitle());
		}
	}
	
	@Test
	public void testTopicInfo() {
		String topicId = "1" ;
		
		Topic t = (Topic) this.baseService.getById(Topic.class, Long.parseLong(topicId)) ;
		System.out.println("title: "+t.getTitle());
		
		
		List<Comment> commentList = (List<Comment>) this.baseService.getListById(Comment.class, "topic_id", Long.parseLong(topicId)) ;
		for(Comment c : commentList){
			System.out.println(c.getContent());
		}
	}
	
	@Test
	public void testAddComment() {
		Comment comment = new Comment() ;
		Date commenttime = new Date() ;
		Topic topic = (Topic) this.baseService.getById(Topic.class, Long.parseLong("2")) ;
		User user = (User) OAUtils.fromSession("user") ;
		String content = "评论测试" ;
		
		comment.setContent(content) ;
		comment.setCommenttime(DateUtils.formatDate(commenttime)) ;
		comment.setTopic(topic) ;
		if(user != null){
			comment.setUser(user) ;
		}
		
		this.baseService.save(comment) ;
	}
	
	@Test
	public void testZan() {
		Long cid = 5L ;
		Comment comment = (Comment) this.baseService.getById(Comment.class, cid) ;
		comment.setZannumber(comment.getZannumber()+1);
		this.baseService.update(comment) ;
	}
}

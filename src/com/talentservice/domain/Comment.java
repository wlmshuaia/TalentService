package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Long cid;
	private Topic topic;
	private Comment comment;
	private User user;
	private String content;
	private String commenttime;
	private Integer zannumber;
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Topic topic, Comment comment, User user, String content,
			String commenttime, Integer zannumber, Set comments) {
		this.topic = topic;
		this.comment = comment;
		this.user = user;
		this.content = content;
		this.commenttime = commenttime;
		this.zannumber = zannumber;
		this.comments = comments;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommenttime() {
		return this.commenttime;
	}

	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}

	public Integer getZannumber() {
		return this.zannumber;
	}

	public void setZannumber(Integer zannumber) {
		this.zannumber = zannumber;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}
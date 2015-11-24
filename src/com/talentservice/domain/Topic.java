package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Long tid;
	private Circle circle;
	private User user;
	private String title;
	private String content;
	private String foundtime;
	private Integer zannumber;
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** full constructor */
	public Topic(Circle circle, User user, String title, String content,
			String foundtime, Integer zannumber, Set comments) {
		this.circle = circle;
		this.user = user;
		this.title = title;
		this.content = content;
		this.foundtime = foundtime;
		this.zannumber = zannumber;
		this.comments = comments;
	}

	// Property accessors

	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Circle getCircle() {
		return this.circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFoundtime() {
		return this.foundtime;
	}

	public void setFoundtime(String foundtime) {
		this.foundtime = foundtime;
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
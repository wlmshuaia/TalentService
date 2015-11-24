package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Circle entity. @author MyEclipse Persistence Tools
 */

public class Circle implements java.io.Serializable {

	// Fields

	private Long cid;
	private Category category;
	private User user;
	private String circlename;
	private String description;
	private String foundtime;
	private Set userCircles = new HashSet(0);
	private Set topics = new HashSet(0);

	// Constructors

	/** default constructor */
	public Circle() {
	}

	/** full constructor */
	public Circle(Category category, User user, String circlename,
			String description, String foundtime, Set userCircles, Set topics) {
		this.category = category;
		this.user = user;
		this.circlename = circlename;
		this.description = description;
		this.foundtime = foundtime;
		this.userCircles = userCircles;
		this.topics = topics;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCirclename() {
		return this.circlename;
	}

	public void setCirclename(String circlename) {
		this.circlename = circlename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFoundtime() {
		return this.foundtime;
	}

	public void setFoundtime(String foundtime) {
		this.foundtime = foundtime;
	}

	public Set getUserCircles() {
		return this.userCircles;
	}

	public void setUserCircles(Set userCircles) {
		this.userCircles = userCircles;
	}

	public Set getTopics() {
		return this.topics;
	}

	public void setTopics(Set topics) {
		this.topics = topics;
	}

}
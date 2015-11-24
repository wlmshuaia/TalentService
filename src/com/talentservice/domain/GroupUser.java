package com.talentservice.domain;

/**
 * GroupUser entity. @author MyEclipse Persistence Tools
 */

public class GroupUser implements java.io.Serializable {

	// Fields

	private Long id;
	private Group group;
	private User user;

	// Constructors

	/** default constructor */
	public GroupUser() {
	}

	/** full constructor */
	public GroupUser(Group group, User user) {
		this.group = group;
		this.user = user;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
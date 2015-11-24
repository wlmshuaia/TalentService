package com.talentservice.domain;

/**
 * UserCategory entity. @author MyEclipse Persistence Tools
 */

public class UserCategory implements java.io.Serializable {

	// Fields

	private Long id;
	private Category category;
	private User user;

	// Constructors

	/** default constructor */
	public UserCategory() {
	}

	/** full constructor */
	public UserCategory(Long id, Category category, User user) {
		this.id = id;
		this.category = category;
		this.user = user;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
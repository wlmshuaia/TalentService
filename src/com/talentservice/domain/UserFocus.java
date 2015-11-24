package com.talentservice.domain;

/**
 * UserFocus entity. @author MyEclipse Persistence Tools
 */

public class UserFocus implements java.io.Serializable {

	// Fields

	private Long id;
	private User userByUserId;
	private User userByFocusId;

	// Constructors

	/** default constructor */
	public UserFocus() {
	}

	/** full constructor */
	public UserFocus(Long id, User userByUserId, User userByFocusId) {
		this.id = id;
		this.userByUserId = userByUserId;
		this.userByFocusId = userByFocusId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserByUserId() {
		return this.userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

	public User getUserByFocusId() {
		return this.userByFocusId;
	}

	public void setUserByFocusId(User userByFocusId) {
		this.userByFocusId = userByFocusId;
	}

}
package com.talentservice.domain;

/**
 * UserUser entity. @author MyEclipse Persistence Tools
 */

public class UserUser implements java.io.Serializable {

	// Fields

	private Long id;
	private User userByFriendId;
	private User userByUserId;

	// Constructors

	/** default constructor */
	public UserUser() {
	}

	/** full constructor */
	public UserUser(Long id, User userByFriendId, User userByUserId) {
		this.id = id;
		this.userByFriendId = userByFriendId;
		this.userByUserId = userByUserId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserByFriendId() {
		return this.userByFriendId;
	}

	public void setUserByFriendId(User userByFriendId) {
		this.userByFriendId = userByFriendId;
	}

	public User getUserByUserId() {
		return this.userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

}
package com.talentservice.domain;

/**
 * UserCircle entity. @author MyEclipse Persistence Tools
 */

public class UserCircle implements java.io.Serializable {

	// Fields

	private Long id;
	private Circle circle;
	private User user;

	// Constructors

	/** default constructor */
	public UserCircle() {
	}

	/** full constructor */
	public UserCircle(Long id, Circle circle, User user) {
		this.id = id;
		this.circle = circle;
		this.user = user;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
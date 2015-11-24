package com.talentservice.domain;

/**
 * UserLabel entity. @author MyEclipse Persistence Tools
 */

public class UserLabel implements java.io.Serializable {

	// Fields

	private Long id;
	private Label label;
	private User user;

	// Constructors

	/** default constructor */
	public UserLabel() {
	}

	/** full constructor */
	public UserLabel(Long id, Label label, User user) {
		this.id = id;
		this.label = label;
		this.user = user;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Label getLabel() {
		return this.label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
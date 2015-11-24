package com.talentservice.domain;

/**
 * AdminRole entity. @author MyEclipse Persistence Tools
 */

public class AdminRole implements java.io.Serializable {

	// Fields

	private Long id;
	private Role role;
	private Admin admin;

	// Constructors

	/** default constructor */
	public AdminRole() {
	}

	/** full constructor */
	public AdminRole(Role role, Admin admin) {
		this.role = role;
		this.admin = admin;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
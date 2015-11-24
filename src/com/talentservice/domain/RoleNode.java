package com.talentservice.domain;

/**
 * RoleNode entity. @author MyEclipse Persistence Tools
 */

public class RoleNode implements java.io.Serializable {

	// Fields

	private Long id;
	private Role role;
	private Node node;

	// Constructors

	/** default constructor */
	public RoleNode() {
	}

	/** full constructor */
	public RoleNode(Role role, Node node) {
		this.role = role;
		this.node = node;
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

	public Node getNode() {
		return this.node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

}